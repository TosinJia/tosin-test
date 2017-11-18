package com.tosin.exam.thread.pool;

import java.util.concurrent.Callable;

public class SubCallable implements Callable<String> {
//	private String result;
//	
//	public String getResult() {
//		return result;
//	}
//	public void setResult(String result) {
//		this.result = result;
//	}
	private int i;
	
	public SubCallable(int i) {
		super();
		this.i = i;
	}
	@Override
	public String call() throws Exception {
		
		System.out.println(i+"子线程开始执行");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = "ret"+i;
		System.out.println(i+"子线程执行完成");
		
		return result;
	}

}
