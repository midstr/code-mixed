package org.midstr.thread;

class MyThread extends Thread{
	
	//private static int nTest = 0;
	
	public MyThread( String str ){
		super( str );
	}
	public void run(){
		for( int i=0; i<5; i++ ){
			System.out.println(getName()+" = " + i);
//			yield();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		nTest++;
//		System.out.println(getName()+":"+nTest);
	}
}

public class TimeTestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Thread t1 = new MyThread("Thread1");
		Thread t2 = new MyThread("Thread2");
		t2.setPriority( Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
//		System.out.println(Thread.currentThread().getName());synchronized
	}

}
