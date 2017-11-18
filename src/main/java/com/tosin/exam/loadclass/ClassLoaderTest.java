package com.tosin.exam.loadclass;

import java.util.Date;
import java.util.List;

import sun.misc.Launcher;

/**
 * 
 * 类加载器详解 http://blog.csdn.net/jiangwei0910410003/article/details/17733153
 * */
public class ClassLoaderTest {
	public static void main(String[] args) throws Exception{
		
		test02();
	}
	public static void test02(){
		try {
			String name="com.tosin.exam.loadclass.ClassLoaderAttachment";
			name="com.tosin.exam.loadclass.ClassLoaderAttachment";
			Class clsDate = new MyClassLoader("class_temp").loadClass(name);
			Date date = (Date) clsDate.newInstance();
			System.out.println("ClassLoader:"+date.getClass().getClassLoader().getClass().getName());
			System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test01(){
		System.out.println("ClassLoaderText类的加载器的名称:"+ClassLoaderTest.class.getClassLoader().getClass().getName());
		System.out.println("System类的加载器的名称:"+System.class.getClassLoader());
		System.out.println("List类的加载器的名称:"+List.class.getClassLoader());
		
		ClassLoader cl = ClassLoaderTest.class.getClassLoader();
		if(cl != null){
			System.out.print(cl.getClass().getName()+"-->");
			cl=cl.getParent();
		}
		System.out.println(cl);
		Launcher l;
//		Launcher$AppClassLoader acl;
//		Launcher$ExtClassLoader ecl;
		
		System.out.println("默认类加载器的名称:"+ClassLoaderTest.class.getClassLoader().getSystemClassLoader());
		
		ClassLoaderAttachment cla = new ClassLoaderAttachment();
		System.out.println(cla);
		
	}
}
