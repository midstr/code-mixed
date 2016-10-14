package org.midstr.designPattern.singleton;

/**
 * 使用静态变量，并且不考虑线程安全
 */
public class SingletonInstant {
	private SingletonInstant() {
	}
	
	private static final SingletonInstant instance = new SingletonInstant();
	// eagerly ---- JVM load
	public static SingletonInstant getInstance1() {
		return instance;
	}
	
}
