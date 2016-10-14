package org.midstr.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;

public class EditorDemo {
	public static void main(String[] args) {

//		PropertyEditorManager.registerEditor(Computer.class,
//				ComputerEditor.class);

		// 如果注册找不到的话，则先根据“类名+Editor”找，如果还找不到的话则取searchpath去找
		PropertyEditor computerEditor = PropertyEditorManager
				.findEditor(Computer.class);

		//PropertyEditorManager.setEditorSearchPath(path)
		
		computerEditor.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				PropertyEditor pro = (PropertyEditor) evt.getSource();
				System.out.println("propertyChange : " + pro.getValue());
			}
		});

		computerEditor.setAsText("liyg-192.168.128.210");
		computerEditor.setAsText("liyg-192.168.128.210");
		computerEditor.setAsText("liyg-192.168.128.210");

		Computer computer = (Computer) computerEditor.getValue();

		System.out.println(computer.getIp());
		// computer.setName("李耀岗");

	}
}
