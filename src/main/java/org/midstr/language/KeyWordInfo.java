package org.midstr.language;

public class KeyWordInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 一、this
		// 1.只能在实例方法和构造方法中使用，不能在static方法和static代码块中使用。
		// 2.通常用this表示当前对象(或这个对象)，可以用this.name的方式访问当前对象的方法或变量，主要用来与同名参数进行区别。
		// 3.在类的构造方法中，可以使用this(para1,.....)来调用另外一个与this参数相同的构造方法。
		// 4.在一个实例方法内，访问当前实例的引用。形如：methodName(this);
		//		 
		// 二、super
		// 1.只能在实例方法和构造方法中使用，不能在static方法和static代码块中使用。
		// 2.通常用super关键字来访问父类的被屏蔽的方法和属性。
		// 3.在类的构造方法中，可以使用super(para1,.....)来访问父类的构造方法。
		// 4.如果子类没有显示super调用父类构造方法，JVM会自动调用父类的默认构造方法。
		//		 
		// 三、final
		// 1.final修饰的类不能被继承，没有子类。
		// 2.final修饰的方法不能被子类的方法覆盖。
		// 3.final修饰的变量表示常量，只能被赋值一次，并且需要在声明的时候初始化。
		//		 
		// 四、static
		// 1.static修饰的成员变量表示静态变量，可以通过类名来直接访问，并且静态变量在内存中只有一个拷贝。(注：常与final合用)
		// 2.static修饰的方法为静态方法，可以通过类名直接访问，但静态方法中不允许直接访问非静态变量和非静态方法。
		// 3.static修饰的代码块为静态代码块，在JVM加载类时只被执行一次，一般类的静态代码块用于初始化类。
		//
		// 五、访问权限(public、protected、默认package、private)
		//		 
		// 访问级别   修饰符      同类   同包   子类  不同的包
		// 公开       public    √      √     √      √
		// 受保护     protected √      √     √      －
		// 默认       没有        √      √     －      －
		// 私有       private   √      －      －     －
		//
		// 1.public 对外公开
		// 2.protected 对子类以及同一个包中的类公开
		// 3.默认package 向同一个包中的类公开
		// 4.private 只有类本身可以访问，不对外公开
		// (注：类的成员方法、构造方法、成员变量可以被以上4种任何一个访问控制修饰，而类本身只能是public或者默认级别，局部变量只可以用final修饰。)

	}

}
