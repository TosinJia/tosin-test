package com.tosin.exam;

/**
 * 预估结果：The value of c:0
 * 实际结果 与预估结构相符
 * */
public class Constructor {
	private int a,b,c;
	public void Constructor(){
//	public Constructor(){
		a=3;
		b=5;
		c=a+b;
	}
	public void test(){
		System.out.println("The value of c:"+c);
	}
	public static void main(String[] args){
		Constructor c = new Constructor();
		c.test();
	}
}
