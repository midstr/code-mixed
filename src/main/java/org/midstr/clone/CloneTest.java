package org.midstr.clone;

public class CloneTest implements Cloneable{
	private String name;

	private Integer age;

	public CloneTest() {
	}

	public Object clone(){
		CloneTest obj = null;
		try {
			obj = (CloneTest) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static void main(String[] args) {
		/*CloneTest my = new CloneTest();
		my.setName("liyg");
		my.setAge(new Integer(17));
		
		CloneTest you = (CloneTest) my.clone();
		System.out.println(you.getName() + "--" + you.getAge());*/
		NewCloneTest my = new NewCloneTest();
		my.setName("liyg");
		my.setAge(new Integer(17));
		my.setAddr("dwz");
		
		NewCloneTest you = (NewCloneTest) my.clone();
		System.out.println(my.getName() + "--" + my.getAge() + "--" + my.getAddr());
		System.out.println(you.getName() + "--" + you.getAge() + "--" + you.getAddr());
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
