package org.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

/**
 * Created by liyaogang on 16/10/9.
 */
public class ScriptTest {

    // ECMAScript 5.1规范以及一些扩展
    // 在JDK 7中引入的invokedynamic，将JavaScript编译成Java字节码,与先前的Rhino实现相比，这带来了2到10倍的性能提升
    // 在JavaScript中调用Java类

    // http://stackoverflow.com/questions/30140103/should-i-use-a-separate-scriptengine-and-compiledscript-instances
    // -per-each-threa/30159424#30159424
    // https://blogs.oracle.com/nashorn/entry/nashorn_multi_threading_and_mt

    public static void main(String[] args) throws ScriptException, NoSuchMethodException, FileNotFoundException,
            ExecutionException, InterruptedException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");//.getEngineByName("nashorn");

        Object obj = engine.getFactory().getParameter("THREADING");
        System.out.println(obj);


//        engine.eval("function sum(a,b){return a+b;};");
//        System.out.println("Result:" + engine.eval("function f() { return 1; }; f() + 1;"));
//        System.out.println(engine.eval("sum(2,3)"));
//        System.out.println(engine.eval("f()"));
//
//        Invocable invocable = (Invocable) engine;
//        System.out.println(invocable.invokeFunction("sum", 1, 3));


//        engine.eval(new FileReader("/Users/liyaogang/work/java/automan/automan-firework/src/main/java/com/meituan
// /service/mobile/automan/firework/service/impl/test.js"));
//        engine.eval("load('automan-firework/src/main/java/com/meituan/service/mobile/automan/firework/service/impl" +
//                "/test.js')");
//
//
//        int valueIn = 10;
//        SimpleBindings simpleBindings = new SimpleBindings();
//        simpleBindings.put("globalValue", valueIn);
//        engine.eval("print(globalValue)", simpleBindings);

//        String function = "function sum(a,b) {x=x+10;return a+x;}; sum(a)";
//
//        long start = System.currentTimeMillis();
//        Bindings bindings = engine.createBindings();
//        bindings.put("a", 1);
//        bindings.put("b", 2);
//        for (int i = 0; i < 10; i++) {
//            System.out.println("value:"+engine.eval(function, bindings));
//        }
//        System.out.println(System.currentTimeMillis() - start);

//        Invocable invocable = (Invocable) engine;
//        start = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            invocable.invokeFunction(function);
//        }
//        System.out.println(System.currentTimeMillis() - start);

//        engine = manager.getEngineByName("javascript");
//        Compilable compilable = (Compilable) engine;
//        CompiledScript compiledScript = compilable.compile(function);
//
//        start = System.currentTimeMillis();
//        bindings = engine.createBindings();
//        bindings.put("a", 1);
//        bindings.put("b", 2);
//        for (int i = 0; i < 10; i++) {
//            System.out.println("value:"+compiledScript.eval(bindings));
//        }
//        System.out.println(System.currentTimeMillis() - start);


    }


}
