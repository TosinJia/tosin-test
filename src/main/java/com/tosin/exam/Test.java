package com.tosin.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import ch.qos.logback.core.util.TimeUtil;

public class Test {

	
	public static void main(String[] args) {
//		testString();
//		testNumber();
//		testConstrunctor();
//		testList();
		System.out.println(testSwitchCaseStatement(2));
	}
	
	public static int testSwitchCaseStatement(int i){
		int result=0;
		switch (i) {
		case 1:
			result = result + i;
		case 2:
			result = result + i*2;
		case 3:
			result = result + i*3;
		}
		return result;
	}
	
	public static void testList(){
//		List list = new ArrayList();
		ArrayList list = new ArrayList();
		for (int i=0; i<20; i++) {
			list.add(i);
		}
		System.out.println(list.size());
		ArrayList list2 = new ArrayList(20);
		System.out.println(list2.size());
		
		
	}
	
	public static void testConstrunctor(){
		Date now = new Date();
		Date d1 = (Date) now.clone();
		System.out.println("对象"+now + "\tclone():"+d1);
		OutputStream out=null;
		ObjectOutputStream oos=null;
		InputStream in=null;
		ObjectInputStream ois=null;
		try {
			File file = new File("F:\\testworkspace\\1.txt"); 
			out = new FileOutputStream(file);
			oos = new ObjectOutputStream(out);
			oos.writeObject(now);
			
			
			in = new FileInputStream(file);
			ois = new ObjectInputStream(in);
			Date d2 = (Date) ois.readObject();
			System.out.println("对象"+now + "\t反序列化:"+d2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(in != null)
					in.close();
				if(ois != null)
					ois.close();
				
				if(oos != null)
					oos.close();
				if(out != null)
					out.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void testString(){
		System.out.println("5"+2);
		int i;
//		System.out.println(i);	//The local variable i may not have been initialized
		Integer i2;
//		System.out.println(i2);	//The local variable i2 may not have been initialized
		
		String s;
//		System.out.println("s="+s);	//The local variable s may not have been initialized
		Date date;
//		System.out.println(date);	//The local variable date may not have been initialized
		
		/////////////////////////////////////////////////
		String x="hello";
		String y="world";
		String z=new String("helloworld");
		String a="helloworld";
		
		System.out.println("x+y equal z:"+(x+y).equals(z));	//预估结果：true;
		System.out.println("a==z:"+(a==z));					//预估结果：false;
		System.out.println("x==hello:"+(x=="hello"));		//预估结果：true;
		System.out.println("a==helloworld:"+(a=="hello"+"world"));	//预估结果：true;
		System.out.println("a==x+y:"+(a==x+y));						//预估结果：false;
	}
	
	public static void testNumber(){
		int imax = Integer.MAX_VALUE;
		int imin = Integer.MIN_VALUE;
		System.out.println("最大值："+imax+"\t最小值："+imin);
		int i1 = imax+1;
		System.out.println(i1);
		
		System.out.println("=======================================");
		double dNan = Double.NaN;
		double dNan2 = Double.longBitsToDouble(0x7ff8000000000000L);
		System.out.println(dNan+"\t"+dNan2);
		double d =100;
		System.out.println(dNan>d || dNan<=d);
		System.out.println("=======================================");
		double d1=0.6332;
		Double d2=0.6332;
		float f1=0.6332f;
		Float f2=0.6332f;
	}
	
	public static void testCollection(){
		
		Collection c = null;
		c=null;
		
		Throwable t;
		
		Serializable s;
	}
}
