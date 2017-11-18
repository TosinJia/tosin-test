package com.tosin.exam.inherit;

import java.util.Date;

/**
 * Object public final native Class<?> getClass(); final 子类不能覆盖该方法
 * 
 * */
public class Test01 extends Date {
	public void test(){
		System.out.println(super.getClass().getName());
		System.out.println(this.getClass().getName());
		System.out.println(this.getClass().getSuperclass().getName());
	}
	
	public static void main(String[] args){
		Test01 t1 = new Test01();
		t1.test();
	}
}
