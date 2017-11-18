package com.tosin.exam.thread.pool;

public class SubThread extends Thread {
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}


	private int i;
	
	public SubThread(int i) {
		super();
		this.i = i;
	}


	@Override
	public void run() {
		System.out.println(i+"子线程开始执行");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result = "ret"+i;
		System.out.println(i+"子线程执行完成");
	}
	
}
