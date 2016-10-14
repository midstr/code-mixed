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
		
		// װ����ģʽӦ��Ϊ��װ�εĶ����ṩ��ǿ���ܣ�������ģʽ������������ʹ��ʩ�ӿ��ƣ������ṩ���������ǿ����
		// Զ�̴������������������Cache��������ǽ����ͬ���������������ô�����������
	}

}
