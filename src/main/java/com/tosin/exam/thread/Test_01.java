package com.tosin.exam.thread;

public class Test_01 implements Runnable {
	private int j;
	public void run() {
		j++;
		System.out.println("j++:"+j);
	}

	public static void main(String[] args) {
		Test_01 t = new Test_01();
		t.run();
	}
}
