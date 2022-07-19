package com.testingspock;

public class Add {
	public int addTwoNumber(int i,int j) {
		return i+j;
	}
	public int substractTwoNumber(int i,int j) {
		return i-j;
	}
	public int multiplyTwoNumber(int i,int j) {
		return i*j;
	}
	public int divideTwoNumber(int i,int j) {
		return i/j;
	}
	public int myMethod() {
		throw new RuntimeException("this method is having exception");
	}
}
