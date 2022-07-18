package com.testingspock

import spock.lang.Specification

class LengthStringSpec extends Specification{
	def "length of different String "(){
		expect: name.size() == length
		
		where:
		name	|	length
		"Rajesh"|	6
		"Abhinav"|	7
		"Bhaskar"|	77
	}
}
