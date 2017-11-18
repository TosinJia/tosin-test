package com.tosin.exam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;


/**
 * 
 * 25. 要从文件"file.dat"中读出第10个字节到变量c中
 * */
public class Test {
	public static void main(String[] args){
		testRandomAccessFile();
//		testFileInputStream();
	}
	
	public static void testRandomAccessFile(){
		try {
			RandomAccessFile in = new RandomAccessFile("F:\\testworkspace\\file.dat", "r");
//			in.skipBytes(9);
			in.seek(9);
			int c = in.readByte();
			System.out.println(c);
			
			System.out.println();
			int cl;
			while((cl=in.read()) != -1){
				System.out.print(cl+",");
			}
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void testFileInputStream(){
		try {
			FileInputStream in = new FileInputStream("F:\\testworkspace\\file.dat");
			in.skip(9);
			int c = in.read();
			System.out.println(c);
			System.out.println();
			int cl;
			while((cl=in.read()) != -1){
				System.out.print(cl+",");
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
