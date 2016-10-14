package org.midstr.beans;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringUtils;

public class ComputerEditor extends PropertyEditorSupport {
	
	@Override
	public void firePropertyChange() {
		super.firePropertyChange();
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// name-ip
		if (StringUtils.isBlank(text)) {
			setValue(null);
		} else {
			String[] ary = text.split("-");
			Computer computer = new Computer();
			computer.setName(ary[0]);
			computer.setIp(ary[1]);
			setValue(computer);
		}
	}
	
	@Override
	public String getAsText() {
		return super.getAsText();
	}
	
}
