package live.midreamsheep.jssc.param;

import live.midreamsheep.jssc.staticdata.FileMetaData;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ParamMapper {
    private static final Map<String, Consumer<String>> map = new HashMap<>();
    public static Consumer<String> get(String key){
        return map.get(key);
    }
    static{
        map.put("root", s -> FileMetaData.setRootFile(new File(s)));
        map.put("out", s -> FileMetaData.setOutPutFile(new File(s)));
    }
}
