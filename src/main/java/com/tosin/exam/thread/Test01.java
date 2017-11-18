package com.tosin.exam.thread;


/**
 * 设计4个线程，其中两个个线程每次对j增加1，另外两个每次对j减少1
 * 1、Runnable	采用 Runnable 接口方式创建的多条线程可以共享实例属性   
 * 2、Java内部类的使用小结 http://android.blog.51cto.com/268543/384844/
 * 3、Thread
 * 4、synchronized修饰符	同步
 * 
 * http://blog.csdn.net/goodleiwei/article/details/7059521
 * */
public class Test01 {
	private int j;
	
	private synchronized void inc(){
//	private void inc(){
		j++;
	} 
	private synchronized void des(){
//	private void des(){
		j--;
	}
	
	class Inc implements Runnable {
		public void run() {
			inc();
			System.out.println("j++:"+j);
		}
	}
	class Des implements Runnable{
		public void run() {
			des();
			System.out.println("j--:"+j);
		}
	}
	public static void main(String[] args){
		Test01 t = new Test01();
		
		Test01.Inc inc = t.new Inc();
		Test01.Des des = t.new Des();
		
		for (int i = 0; i < 2; i++) {
//			inc.run();
//			des.run();
			new Thread(inc).start();
			new Thread(des).start();
		}
		
	}
	
	
}
