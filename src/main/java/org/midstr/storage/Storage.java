package org.midstr.storage;

public class Storage {

	public static void main(String[] args) {
		/**
		 *  1.寄存器：最快的存储区, 由编译器根据需求进行分配,我们在程序中无法控制. 
		 *  2.栈：存放基本类型的变量数据和对象的引用
		 *  3.堆：存放所有new出来的对象。
		 *  4.静态域：存放静态成员（static定义的） 
		 *  5.常量池：存放字符串常量和基本类型常量（public static final）。 
		 *  6.非RAM存储：硬盘等永久存储空间
		 */
		
		/**
		 * 堆和常量池，对于栈和常量池中的对象可以共享，对于堆中的对象不可以共享。
		 * 栈中的数据大小和生命周期是可以确定的，当没有引用指向数据时，这个数据就会消失。
		 * 堆中的对象的由垃圾回收器负责回收，因此大小和生命周期不需要确定，具有很大的灵活性。
		 * 
		 * 对于字符串String：其对象的引用都是存储在栈中的，如果是编译期已经创建好(直接用双引号定义的)的就存储在常量池中，
		 * 如果是运行期（new出来的）才能确定的就存储在堆中。对于equals相等的字符串，在常量池中永远只有一份，在堆中有多份
		 */
		
		/**
		 * java.lang.instrument.Instrumentation只能获取对象的占用内存的大小，
		 * 对于int ，long等原始类型是没有办法得知其内存大小的。同时java specification仅仅规定
		 * 了类型逻辑上所需的字节数，具体到每个JVM实现中用到的实际内存大小是没有限制的
		 * 
		 * byte     1字节   -2^7 ~ 2^7-1
		 * int 	    4字节   -2^31 ~ 2^31-1
		 * short	2字节   -2^15 ~ 2^15-1
		 * long	    8字节   -2^63 ~ 2^63-1
		 * float	4字节	大约±3.40282347E+38F (有效位数为6-7位)
		 * double	8字节	大约±1.79769313486231570E+308 (有效位数为15位)
		 * char     2字节        
		 * boolean  1bit     This data type represents one bit of information, but its "size" isn't something that's precisely defined
		 * */
		
		String s1 = "test";
		String s2 = "test";
		String s3 = new String("test");
		String s4 = new String("test");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);
		
		
	}

}
