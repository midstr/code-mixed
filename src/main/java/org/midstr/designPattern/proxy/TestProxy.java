package org.midstr.designPattern.proxy;

public class TestProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// no proxy
		Subject realSubject = new RealSubject();
		realSubject.request();
		
		// proxy 1
		Subject proxySubject1 = new ProxySubject1();
		proxySubject1.request();
		
		// proxy 2
		Subject proxySubject2 = new ProxySubject2(realSubject);
		proxySubject2.request();
		
		// 装饰器模式应当为所装饰的对象提供增强功能，而代理模式对所代理对象的使用施加控制，并不提供对象本身的增强功能
		// 远程代理，虚拟代理，保护代理，Cache代理，防火墙代理，同步化代理，智能引用代理，计数代理
	}

}
