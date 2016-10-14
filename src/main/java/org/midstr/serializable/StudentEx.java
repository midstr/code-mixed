package org.midstr.serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author yaogangli
 * @date 2013-5-24 上午10:40:16
 */
public class StudentEx implements Externalizable {

	private int id;
	private String name;
	private Date brithday;

	private transient String password;
	
	/**
	 * 
	 */
	public StudentEx() {
	}

	public StudentEx(int id, String name, Date brithday, String password) {
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
	
	@Override
	public String toString() {
		return "Student[id=" + id + ", name=" + name + ", birthday=" + brithday + ", password=" + password + "]";
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writeExternal invoked!");
		out.write(id);
		out.writeUTF(name);
		out.writeObject(brithday);
		out.writeUTF(password);
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("readExternal invoked!");
		id = in.read();
		name = in.readUTF();
		brithday = (Date)in.readObject();
		password = in.readUTF();
		
	}

	public static void main(String[] args) {
		try {
			StudentEx student = new StudentEx(1, "yaogangli", new Date(), "password");
			System.out.println("before  :studentEx = " + student);
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student_ex.out"));
			out.writeObject(student);
			out.close();

			ObjectInputStream in = new ObjectInputStream(new FileInputStream("student_ex.out"));
			StudentEx student2 = (StudentEx) in.readObject();
			in.close();
			System.out.println("after   :studentEx = " + student2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
