package org.midstr.designPattern.visitor;

/**
 * @author yaogangli
 * @date 2013-7-8 下午4:40:08
 */
public interface CarElementVisitor {

	void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Car car);
}
