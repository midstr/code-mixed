package org.midstr.designPattern.proxy.dynamicProxy;

public class RealSubject implements Subject {

	public void request() {
		System.out.println("from " + RealSubject.class.getSimpleName());
	}

}
