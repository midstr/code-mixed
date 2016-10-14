package org.midstr.collections;

public class Student {
	// 实际情况中，更可能将id域作为基类
	private String id;
	private String name;

	// 增加hashCode属性，避免每次调用hashCode方法都生成一次
	private int hashCode = Integer.MIN_VALUE;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * 典型的equals方
	 * <p>
	 * 必须满足：自反性、对称性、传递性、一致性、对于任何非空引用值 x，x.equals(null) 都应返回 false
	 * </p>
	 * <p>
	 * 会影响到Collection.contains方法的返回结果
	 * </p>
	 * <p>
	 * 当编写完equals方法，通常有必要改写hashCode()方法，以维护 hashCode 方法的常规协定
	 * </p>
	 * 
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Student) {
			Student s = (Student) obj;
			if (this.getId() == null || s.getId() == null) {
				return false;
			}
			return this.getId().equals(s.getId());
		}
		return false;
	}

	/**
	 * <p>
	 * 典型的hashcode方法
	 * </p>
	 * 
	 * <p>
	 * hashCode 的常规协定是：
	 * </p>
	 * 
	 * <p>
	 * 1、在 Java 应用程序执行期间，在同一对象上多次调用 hashCode 方法时，必须一致地返回相同的整数，前提是对象上 equals
	 * 比较中所用的信息没有被修改。从某一应用程序的一次执行到同一应用程序的另一次执行，该整数无需保持一致。
	 * </p>
	 * <p>
	 * 2、 如果根据 equals(Object) 方法，两个对象是相等的，那么在两个对象中的每个对象上调用 hashCode
	 * 方法都必须生成相同的整数结果。
	 * </p>
	 * <p>
	 * 3、 以下情况不 是必需的：如果根据 equals(java.lang.Object) 方法，两个对象不相等，那么在两个对象中的任一对象上调用
	 * hashCode 方法必定会生成不同的整数结果。但是，程序员应该知道，为不相等的对象生成不同整数结果可以提高哈希表的性能。
	 * </p>
	 * 
	 * 
	 * @see Object#hashCode()
	 */
	public int hashCode() {
		// 增加hashCode属性，避免每次调用hashCode方法都生成一次
		// FIXME 目前这个生产办法不一定高效
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	/**
	 * 典型的toString方法
	 * 
	 * @see Object#toString()
	 */
	public String toString() {
//		return new ToStringBuilder(this).append("id", id).append("name", name)
//				.toString();
		return super.toString();
	}
}