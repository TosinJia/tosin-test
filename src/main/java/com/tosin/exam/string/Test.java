package com.tosin.exam.string;

import java.awt.HeadlessException;
import java.io.UnsupportedEncodingException;

public class Test {
	public static void main(String[] args) throws Exception {
//		test01();
//		test0101();
//		test02();
//		testByte();
		test02_S();
	}
	
	/**
	 *	3、编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串，但要保证汉字不被截取半个，如“我ABC”，4，应该截取“我AB”，输入“我ABC汉DEF”，6，应该输出“我ABC”，而不是“我ABC+汉的半个”。
	 *  汉字编码	http://bianma.supfree.net/
	 * @throws UnsupportedEncodingException 
	 * */
	public static void test02_S() throws UnsupportedEncodingException{
		String str ="我a要提升bc技术defg能力";
		int num = trimGBK(str.getBytes("GBK"), 8);
		System.out.println(str.substring(0, num));
		int num2 = trimGBK_01(str.getBytes("GBK"), 8);
		System.out.println(str.substring(0, num2));
	}
	public static int trimGBK(byte[] buf, int n){
		int num=0;
		boolean bChineseFirstHalf=false;
		for (int i = 0; i < n; i++) {
			if(buf[i]<0 && !bChineseFirstHalf){
				bChineseFirstHalf=true;
			}else{
				num++;
				bChineseFirstHalf=false;
			}
		}
		return num;
	}
	public static int trimGBK_01(byte[] buf, int n){
		int num=0;
		boolean preChineseCharacterFirstHalf=false;
		for (int i = 0; i < n; i++) {
			if(buf[i]<0){
				if(preChineseCharacterFirstHalf){
					preChineseCharacterFirstHalf=false;
					num++;
				}else{
					preChineseCharacterFirstHalf=true;
				}
			}else{
				preChineseCharacterFirstHalf=false;
				num++;
			}
		}
		return num;
	}
	//连续汉字解决不了
	public static int trimGBK_E01(byte[] buf, int n){
		int num=0;
		for (int i = 0; i < n; i++) {
			if(buf[i]<0){
				if(i>0){
					if(buf[i-1]<0){
						num++;
					}
				}
			}else{
				num++;
			}
		}
		return num;
	}
	
	public static void test02() throws UnsupportedEncodingException{
		String str = "我a要提升bc技术defg能力";
		System.out.println(subStr(str, 10));
	}
	public static String subStr(String str, int byteCount){
		String subStr = null;
		try {
			int endIndex=0;
			byte[] datas = str.getBytes("GBK");
			
			if(datas[byteCount-1]<0){
				endIndex=byteCount;
			}else{
				endIndex=byteCount-1;
			}
			byte[] newDatas=new byte[endIndex+1];
			for (int i = 0; i < newDatas.length; i++) {
				newDatas[i]=datas[i];
			}
			subStr = new String(newDatas, "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
//		return str.substring(0, endIndex);	//错误 一个汉字也占一位
		return subStr;
	}
	
	/**
	 * 计算器-程序员-字节-16进制、10进制、2进制
	 * */
	public static void testByte(){
		System.out.println("Byte:\tMAX_VALUE:"+Byte.MAX_VALUE+"\tMinValue:"+Byte.MIN_VALUE);
		byte b = 0;
		for (int i = 0; i < 256; i++) {
			b+=1;
			System.out.println(b+"\tHex:"+Integer.toHexString(b&0xff).toUpperCase());
		}
	}	
	
	// 31、String s = "Hello";s = s + " world!";这两行代码执行后，原始的String对象中的内容到底变了没有？
	public static void test01() {
		String s = "Hello";
		s = s + "world!";
		System.out.println("执行完成！");
	}
	
	public static void test0101(){
		String s = "Hello";
		char[] value = s.toCharArray();
		int hashCode = hashCode(0,5,0,value);	//0,5,0,Hello 69609650
		System.out.println(hashCode);
	}
	
	//String. hashCode
	public static int hashCode(int hash, int count, int offset, char[] value) {
		int h = hash;
		int len = count;
		if (h == 0 && len > 0) {
			int off = offset;
			char val[] = value;

			for (int i = 0; i < len; i++) {
				h = 31 * h + val[off++];
			}
			hash = h;
		}
		return h;
	}
	


}
