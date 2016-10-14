package org.midstr.designPattern.proxy;

/**
 * <p>Title:</p>

 * @author liyg
 * @version 1.0
 * @date Jul 26, 2009 7:57:35 PM
 */
public class ProxySubject1 extends Subject {

	private RealSubject realSubject;

	public ProxySubject1() {
	}

	public void request() {
		preRequest();
		if (realSubject == null) {
			realSubject = new RealSubject();
		}
		realSubject.request();
		postRequest();
	}

	private void preRequest() {
		System.out.println("before Request");
	}

	private void postRequest() {
		System.out.println("after Request");
	}

}
