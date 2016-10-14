package org.midstr.designPattern.visitor;

/**
 * @author yaogangli
 * @date 2013-7-8 下午4:45:03
 */
public class CarElementPrintVisitor implements CarElementVisitor {

	public void visit(Wheel wheel) {
		System.out.println("Visiting " + wheel.getName() + " wheel");
	}

	public void visit(Engine engine) {
		System.out.println("Visiting engine");
	}

	public void visit(Body body) {
		System.out.println("Visiting body");
	}

	public void visit(Car car) {
		System.out.println("Visiting car");
	}

}
