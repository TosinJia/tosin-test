package com.tosin.exam.string;

/**
 * 预测：test ok and gbc
 * good and gbc
 * */
public class Example {
	String str = new String("good");
	char[] ch = {'a','b','c'};
	
	public void exchange(String str, char[] ch){
		str = "test ok";
		ch[0] = 'g';
	}
	
	public static void main(String[] args){
		Example ex = new Example();
		ex.exchange(ex.str, ex.ch);
		System.out.print(ex.str+" and ");
		System.out.print(ex.ch);
	}
}
