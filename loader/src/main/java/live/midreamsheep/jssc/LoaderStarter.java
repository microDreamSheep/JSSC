package live.midreamsheep.jssc;

import live.midreamsheep.jssc.loader.LoaderMap;

import java.util.Map;

public class LoaderStarter {
    public static void loadStart(Map<String,String[]> load){
        for (Map.Entry<String, String[]> entry : load.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            LoaderMap.loaderMap.get(key).load(value);
        }
    }
}