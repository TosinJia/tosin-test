package com.tosin.exam.thread.pool;

public class SubRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("子线程开始执行");
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("子线程执行完成");
	}

}
