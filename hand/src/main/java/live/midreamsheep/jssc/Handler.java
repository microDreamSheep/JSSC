package live.midreamsheep.jssc;

import live.midreamsheep.jssc.jss.meta.USE;

import java.util.HashMap;
import java.util.Map;

public class Handler {
    public static final Map<String, Map<String,HandlerInter>> HANDLER_MAP = new HashMap<>();
    public static final Map<String, HandlerInter> currentMap = new HashMap<>();

    static{
        HashMap<String,HandlerInter> metaFunction = new HashMap<>();
        metaFunction.put("use",new USE());
        HANDLER_MAP.put("live.midreamsheep.jssc.meta",metaFunction);
    }
}
