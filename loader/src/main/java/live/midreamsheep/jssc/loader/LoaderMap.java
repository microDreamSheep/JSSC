package live.midreamsheep.jssc.loader;

import live.midreamsheep.jssc.loader.loaders.JarsLoader;

import java.util.HashMap;
import java.util.Map;

public class LoaderMap {
    public static final Map<String,LoaderInter> loaderMap=new HashMap<>();
    static {
        loaderMap.put("jars",new JarsLoader());
    }
}
