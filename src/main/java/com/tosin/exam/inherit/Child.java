package com.tosin.exam.inherit;

class People{
	String name;
	
	public People(){
		System.out.println(1);
	} 
	public People(String name){
		System.out.println(2);
		this.name=name;
	}
}

class Child extends People {
	People father;
	public Child(String name){
		super();	//Constructor call must be the first statement in a constructor
		System.out.println(3);
		this.name=name;
		father=new People(name+":F");
	}
	
	public Child() {
		super();
		System.out.println(4);
	}



	public static void main(String[] args){
		new Child("mike");
	}
}
