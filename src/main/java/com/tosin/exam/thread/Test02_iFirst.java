package com.tosin.exam.thread;

/**
 * 56、子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次，请写出程序。
 * */
public class Test02_iFirst {
	public static void main(String[] args){
		
		
		Test02_iFirst t2 = new Test02_iFirst();
		
		Thread subThread = new Thread(t2.new Sub());
		
		for(int j=0;j<50;j++){
			System.out.println("循环次数"+(j+1));
			
			for (int i = 0; i < 100; i++) {
				System.out.println("主线程循环次数："+(i+1));
			}
			
//			subThread.start();	//java.lang.IllegalThreadStateException
			new Thread(t2.new Sub()).start();;
		}
	}
	
	class Sub implements Runnable{
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("子线程循环次数："+(i+1));
			}
		}
	}
}
