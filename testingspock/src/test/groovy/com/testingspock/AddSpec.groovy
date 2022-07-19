package com.testingspock

import spock.lang.*

class AddSpec extends Specification{
	
	def setupSpec() {
		println("setup before class")
	}
	def cleanupSpec() {
		println("teardown after class")
	}
	
	def setup() {
		println("inside constructor")
	}
	def cleanup() {
		println("cleanup")
	}
	
	
	def add=new Add()
	def n1=20
	def n2=30
	def result=0
	
	def "Add Two Number"(){
		when: "Initializing a class"
		result=add.addTwoNumber(3,5)
		then: "result of numbers "
		result == 8
	}
	
	def "sustract Two Number"(){
		when: "Initializing a class"
		result=add.substractTwoNumber(3,5)
		then: "result of numbers "
		result == -2
	}
	def "multiply Two Number"(){
		when: "Initializing a class"
		result=add.multiplyTwoNumber(3,5)
		then: "result of numbers "
		result == 15
	}
	def "divide Two Number"(){
		when: "Initializing a class"
		result=add.divideTwoNumber(3,5)
		then: "result of numbers "
		result == 0
	}
	
	def "comparing strings"(){
		given: "two input"
			String str1="revature"
			String str2="REVATURE"
		when: ""
			str1=str1.toLowerCase()
			str2=str2.toLowerCase()
		then: ""
			str1==str2
	}
	def "arraylist"(){
		given:
			def emp=new ArrayList<Employee>();
			emp.add(new Employee("Rajesh","Bangalore"))
			emp.add(new Employee("Mohan","Chennai"))
			emp.add(new Employee("Deepak","Hyderabad"))
		expect:
			emp*.city==["Bangalore","Chennai","Hyderabad"]
			
	}
	def "exception handling"(){
		when:
			add.myMethod()
		then:
			def e=thrown(RuntimeException)
			e.message=="this method is having exception"
	}
	
	@Unroll
	def "data driven"(){
		when:
			result=add.addTwoNumber(input1,input2)
		then: "result of numbers "
			result == expectedResult
		where:
			input1	|input2	|expectedResult
			10		|20		|30
			20		|40		|60
			70		|45		|118
	}
}



















