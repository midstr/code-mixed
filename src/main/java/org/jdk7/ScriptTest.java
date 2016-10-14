package org.jdk7;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

/**
 * @author yaogangli
 * @date 2013-4-26 上午10:35:17
 */
public class ScriptTest {

	/**
	 * @param args
	 * @throws ScriptException
	 * @throws NoSuchMethodException
	 */
	public static void main(String[] args) throws Exception {
		testCompilable();
	}

	/**
	 * 
	 */
	public static void test() {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		ScriptEngineFactory factory = engine.getFactory();
		System.out.println(factory.getEngineVersion());
		System.out.println(factory.getNames());
		try {
			engine.eval("print('Hello World')");
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws ScriptException
	 */
	public static void testBindings() throws ScriptException {
		String script = " println(greeting) ";
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");

		//Attribute from ScriptEngineManager
		manager.put("greeting", "Hello from ScriptEngineManager");
		engine.eval(script);

		//Attribute from ScriptEngine
		engine.put("greeting", "Hello from ScriptEngine");
		engine.eval(script);

		//Attribute from eval method
		ScriptContext context = new SimpleScriptContext();
		context.setAttribute("greeting", "Hello from eval method", ScriptContext.ENGINE_SCOPE);
		engine.eval(script, context);
	}

	/**
	 * @throws ScriptException
	 * @throws NoSuchMethodException
	 */
	public static void testInvocable() throws ScriptException, NoSuchMethodException {
		String script = " function greeting(message){println (message);}";
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		engine.eval(script);

		if (engine instanceof Invocable) {
			Invocable invocable = (Invocable) engine;
			invocable.invokeFunction("greeting", "hi");

			// It may through NoSuchMethodException 
			try {
				invocable.invokeFunction("nogreeing");
			} catch (NoSuchMethodException e) {
				// expected
			}
		}
	}

	/**
	 * @throws ScriptException
	 */
	public static void testCompilable() throws ScriptException {
		String script = " println (greeting); greeting= 'Good Afternoon!' ";
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		engine.put("greeting", "Good Morning!");

		if (engine instanceof Compilable) {
			Compilable compilable = (Compilable) engine;
			CompiledScript compiledScript = compilable.compile(script);
			compiledScript.eval();
			compiledScript.eval();
			compiledScript.eval();
			compiledScript.eval();
		}
	}
}
