package com.tosin.exam.thread;

import java.util.Collection;

/**
 * 56、子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次，请写出程序。
 * 
 * synchroinzed wait notify 信号变量;Thread	runnable;
 * */
public class Test02 {
	public static void main(String[] args){
		final Business business = new Business(); 
		
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 500000000; i++) {
					business.subThread(i);
				}
			}
		}).start();
		
		for (int i = 0; i < 500000000; i++) {
			business.mainThread(i);
		}
		
		System.out.println("main执行完成！");
		
//		Test02 t = new Test02();
//		t.init();
	}
	
	public void init(){
		final Business business = new Business(); 
		
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 50; i++) {
					business.subThread(i);
				}
			}
		}).start();
		
		for (int i = 0; i < 50; i++) {
			business.mainThread(i);
		}
	}
}

class Business{
	private boolean flag = true;
	
	public synchronized void mainThread(int i){
		if(flag){
			try {
				System.out.println(Thread.currentThread().getName()+"进入等待");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int j = 0; j < 5; j++) {
			System.out.println(Thread.currentThread().getName()+ "\ti="+i+"\tj="+j);
		}
		
//		flag=false;	如果能执行到此行，flag为false
		flag=true;
		System.out.println(Thread.currentThread().getName()+"进入通知其他线程执行");
		this.notify();
	}
	public synchronized void subThread(int i){
		if(!flag){
			try {
				System.out.println(Thread.currentThread().getName()+"进入等待");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int j = 0; j < 10; j++) {
			System.out.println(Thread.currentThread().getName()+ "\ti="+i+"\tj="+j);
		}
		
//		flag=true;
		flag=false;
		System.out.println(Thread.currentThread().getName()+"进入通知其他线程执行");
		this.notify();
	}
}
