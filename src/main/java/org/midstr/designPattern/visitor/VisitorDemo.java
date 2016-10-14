package org.midstr.designPattern.visitor;

import java.io.File;

import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.VisitorSupport;
import org.dom4j.io.SAXReader;

/**
 * @author yaogangli
 * @date 2013-7-8 下午4:46:02
 */
public class VisitorDemo {

	/**
	 * @param args
	 * @throws DocumentException
	 */
	public static void main(String[] args) throws DocumentException {
		CarElement car = new Car();
		car.accept(new CarElementPrintVisitor());
		car.accept(new CarElementDoVisitor());

		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("D:\\apache-maven-2.0.9\\conf\\settings.xml"));
		document.accept(new VisitorSupport() {
			/* (non-Javadoc)
			 * @see org.dom4j.VisitorSupport#visit(org.dom4j.Comment)
			 */
			@Override
			public void visit(Comment node) {
			}

			/* (non-Javadoc)
			 * @see org.dom4j.VisitorSupport#visit(org.dom4j.Element)
			 */
			@Override
			public void visit(Element node) {
				if (node.getName().equals("settings")) {
					System.out.println("==========================");
					System.out.println(node.asXML());
					System.out.println("==========================");
				}
			}
		});
		//System.out.println(document.asXML());
	}

}
