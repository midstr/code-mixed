package org.midstr.thread.waitnotify;


class CubbyHole {

	private int content;
	private boolean available = false;

	public synchronized int getContent() {
		while (!available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumer get content: " + content);
		available = false;
		notifyAll();
		return content;
	}

	public synchronized void setContent(int content) {
		while (available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.content = content;
		available = true;
		System.out.println("Producer set content: " + content);
		notifyAll();
	}

}

class Producer extends Thread {

	private CubbyHole cubbyHole;

	public Producer(CubbyHole c) {
		this.cubbyHole = c;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			cubbyHole.setContent(i);
		}
	}
}

class Consumer extends Thread {

	private CubbyHole cubbyHole;

	public Consumer(CubbyHole c) {
		this.cubbyHole = c;
	}

	public void run() {
		int content = 0;
		for (int i = 0; i < 10; i++) {
			content = cubbyHole.getContent();
		}
		System.out.println(content);
	}
}

public class ProducerConsumerTest {

	public static void main(String[] args) throws Exception{
		CubbyHole ch = new CubbyHole();
		Producer p = new Producer(ch);
		Consumer c = new Consumer(ch);
		p.start();
		c.start();
		p.join();
		c.join();
		//Consumer c1 = new Consumer(ch);
		//c1.start();
		//c1.join();
	}

}
