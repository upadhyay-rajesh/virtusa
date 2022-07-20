package com.testingspock

import groovy.sql.Sql
import spock.lang.*


class Publisher{
	def subscribers=[]
	
	def send(event) {
		subscribers.each{
			try {
				it.receive(event)
			}
			catch(Exception e) {
				e.printStackTrace()
			}
		}
	}
}

interface Subscriber{
	def receive(event)
}


class AddSpec extends Specification{
	
	def pub=new Publisher()
	def sub1=Mock(Subscriber);
	def sub2=Mock(Subscriber);
	
	def setup() {
		pub.subscribers <<sub1 <<sub2
	}
	
	def "deliver to all subscriber"(){
		when:
			pub.send("event")
		then:
			1*sub1.receive("event")
			1*sub2.receive("event")
	}
	
	
	
	
	@Shared sql=Sql.newInstance("jdbc:mysql://localhost:3306/virtusa","root","rajesh","com.mysql.jdbc.Driver");
	
	
	def setupSpec() {
		sql.execute("create table employee(id int primary key, name varchar(23),email varchar(23),age int(12),empVisit int(12))");
		sql.execute("insert into employee values(1,'Rajesh','abc@yahoo.com',43,12)");
		sql.execute("insert into employee values(2,'Bhasker','abc1@yahoo.com',23,2)");
		sql.execute("insert into employee values(3,'Dhiman','abc2@yahoo.com',23,127)");
		sql.execute("insert into employee values(4,'Harsh','abc3@yahoo.com',23,124)");
	}
	
	
	def "employee name"(){
		expect:
			b==23
		where:
			[a,b,c] << sql.rows("select name,age,empVisit from employee")
	}
	
	
	def cleanupSpec() {
		println("teardown after class")
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



















