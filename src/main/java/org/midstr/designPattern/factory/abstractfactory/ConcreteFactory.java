package org.midstr.designPattern.factory.abstractfactory;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ConcreteFactory.java
//  @ Date : 2010-1-4
//  @ Author : 
//
//




public class ConcreteFactory extends AbstractFactory {

	@Override
	public AbstractProduct CreateProduct() {
		return new ConcreteProduct();
	}
}
