package com.tosin.exam.intrfc;

/**
 * 接口
 * */
public interface Test {
	public static final Integer test01=null;
	Integer test02=null;
//	protected static final Integer test03=null;	//Illegal modifier for the interface field Test.test03; only public, static & final are permitted
	
	public abstract void testMethod01();
	void testMethod02();
//	private abstract void testMethod03();	//Illegal modifier for the interface method testMethod03; only public & abstract are permitted
}
