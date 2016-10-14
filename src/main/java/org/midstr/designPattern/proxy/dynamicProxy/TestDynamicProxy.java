package org.midstr.designPattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {

	/**
	 * @param args
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		Subject rs = new RealSubject(); // ������ָ����������
		DynamicProxySubject ds = new DynamicProxySubject(rs); // ��ʼ��������
		Subject subject = null; // �Ѿ�������Ķ���
		// ������һ��������
		subject = (Subject) Proxy.newProxyInstance(rs.getClass().getClassLoader(), 
				rs.getClass()
				.getInterfaces(), ds);
		subject.request();
		
		// �����Ƿֽⲽ��
		// Class c =
		// Proxy.getProxyClass(cls.getClassLoader(),cls.getInterfaces()) ;
		// Constructor ct = c.getConstructor(new
		// Class[]{InvocationHandler.class});
		// Subject subject =(Subject) ct.newInstance(new Object[]{ds});

		

		// ��̬������ֱ��д�󶨷���
		subject = ds.bind(rs);
		subject.request();
	}

}
