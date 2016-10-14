package org.midstr.memory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.util.Iterator;

public class Memory {

	private static MemoryUsage mu;

	public void printHeapMemory() {
		mu = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
		// printMemoryUsage();
		System.out.println(mu);
	}

	public void printNonHeapMemory() {
		mu = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
		// printMemoryUsage();
		System.out.println(mu);
	}

	public void printDetailOfHeapMemory() {
		Iterator<MemoryPoolMXBean> it = ManagementFactory.getMemoryPoolMXBeans().iterator();
		while (it.hasNext()) {
			MemoryPoolMXBean mp = it.next();
			if ("Heap memory".equals(mp.getType().toString())) {
				System.out.println("Name:" + mp.getName()
						//+ "  Type:" + mp.getType()
						+ "  Usage:" + mp.getUsage());
			}
		}
	}
	
	public void printDetailOfNonHeapMemory(){
		Iterator<MemoryPoolMXBean> it = ManagementFactory.getMemoryPoolMXBeans().iterator();
		while (it.hasNext()) {
			MemoryPoolMXBean mp = it.next();
			if ("Non-heap memory".equals(mp.getType().toString())) {
				System.out.println("Name:" + mp.getName()
						//+ "  Type:" + mp.getType()
						+ "  Usage:" + mp.getUsage());
			}
		}
	}

	public static void main(String[] args) {
		Memory memory = new Memory();
		memory.printHeapMemory();
		memory.printNonHeapMemory();
		//memory.printDetailOfHeapMemory();
		memory.printDetailOfNonHeapMemory();
	}
}
