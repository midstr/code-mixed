package org.midstr.designPattern.visitor;

/**
 * @author yaogangli
 * @date 2013-7-8 下午4:45:42
 */
public class CarElementDoVisitor implements CarElementVisitor {

	public void visit(Wheel wheel) {
		System.out.println("Kicking my " + wheel.getName() + " wheel");
	}

	public void visit(Engine engine) {
		System.out.println("Starting my engine");
	}

	public void visit(Body body) {
		System.out.println("Moving my body");
	}

	public void visit(Car car) {
		System.out.println("Starting my car");
	}

}
