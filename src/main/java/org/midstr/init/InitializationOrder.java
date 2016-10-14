package org.midstr.init;
 /**
 * 类初始化 -> 子类构造函数 -> 父类构造函数 -> 实例化成员变量 -> 继续执行子类构造函数的语句
 * 
 *1、类的初始化：Initialization classes and interfaces
      initialization of class(初始化static field 和执行static初始化块)
      initialization of interface (初始化定义在该interface中的field)
  		--initialization classes 时，该class的superclass 将首先被初始化，但其实现的interface则不会。
	    --initialization classes 时，该class的superclass，以及superlcass的superclass 会首先被递归地初始化，一直到java.lang.Object为止。
	      但initialiazation interface的时候，却不需如此，只会初始化该interface本身。
	    --对于由引用类变量（class field）所引发的初始化，只会初始化真正定义该field的class。
	    --如果一个static field是编译时常量（compile-time constant），则对它的引用不会引起定义它的类的初始化。
  2、对象的创建：creation of new class instances  
    (a) 所有的成员变量—包括该类，及它的父类中的成员变量--被分配内存空间，并赋予默认值。（Btw，这里是第一次初始化成员变量）
	(b) 为所调用的构造函数初始化其参数变量。（如果有参数）
	(c) 如果在构造函数中用this 调用了同类中的其他构造函数，则按照步骤(b)~(f)去处理被调用到的构造函数。
	(d) 如果在构造函数中用super调用了其父类的构造函数，则按照步骤(b)~(f)去处理被调用到的父类构造函数。
	(e) 按照书写顺序，执行instance initializer 和 instance variable initializer来初始化成员变量。（Btw，这里是第二次初始化成员变量）
	(f) 按照书写顺序，执行constructor的其余部分。
		*注意*----成员变量其实都被初始化2次，第一次是赋予默认值，第二次才是你想要设定的值。
 */
public class InitializationOrder {
	static {
		System.out.println("init------>" + InitializationOrder.class.getSimpleName());
	}
	public static void main(String[] args) {
		Subclass sb = new Subclass();
		//System.out.println(Subclass.su);
		System.out.println(sb);
	}
}

class Super {
	static {
		System.out.println("init------>" + Super.class.getSimpleName());
	}
	Super(int i) {
		System.out.println(i);
	}
}

class Subclass extends Super implements Interface {
	static {
		System.out.println("init------>" + Subclass.class.getSimpleName());
	}
	Super su = new Super(9);
	Subclass() {
		this(1);
		new Super(100);
	}
	Subclass(int i) {
		super(i);
		System.out.println(i++);
	}
	
	Super sx = new Super(10);
}

interface Interface {
	Super su = new Super(0);
}
