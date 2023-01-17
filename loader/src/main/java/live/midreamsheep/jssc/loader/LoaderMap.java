package live.midreamsheep.jssc.loader;

import live.midreamsheep.jssc.loader.loaders.jar.JarsLoader;
import live.midreamsheep.jssc.loader.loaders.jssc.HandlerLoader;

import java.util.HashMap;
import java.util.Map;

public class LoaderMap {
    public static final Map<String,LoaderInter> loaderMap=new HashMap<>();
    static {
        loaderMap.put("jars",new JarsLoader());
        loaderMap.put("jssc",new HandlerLoader());
    }
}
