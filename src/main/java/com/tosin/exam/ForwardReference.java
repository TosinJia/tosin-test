package com.tosin.exam;


/**
 * 预估结果为：first=2
 * 实际结果为：first=0
 * java修饰符范围	http://blog.csdn.net/peisl/article/details/6343386
 * 
 * 
 * Thinking In Java 4th Java access specifiers .......... 153
 * Thinking in Java 4版	5.2 Java 访问指示符
 * 构造顺序
 * 
 * */
public class ForwardReference {
	static int test01;
	static int test02=2;
	static int first=test();
	static int second=2;
	static int test(){
		return second;
	}
	public static void main(String[] args){
		System.out.println("first="+first);
	}
}
