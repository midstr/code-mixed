package org.midstr.designPattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description: 所谓Dynamic Proxy是这样一种class：它是在运行时生成的class，
 * 在生成它时你必须提供一组interface给它，然后该class就宣称它实现了这些interface。
 * 你当然可以把该class的实例当作这些interface中的任何一个来用。当然啦，这个Dynamic
 * Proxy其实就是一个Proxy，它不会替你作实质性的工作，在生成它的实例时你必须提供一个 handler，由它接管实际的工作
 * </p>
 * <p>
 * Company:北京紫光华宇软件股份有限公司
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
