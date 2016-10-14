package org.midstr.designPattern.proxy;

public class RealSubject extends Subject {
	
	public RealSubject(){
		
	}

	@Override
	public void request() {
		System.out.println("from " + RealSubject.class.getSimpleName());
	}

}
