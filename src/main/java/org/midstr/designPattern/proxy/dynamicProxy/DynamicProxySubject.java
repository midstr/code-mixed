package org.midstr.designPattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description: ��νDynamic Proxy������һ��class������������ʱ���ɵ�class��
 * ��������ʱ������ṩһ��interface������Ȼ���class��������ʵ������Щinterface��
 * �㵱Ȼ���԰Ѹ�class��ʵ��������Щinterface�е��κ�һ�����á���Ȼ�������Dynamic
 * Proxy��ʵ����һ��Proxy��������������ʵ���ԵĹ���������������ʵ��ʱ������ṩһ�� handler�������ӹ�ʵ�ʵĹ���
 * </p>
 * <p>
 * Company:�����Ϲ⻪������ɷ����޹�˾
 * </p>
 * 
 * @author liyg
 * @version 1.0
 * @date Jul 26, 2009 7:55:59 PM
 */
public class DynamicProxySubject implements InvocationHandler {

	private Object sub;

	public DynamicProxySubject() {

	}

	public DynamicProxySubject(Object sub) {
		this.sub = sub;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before calling " + method);
		Object obj = method.invoke(sub, args);
		System.out.println("after calling " + method);
		return obj;
	}

	public Subject bind(Subject obj) {
		return (Subject) Proxy.newProxyInstance(
				obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), this);
	}

}
