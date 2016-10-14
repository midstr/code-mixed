package org.midstr.thread;

class TwoNums {
	private int a = 0;
	private int b = 0;
	
	synchronized public void increase(){
//		synchronized( this ) {
//			a++;
//			b++;
//		}
		a++;
		b++;
	}
	
	synchronized public void testEquals(){
//		synchronized( this ){
//			System.out.println(a + " == " + b + ":" + (a==b));
//		}
		System.out.println(a + " == " + b + ":" + (a==b));
	}
}

class ChangeNumber extends Thread{
	private TwoNums twoNums;
	private boolean timeToQuit = false;
	
	ChangeNumber(TwoNums twoNums){
		this.twoNums = twoNums;
	}
	
	public void run(){
		while( !timeToQuit )
			twoNums.increase();
	}
	
	public void stopRunning(){
		timeToQuit = true;
	}
}

public class ThreadSynDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoNums twoNums = new TwoNums();
		ChangeNumber t1 = new ChangeNumber(twoNums);
		ChangeNumber t2 = new ChangeNumber(twoNums);
		t1.start();
		t2.start();
		
		for(int i=0; i<100; i++){
			System.out.print(i+": ");
			twoNums.testEquals();
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		t1.stopRunning();
		t2.stopRunning();
	}

}
