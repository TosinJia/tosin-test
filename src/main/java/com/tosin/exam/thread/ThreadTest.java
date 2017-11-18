package com.tosin.exam.thread;

/**
 * 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次. 
 * http://blog.csdn.net/nszkadrgg/article/details/8197555
 * */
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadTest().init();

	}

	public void init()
	{
		final Business business = new Business();
		new Thread(
				new Runnable()
				{

					public void run() {
						for(int i=0;i<50;i++)
						{
							business.SubThread(i);
						}						
					}
					
				}
		
		).start();
		
		for(int i=0;i<50;i++)
		{
			business.MainThread(i);
		}		
	}
	
	private class Business
	{
		boolean bShouldSub = true;//这里相当于定义了控制该谁执行的一个信号灯
		public synchronized void MainThread(int i)
		{
			if(bShouldSub)
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				
			for(int j=0;j<5;j++)
			{
				System.out.println(Thread.currentThread().getName() + ":i=" + i +",j=" + j);
			}
			bShouldSub = true;
			this.notify();
		
		}
		
		
		public synchronized void SubThread(int i)
		{
			if(!bShouldSub)
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
			for(int j=0;j<10;j++)
			{
				System.out.println(Thread.currentThread().getName() + ":i=" + i +",j=" + j);
			}
			bShouldSub = false;				
			this.notify();			
		}
	}
}