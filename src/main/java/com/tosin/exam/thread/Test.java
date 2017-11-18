package com.tosin.exam.thread;

public class Test {
	public static void main(String[] args) throws Exception{
//		test01();
		test01_01();
	}
	
	public static void test01(){
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				print();
			}
		});
		t.start();
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void print(){
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void test01_01(){
		Thread t = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				print();
			}
		};
		t.run();
		System.out.println(Thread.currentThread().getName());
	}
}
