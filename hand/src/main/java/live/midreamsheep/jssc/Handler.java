package live.midreamsheep.jssc;

import live.midreamsheep.jssc.jss.meta.USE;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Handler {
    public static final Map<String, Map<String,HandlerInter>> HANDLER_MAP = new HashMap<>();
    public static final Map<String, HandlerInter> currentMap = new HashMap<>();

    static{
        Map<String,HandlerInter> metaFunction = new HashMap<>();
        metaFunction.put("use",new USE());
        HANDLER_MAP.put("live.midreamsheep.jssc.meta",metaFunction);

        Map<String,HandlerInter> testFunction = new HashMap<>();
        testFunction.put("print",((arg, tokens, currentPointer) -> Collections.singletonList(new Token(TokenTypeEnum.JSSC, "System.out.print(" + arg + ");", 0))));
        HANDLER_MAP.put("live.midreamsheep.sugar",testFunction);
    }
}
