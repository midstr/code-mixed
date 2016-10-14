package org.midstr.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestRuntimeExe {

	/**
	 * 
	 */
	public void testProcess() {
		// tasklist
		// cmd /c dir
		// cmd /c dir \\windows
		String command = "tasklist";
		try {
			Process process = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			process.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestRuntimeExe test = new TestRuntimeExe();
		test.testProcess();
	}

}