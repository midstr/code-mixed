package org.midstr.collections;

import java.util.HashMap;
import java.util.Map;

public class TestHashCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 测试HashMap的get方法
		Phone p1 = new Phone("13426197235");
		Phone p2 = new Phone("13426197235");
		Map<Phone, String> mapPhone = new HashMap<Phone, String>();
		mapPhone.put(p1, "李耀岗");
		// 满足equals，但是hashcode不相等，导致在map中找不到对象
		System.out.println(p1.equals(p2));
		System.out.println(mapPhone.get(p2));

		Map<Student, Object> mapStudent = new HashMap<Student, Object>();
		mapStudent.put(new Student("100", "李耀岗"), "人民的好兄弟");
		mapStudent.put(new Student("101", "李光耀"), "人民的好领导");
		System.out.println(mapStudent.get(new Student("100", "李耀岗")));

		mapStudent.put(new Student("100", "李耀岗"), "人民的好XX");
		System.out.println(mapStudent.size());

		// 测试初始化大小影响，好像影响不大(主要还在hashcode的计算上)
		int count = 100000;
		long s1 = System.currentTimeMillis();
		Map<Object, Object> testInitMap1 = new HashMap<Object, Object>();
		for (int i = 0; i < count; i++) {
			// testInitMap1.put(String.valueOf(i), i);
			testInitMap1.put(new Student(String.valueOf(i), "xx"), i);
		}
		long s2 = System.currentTimeMillis();
		System.out.println("在没有指定Map初始化大小，并且总大小为" + testInitMap1.size()
				+ "时，耗时" + (s2 - s1) + "ms");

		Map<Object, Object> testInitMap2 = new HashMap<Object, Object>(count);
		for (int i = 0; i < count; i++) {
			// testInitMap2.put(String.valueOf(i), i);
			testInitMap2.put(new Student(String.valueOf(i), "xx"), i);
		}
		long s3 = System.currentTimeMillis();
		System.out.println("在指定Map初始化大小，并且总大小为" + testInitMap2.size() + "时，耗时"
				+ (s3 - s2) + "ms");

	}

	// 有equals无hashcode的典型。。。错误
	static class Phone {
		private String number;

		public Phone(String number) {
			this.number = number;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (obj instanceof Phone) {
				Phone p = (Phone) obj;
				if (p.getNumber() == null || this.getNumber() == null) {
					return false;
				}
				return p.getNumber().equals(this.getNumber());
			}
			return false;
		}

		public String getNumber() {
			return number;
		}

		@Override
		public String toString() {
			// return new ToStringBuilder(this).append("number", number)
			// .toString();
			return super.toString();
		}

	}
}
