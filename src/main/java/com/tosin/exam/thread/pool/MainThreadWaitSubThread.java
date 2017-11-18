package com.tosin.exam.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MainThreadWaitSubThread {
	private static ExecutorService pool = Executors.newCachedThreadPool();
	
	public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis() ;
        
       
//        test01();
        test02();
        
        Thread.sleep(10000);
        
        test02();
        long end = System.currentTimeMillis();
        long endure = end-start;
        System.out.println("耗时："+endure);		
	}
	
	public static void test02() throws Exception{
		List<Future<String>> list = new ArrayList<Future<String>>();
		for (int i = 0; i < 100; i++) {
			Future<String> future= pool.submit(new SubCallable(i));
			list.add(future);
		}
		for (Future<String> future : list) {
			String result = future.get();
			System.out.println(result);
		}
//		pool.shutdown();
	}
	
	public static void test01() throws Exception{
		 List<SubThread> list = new ArrayList<SubThread>();
	        for(int i = 0;i<100;i++)
	        {
//	        	Thread mt = new Thread(new SubRunnable());
//	        	mt.start();
//	        	mt.join();
	        	
	        	SubThread st = new SubThread(i);
	        	st.start();
	        	list.add(st);
	        }
	        for (SubThread subThread : list) {
	        	subThread.join();
			}
	        for (SubThread subThread : list) {
	        	String result = subThread.getResult();
	        	System.out.println(result);
	      
			}
	}
}
