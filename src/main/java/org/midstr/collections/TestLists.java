package org.midstr.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TestLists {

	public static final int length = 1000000;
	
	public static final int index = 490000;

	public static void initList(List<Integer> list) {
		Date start = new Date();
		for (int i = 0; i < length; i++) {
			list.add(i);
		}
		Date end = new Date();
		System.out.println("init " + list.getClass().getSimpleName() + ": "
				+ (end.getTime() - start.getTime()));

	}
	
	public static void accessList(List<Integer> list) {
		Date start = new Date();
		list.get(index);
//		list.contains(new Integer(index));
		Date end = new Date();
		System.out.println("access " + list.getClass().getSimpleName() + ": "
				+ (end.getTime() - start.getTime()));

	}
	public static void removeList(List<Integer> list) {
		Date start = new Date();
		for (int i = 0; i < 1000; i++) {
			list.remove(0);
//			list.remove(index);
		}
		Date end = new Date();
		System.out.println("remove " + list.getClass().getSimpleName() + ": "
				+ (end.getTime() - start.getTime()));
		
	}
	
	public static void addList(List<Integer> list) {
		Date start = new Date();
		for (int i = 0; i < 1000; i++) {
			list.add(1,-33);
		}
		Date end = new Date();
		System.out.println("add " + list.getClass().getSimpleName() + ": "
				+ (end.getTime() - start.getTime()));
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Vector     同步的 数组实现  随机访问
		 * ArrayList  不同步 数组实现  随机访问，操作慢
		 * LinkedList 不同步 链表实现  访问慢，操作快
		 * 
		 * 实际上，ArrayList能满足大部分需要，并且操作都比较LinkedList快
		 * 只有那些在头进行插入和删除的操作LinkedList快
		 */
		List<Integer> vector = new Vector<Integer>();
		List<Integer> array = new ArrayList<Integer>();
		List<Integer> linked = new LinkedList<Integer>();
		
		initList(vector);
		initList(array);
		initList(linked);
		
		accessList(vector);
		accessList(array);
		accessList(linked);
		
		removeList(vector);
		removeList(array);
		removeList(linked);
		
		addList(vector);
		addList(array);
		addList(linked);

	}

}
