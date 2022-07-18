package com.testingspock


import spock.lang.*

class AddSpec extends Specification{
	
	def "Add Two Number"(){
		when: "Initializing a class"
		def add=new Add();
		then: "result of numbers "
		add.addTwoNumber(3,5) == 8
	}
}
