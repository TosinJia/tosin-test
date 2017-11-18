package com.tosin.exam.inherit;

public abstract class MyAbstractClass {
	public int constInt=5;
	
	public void method(){}
	
	public abstract void method(int a);
//	constInt = constInt+5;	//Syntax error on token "constInt", VariableDeclaratorId expected after this token
//	public int method();	//This method requires a body instead of a semicolon
//	public abstract void anotherMethod(){};	//Abstract methods do not specify a body
}
