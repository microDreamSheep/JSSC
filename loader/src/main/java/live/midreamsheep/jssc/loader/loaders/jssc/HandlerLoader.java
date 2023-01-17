package live.midreamsheep.jssc.loader.loaders.jssc;

import live.midreamsheep.jssc.Handler;
import live.midreamsheep.jssc.HandlerInter;
import live.midreamsheep.jssc.JSSCAnalysis;
import live.midreamsheep.jssc.api.JsscInjector;
import live.midreamsheep.jssc.io.SIO;
import live.midreamsheep.jssc.load.JssGrammar;
import live.midreamsheep.jssc.loader.LoaderInter;
import live.midreamsheep.jssc.loader.loaders.jar.JarsLoader;
import live.midreamsheep.jssc.pojo.token.Token;
import lombok.SneakyThrows;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class HandlerLoader implements LoaderInter {
    @Override
    public boolean load(String[] dirs) {
        for (String dir : dirs) {
            loadDir(dir);
        }
        return true;
    }

    @SneakyThrows
    private void loadDir(String dir) {
        File file = new File(dir);
        //遍历
        if (!(file.exists() && file.isDirectory())) {
            return;
        }
        File[] files = file.listFiles();
        for (File second : files != null ? files : new File[0]) {
            if (!second.isDirectory()) {
                if (second.getName().endsWith(".jssc")) {
                    JssGrammar.parse(JSSCAnalysis.analyzeAFile(second).toArray(new Token[0]));
                }else if (second.getName().endsWith(".jss")) {
                    String s = SIO.readAFile(second);
                    for (String s1 : s.split("\n")) {
                        loadJar(s1.split("="),file);
                    }
                }
                continue;
            }
            loadDir(second.getAbsolutePath());
        }
    }
    @SneakyThrows
    private static void loadJar(String[] split, File file){
        String className = split[0];
        String path = split[1];
        //加载jar包
        JarsLoader.loadJar(file.getAbsolutePath()+File.separator+path);
        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();
        if(!(o instanceof JsscInjector)){
            throw new RuntimeException("加载的类不是JsscInjector的实现类");
        }
        JsscInjector jsscInjector = (JsscInjector) o;
        jsscInjector.getNamespace();
        jsscInjector.getHandlerMap();
        Map<String,HandlerInter> map = new HashMap<>();
        for (Map.Entry<String, Class<?>> stringClassEntry : jsscInjector.getHandlerMap().entrySet()) {
            String name = stringClassEntry.getKey();
            Object value = stringClassEntry.getValue().newInstance();
            if(!(value instanceof HandlerInter)){
                throw new RuntimeException("加载的类不是HandlerInter的实现类");
            }
            map.put(name,(HandlerInter) value);
        }
        Handler.HANDLER_MAP.put(jsscInjector.getNamespace(),map);
    }

}