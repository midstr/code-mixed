package org.midstr.collections;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSets {
	public static final int length = 5;
	
	public static void initSet(Set<String> set) {
		Date start = new Date();
		for (int i = 0; i < length; i++) {
			set.add(String.valueOf(i));
		}
		Date end = new Date();
		System.out.println("init " + set.getClass().getSimpleName() + ": "
				+ (end.getTime() - start.getTime()));
	}
	
	public static void printSet(Set<String> set){
		System.out.println(set.getClass().getSimpleName() + ":");
		for (String key : set) {
			System.out.print(key + " ");
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * HashSet        不同步的
		 * TreeSet        不同步的 (基于TreeMap，按照升序排序)
		 * LinkedHashSet  不同步的 (具有可预知迭代顺序)
		 * */
		
		Set<String> hashset = new HashSet<String>();
		Set<String> treeset = new TreeSet<String>();
		Set<String> linkedhashset = new LinkedHashSet<String>();
		
		initSet(hashset);
		initSet(treeset);
		initSet(linkedhashset);
		
		printSet(hashset);
		printSet(treeset);
		printSet(linkedhashset);
	}

}
