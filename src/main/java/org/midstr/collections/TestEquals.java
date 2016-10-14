package org.midstr.collections;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestEquals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student s1 = new Student("1", "张三");
		Student s2 = new Student("1", "李四");
		System.out.println(s1.equals(s2));
		
		// 典型的违反对称性
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		System.out.println(date.equals(time));
		System.out.println(time.equals(date));
		
		Phone p1 = new Phone("123");
		Phone p2 = new Phone("123");
		List<Object> list = new ArrayList<Object>();
		list.add(date);
		list.add(p1);
		System.out.println(list.contains(time));
		System.out.println(list.contains(p2));
		
	}
	
	static class Phone {
		private String number;
		
		public Phone(String number) {
			this.number = number;
		}
		
		public String getNumber() {
			return number;
		}
	}

}
