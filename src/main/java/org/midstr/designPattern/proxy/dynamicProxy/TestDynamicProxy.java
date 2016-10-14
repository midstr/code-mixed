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

		Subject rs = new RealSubject(); // 在这里指定被代理类
		DynamicProxySubject ds = new DynamicProxySubject(rs); // 初始化代理类
		Subject subject = null; // 已经被代理的对象
		// 以下是一次性生成
		subject = (Subject) Proxy.newProxyInstance(rs.getClass().getClassLoader(), 
				rs.getClass()
				.getInterfaces(), ds);
		subject.request();
		
		// 以下是分解步骤
		// Class c =
		// Proxy.getProxyClass(cls.getClassLoader(),cls.getInterfaces()) ;
		// Constructor ct = c.getConstructor(new
		// Class[]{InvocationHandler.class});
		// Subject subject =(Subject) ct.newInstance(new Object[]{ds});

		

		// 动态代理类直接写绑定方法
		subject = ds.bind(rs);
		subject.request();
	}

}
