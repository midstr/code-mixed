package org.midstr.thread.sync;

import java.util.Map;

public class SynchronizedDemo {

	private Map<String, String> dataMap;

	// synchronized 关键字，它包括两种用法：synchronized 方法和 synchronized 块。

	/**
	 * synchronized 方法控制对类成员变量的访问：每个类实例对应一把锁，每个 synchronized
	 * 方法都必须获得调用该方法的类实例的锁方能执行，否则所属线程阻塞，方法一旦执行，就独占该锁，
	 * 直到从该方法返回时才将锁释放，此后被阻塞的线程方能获得该锁，重新进入可执行状态。这种机制 确保了同一时刻对于每一个类实例，其所有声明为
	 * synchronized 的成员函数中至多只有一个处于可执行状态（因为至多只有一个能够获得该类实例对应的锁），从而有
	 * 效避免了类成员变量的访问冲突（只要所有可能访问类成员变量的方法均被声明为 synchronized）。 在 Java
	 * 中，不光是类实例，每一个类也对应一把锁，这样我们也可将类的静态 成员函数声明为 synchronized ，以控制其对类的静态成员变量的访问。
	 * synchronized 方法的缺陷：若将一个大的方法声明为synchronized 将会大大影响效率，典型地，若将线程类的方法 run()
	 * 声明为 synchronized ，由于在线程的整个生命期内它一直在运行，因此将导致它对本类任何 synchronized
	 * 方法的调用都永远不会成功。当然我们可以通过将访问类成员变量的代码放到专门的方法中，将其声明为 synchronized
	 * ，并在主方法中调用来解决这一问题，但是 Java 为我们提供了更好的解决办法，那就是 synchronized 块。
	 * 
	 */
	public synchronized void testSyncMethod() {

	}

	/**
	 * synchronized 块是这样一个代码块，其中的代码必须获得对象 syncObject
	 * （如前所述，可以是类实例或类）的锁方能执行，具体机制同前所述。由于可以针对任意代码块，
	 * 且可任意指定上锁的对象，故灵活性较高
	 * 
	 * 注意：synchronized(this) 等价于 synchronized方法，
	 * 即两者的锁会互斥，但是synchronized(object)的不会与之同步
	 * ===========================================================================================
	 * 所以synchronized同步分为两类，
	 * 一种是synchronized(this)和synchronized方法(使用时注意内部类的this陷阱)
	 * 一种是synchronized(object)。
	 * 另外在jdk5之后可使用java.util.concurrent.locks(ReadLock/WriteLock)、java.util.concurrent.atomic、java.util.concurrent进行同步相关操作
	 * 综合以上三种同步方式，还可以为代码使用一种称之为Copy-on-write的策略，
	 * 即使用动态读/写复制(Copy-on-write)策略，可参考ReverseAjaxThread.java类
	 * ===========================================================================================
	 * 
	 * 无论synchronized关键字加在方法上还是对象上，它取得的锁都是对象
	 * 一个对象只有一个锁与之关联
	 */
	public void testSyncObject() {
		// do something
		synchronized (dataMap) {
			dataMap.remove("key");
		}
	}

	/**
	 * 一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一
	 * 个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
	 * 
	 * 二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍
	 * 然可以访问该object中的非synchronized(this)同步代码块。
	 * 
	 * 三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，其他
	 * 线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
	 * 
	 * 四、第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个
	 * synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该
	 * object对象所有同步代码部分的访问都被暂时阻塞。
	 * 
	 * 五、以上规则对其它对象锁同样适用
	 */
	public void testSyncThis() {
		// 这里this特殊在于，方法注释中的第三点
		synchronized (this) {
			
		}
	}

}
