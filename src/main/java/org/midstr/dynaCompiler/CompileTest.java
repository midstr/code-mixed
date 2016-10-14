package org.midstr.dynaCompiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//import sun.tools.jar.Main;

public class CompileTest {

	public static void main(String[] args) {
		try {
			File file = File.createTempFile("RunTime", ".java", new File(System
					.getProperty("user.dir")));
			String filename = file.getName();
			String classname = filename.substring(0, filename.indexOf('.'));
			PrintWriter out = new PrintWriter(new FileOutputStream(file));
			out.println("public class " + classname + "{");
			out.println("public static void main(String[] args){");
			out.println("System.out.println(\"Yes!\");");
			out.println("}}");
			out.flush();
			out.close();
			/*String[] arg = new String[] { "-d", System.getProperty("user.dir"),
					filename };
			int status = javac.compile(arg);
			Class cls = Class.forName(classname);
			Method main = cls.getMethod("main", new Class[] { String[].class });
			main.invoke(null, new Object[] { new String[0] });
			file.delete();
			file = new File(classname + ".class");
			file.delete();*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
