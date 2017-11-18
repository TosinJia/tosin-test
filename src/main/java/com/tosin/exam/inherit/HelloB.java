package com.tosin.exam.inherit;

/**
 * 
 * 各个代码段执行顺序
 * 
 * new HelloA();
 * static A
 * I'm A class
 * HelloA
 * 
 * new HelloB();
 * static A
 * static B
 * I'm A class		I'm A class
 * I'm B class		HelloA
 * HelloA			I'm B class
 * HelloB			HelloB
 * 
 * */
class HelloA{
	public HelloA(){
		super();
		System.out.println("HelloA");
	}
	{
		System.out.println("I'm A class");
	}
	static{
		System.out.println("static A");
	}
}

public class HelloB extends HelloA {
	public HelloB(){
		super();
		System.out.println("HelloB");
	}
	{
		System.out.println("I'm B class");
	}
	static{
		System.out.println("static B");
	}
	
	public static void main(String[] args){
//		HelloA a = new HelloA();
		HelloB b = new HelloB();
		
	}
}
