package org.midstr.language;

public class InnerClassDemo {

	// static和非static的主要区别：static的内部类可以直接创建，而不需要引用外部类的实体，
	// 即可以先于外部类的实例创建而创建
	// 各种修饰符的意思是：
	//   1.public 对外公开
	//   2.protected 对子类以及同一个包中的类公开
	//   3.默认package 向同一个包中的类公开
	//   4.private 只有类本身可以访问，不对外公开
	//    (注：类的成员方法、构造方法、成员变量可以被以上4种任何一个访问控制修饰，而类本身只能是public或者默认级别，局部变量只可以用final修饰。)
	private class T1 {

	}

	class T2 {

	}

	protected class T3 {

	}

	public class T4 {

	}

	private static class Test1 {

	}

	static class Test2 {

	}

	protected static class Test3 {

	}

	public static class Test4 {

	}

	public void test() {
		T1 t1 = new T1();
		Test1 tt1 = new Test1();
	}

	public static void main(String[] args) {
		// 
	}
}
