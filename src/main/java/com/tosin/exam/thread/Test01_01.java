package com.tosin.exam.thread;

public class Test01_01 {
	JManager jm = new JManager();
	public static void main(String[] args) {
//		final JManager jm = new JManager();
		
		final Test01_01 t11= new Test01_01();
		
		
		for(int i=0; i<2; i++){
			new Thread(new Runnable() {
				public void run() {
//					jm.inc();
					t11.jm.inc();
				}
			}).start();;
			
			new Thread(new Runnable() {
				
				public void run() {
//					jm.dec();
					t11.jm.dec();
				}
			}).start();
			
			
		}
		
		
	}
	
}

class JManager1{
	private int j;
	
	public synchronized void inc(){
		j++;
		System.out.println("j++:"+j);
	}
	
	public synchronized void dec(){
		j--;
		System.out.println("j--:"+j);
	}
}
