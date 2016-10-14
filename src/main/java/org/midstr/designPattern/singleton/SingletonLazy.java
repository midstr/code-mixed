package org.midstr.designPattern.singleton;

public class SingletonLazy {
	
	private SingletonLazy() {
	}
	
	/*****1、比较新颖的写法，可避免过早被jvm加载**********/
	static class SingletonHolder {
		static final SingletonLazy instance = new SingletonLazy();
	}

	public static SingletonLazy getInstance0() {
		return SingletonHolder.instance;
	}
	
	/*****2、传统的对多线程同步的方式，会存在性能问题******************/
	private static SingletonLazy instance1;
	// synchronize method
	// weakness ---- large expense when multi thread
	public static synchronized SingletonLazy getInstance1() {
		if (instance1 == null) {
			instance1 = new SingletonLazy();
		}
		return instance1;
	}
	
	/*****3、根据double-check完成的线程同步方式******************/
	// 注意：这里必须声明为volatile，且从jdk1.5版本起
	private static volatile SingletonLazy instance2;
	// double-checked locking,since jdk 1.5
	public static SingletonLazy getInstance2() {
		SingletonLazy result = instance2;
		if (result == null) {
			synchronized (SingletonLazy.class) {
				result = instance2;
				if (result == null) {
					instance2  = result = new SingletonLazy();
				}
			}
		}
		return result;
	}
	
}
