package com.tosin.exam.loadclass;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MyClassLoader extends ClassLoader {
	
	private String classDir;
	
	public MyClassLoader() {
		super();
	}

	public MyClassLoader(String classDir) {
		super();
		this.classDir = classDir;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String classFilePath=classDir+"/"+name+".class";
		try {
			InputStream is = new FileInputStream(classFilePath);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			encodeAndDecode(is, baos);
			byte[] byteArray=baos.toByteArray();
			return super.defineClass(byteArray, 0, byteArray.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.findClass(name);
	}

	public static void main(String[] args) throws Exception{
		//E:\MyEnviroment\WorkingEnvironment\项目整理\中交天健\自建车联网平台\socket\tosin-test\target\classes\com\tosin\exam\loadclass\ClassLoaderAttachment.class
		String srcPath = args[0];
		String descPath = args[1];
		String fileName=srcPath.substring(srcPath.lastIndexOf("\\")+1);
		descPath=descPath+"\\"+fileName;
		InputStream is=null;
		OutputStream os=null;
		try {
			is = new FileInputStream(srcPath);
			os = new FileOutputStream(descPath);
			encodeAndDecode(is, os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			is.close();
			os.close();
		}
		
	}
	
	/**
	 * 加密解密算法
	 * */
	public static void encodeAndDecode(InputStream is, OutputStream os) throws Exception{
		int byteData;
		while ((byteData=is.read()) != -1) {
			System.out.println("原始数据："+Integer.toBinaryString(byteData));
			byteData=byteData^0xff;	//异或
			System.out.println("异或处理后数据："+Integer.toBinaryString(byteData));
			os.write(byteData);
		}
	}
}
