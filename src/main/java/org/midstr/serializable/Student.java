package org.midstr.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yaogangli
 * @date 2013-5-24 上午10:37:43
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 7556630824536878515L;
	private int id;
	private String name;
	private Date brithday;
	private transient String password;

	/**
	 * 
	 */
	public Student(int id, String name, Date brithday, String password) {
		this.id = id;
		this.name = name;
		this.brithday = brithday;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the brithday
	 */
	public Date getBrithday() {
		return brithday;
	}

	/**
	 * @param brithday
	 *            the brithday to set
	 */
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student[id=" + id + ", name=" + name + ", birthday=" + brithday + ", password=" + password + "]";
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		System.out.println("writeObject invoked");
		Date saveTime = new Date();
		out.writeLong(saveTime.getTime());
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		System.out.println("readObject invoked");
		long saveTime = in.readLong();
		System.out.println("save_time:" + saveTime);
		in.defaultReadObject();
	}

	//
	//	private void readObjectNoData() throws ObjectStreamException {
	//		System.out.println("readObjectNoData:");
	//	}
	
	private Object writeReplace() throws ObjectStreamException{
		System.out.println("writeReplace invoked");
		Student student = new Student(1000, "max", new Date(), "password");
		return student;
	}
	
	private Object readResolve() throws ObjectStreamException{
		System.out.println("readResolve invoked");
		Student student = new Student(0, "min", new Date(), "password");
		return student;
	}
	


	public static void main(String[] args) {
		try {
			Student student = new Student(1, "yaogangli", new Date(), "123456");
			System.out.println("before :student = " + student);
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.out"));
			out.writeObject(student);
			out.close();

			ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.out"));
			Student student2 = (Student) in.readObject();
			in.close();
			System.out.println("after  :student = " + student2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
