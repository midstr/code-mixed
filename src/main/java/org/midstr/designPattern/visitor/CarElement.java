package org.midstr.designPattern.visitor;

/**
 * @author yaogangli
 * @date 2013-7-8 下午4:41:21
 */
public interface CarElement {
	void accept(CarElementVisitor visitor); // CarElements have to provide accept().
}

class Wheel implements CarElement {
	private String name;

	public Wheel(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void accept(CarElementVisitor visitor) {
		/*
		 * accept(CarElementVisitor) in Wheel implements
		 * accept(CarElementVisitor) in CarElement, so the call
		 * to accept is bound at run time. This can be considered
		 * the first dispatch. However, the decision to call
		 * visit(Wheel) (as opposed to visit(Engine) etc.) can be
		 * made during compile time since 'this' is known at compile
		 * time to be a Wheel. Moreover, each implementation of
		 * CarElementVisitor implements the visit(Wheel), which is
		 * another decision that is made at run time. This can be
		 * considered the second dispatch.
		 */
		visitor.visit(this);
	}
}

class Engine implements CarElement {
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
	}
}

class Body implements CarElement {
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
	}
}

class Car implements CarElement {
	CarElement[] elements;

	public Car() {
		//create new Array of elements
		this.elements = new CarElement[] { new Wheel("front left"), new Wheel("front right"), new Wheel("back left"),
				new Wheel("back right"), new Body(), new Engine() };
	}

	public void accept(CarElementVisitor visitor) {
		for (CarElement elem : elements) {
			elem.accept(visitor);
		}
		visitor.visit(this);
	}
}
