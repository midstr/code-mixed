package org.midstr.thread.sync;

public class VolatileDemo extends Thread{
	
	public static volatile int count = 0;
	
	public static int count2 = 0;
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			count++;
			inc();
			try {
				sleep(30);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized static void inc() {
		count2++;
	}
	

	/**
	 * 
	 * http://www.ibm.com/developerworks/cn/java/j-jtp06197.html
	 * 
	 * 锁提供了两种主要特性：互斥（mutual exclusion） 和可见性（visibility）
	 * 
	 * * volatie是非阻塞的
	 * 出于简易性或可伸缩性的考虑，您可能倾向于使用 volatile 变量而不是锁。当使用 volatile 变量而非锁时，某些习惯用法（idiom）
	 * 更加易于编码和阅读。此外，volatile 变量不会像锁那样造成线程阻塞，因此也很少造成可伸缩性问题。在某些情况下，如果读操作远
	 * 远大于写操作，volatile 变量还可以提供优于锁的性能优势
	 * 
	 * 正确使用 volatile 变量的条件您只能在有限的一些情形下使用 volatile 变量替代锁。要使 volatile 变量提供理想的线程安全，必须
	 * 同时满足下面两个条件：对变量的写操作不依赖于当前值。该变量没有包含在具有其他变量的不变式中。
	 * 
	 * *****************************************************************************************************************
	 * 
	 * Volatile修饰的成员变量在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。而且，
	 * 当成员变量发生变化时，强迫线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是 看到某个成员变量的同一个值。
	 * 
	 * Java语言规范中指出：为了获得最佳速度，允许线程保存共享成员变量的私有拷贝，而且只当线程进 入或者离开同步代码块时才与共享成员变量的原始值对比。
	 * 
	 * 这样当多个线程同时与某个对象交互时，就必须要注意到要让线程及时的得到共享成员变量的变化。
	 * 
	 * 而volatile关键字就是提示VM：对于这个成员变量不能保存它的私有拷贝，而应直接与共享成员变量交互。
	 * 
	 * 使用建议：在两个或者更多的线程访问的成员变量上使用volatile。当要访问的变量已在synchronized代 码块中，或者为常量时，不必使用。
	 * 
	 * 由于使用volatile屏蔽掉了VM中必要的代码优化，所以在效率上比较低，因此一定在必要时才使用此关键字。
	 * 
	 * 对这个变量的所有操作都是原来操作，当变量的值由自身的上一个决定时，如n=n+1、n++等，volatile关键字将失效，只有当变量的值
	 * 和自身上一个值无关时对该变量的操作才是原子级别的，如n = m + 1，这个就是原级别的。所以在使用volatile关键时一定要谨慎，
	 * 如果自己没有把握，可以使用synchronized来代替volatile
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread[] aryThread = new VolatileDemo[100];
		for (int i = 0; i < 100; i++) {
			aryThread[i] = new VolatileDemo();
		}
		for (int i = 0; i < 100; i++) {
			aryThread[i].start();
		}
		for (int i = 0; i < 100; i++) {
			aryThread[i].join();
		}
		System.out.println(VolatileDemo.count);
		System.out.println(VolatileDemo.count2);
	}

}
