package com.tosin.exam.thread;

public class Test01_0101 {
	JManager jm = new JManager();
	
	public void start(){
		for(int i=0; i<2; i++){
			new Thread(new Runnable() {
				public void run() {
					jm.inc();
				}
			}).start();;
			
			new Thread(new Runnable() {
				
				public void run() {
					jm.dec();
				}
			}).start();
		}
	}
	
	public static void main(String[] args) {
		
		new Test01_0101().start();
		
	}
	
}

class JManager{
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
