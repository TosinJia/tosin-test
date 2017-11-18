package com.tosin.exam.inherit;


/**
 * 
 * 
 * 预期结果：
 * Base tell name:Base
 * Base print name:Base
 * Derived tell name:derived
 * Derived print name:derived
 * 实际结果：
 * Derived tell name:null
 * Derived print name:null
 * Derived tell name:derived
 * Derived print name:derived
 * */
public class Derived extends Base {
//public class Derived {

	private String name="derived";
	public Derived() {
		super();
		tellName();
		printName();
	}
	public void tellName(){
		System.out.println("Derived tell name:"+name);
	}
	public void printName(){
		System.out.println("Derived print name:"+name);
	}
	
	public static void main(String[] args){
		new Derived();
//		new Base();
	}
}

class Base{
	private String name="Base";
	public Base() {
		super();
		tellName();
		printName();
	}
	public void tellName(){
		System.out.println("Base tell name:"+name);
	}
	public void printName(){
		System.out.println("Base print name:"+name);
	}
}
