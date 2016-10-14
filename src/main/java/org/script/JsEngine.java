package org.script;

import javax.script.*;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by liyaogang on 16/10/14.
 */
public class JsEngine {


    private static final ScriptEngineManager manager = new ScriptEngineManager();

    public String render(int eventId, GlobalParam globalParam, String script) {
        ScriptEngine engine = manager.getEngineByName("javascript");
        try {
            engine.eval(script);

            // 准备data数据
            Object data = engine.eval("JSON.parse({'id':1,'name':'liyg'})");
            Invocable invocable = (Invocable) engine;
            Object result = invocable.invokeFunction("render", globalParam, data);
            return (result instanceof String) ? (String) result : result.toString();
        } catch (ScriptException e) {
            //LOGGER.error("engine.eval err!eventId =" + eventId, e);
        } catch (NoSuchMethodException e) {
            //LOGGER.error("engine.invokeFunction err!eventId =" + eventId, e);
        }
        return "";
    }

    public static void main(String[] args) throws Exception {
//        JsEngine jsEngine = new JsEngine();
//        GlobalParam globalParam = new GlobalParam();
//        globalParam.setCityId(123);
//        EventDisplayItem item = new EventDisplayItem();
//        JsConfig jsConfig = new JsConfig();
//        item.setJsConfig(jsConfig);
//        jsConfig.setScript("function render(global,data){return data.id + data.name}");
//        String content = jsEngine.render(1, globalParam,item);
//        System.out.println(content);

        Compilable engine = (Compilable) manager.getEngineByName("javascript");

        String script = new StringBuilder("function render(global, data){i = 0;")
                .append("i += 1;")
                .append("shortly_later = new Date()/1000 + Math.random;") // 0..1 sec later
                .append("while( (new Date()/1000) < shortly_later) { Math.random() };") //prevent optimizations
                .append("i += 1; return i};render(global, JSON.parse(data))")
                .toString();

        //script = "loadWithNewGlobal({name:'liyg', script:'" + script + "'})";


        final CompiledScript onePlusOne = engine.compile(script);

        Callable<Number> addition = new Callable<Number>() {
            @Override
            public Number call() {
                try {

                    return (Number) onePlusOne.eval(getBindings());

//                    return (Number) onePlusOne.eval(new SimpleBindings());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<Number>> results = new ArrayList<Future<Number>>();

        for (int i = 0; i < 50; i++) {
            results.add(executor.submit(addition));
        }

        int miscalculations = 0;
        for (Future<Number> result : results) {
            int jsResult = result.get().intValue();

            if (jsResult != 2) {
                System.out.println("Incorrect result from js, expected 1 + 1 = 2, but got " + jsResult);
                miscalculations += 1;
            } else {
                //System.out.println("jsResult:" + jsResult);
            }
        }

        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdownNow();

        System.out.println("Overall: " + miscalculations + " wrong values for 1 + 1.");
    }

    private static Bindings getBindings() throws Exception {
        GlobalParam globalParam = new GlobalParam();
        globalParam.setCityId(123);
        Bindings bindings = new SimpleBindings();
        bindings.put("global", globalParam);
        //bindings.put("data", engine.eval("eval({'id':123456,'name':'liyg'})"));
        bindings.put("data", "{\"id\":123456,\"name\":\"liyg\"}");
        return bindings;
    }

    private static class GlobalParam {
        private int cityId;

        public int getCityId() {
            return cityId;
        }

        public GlobalParam setCityId(int cityId) {
            this.cityId = cityId;
            return this;
        }
    }
}
