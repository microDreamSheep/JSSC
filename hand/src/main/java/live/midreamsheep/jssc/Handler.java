package live.midreamsheep.jssc;

import live.midreamsheep.jssc.jss.meta.USE;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Handler {
    public static final Map<String, Map<String,HandlerInter>> HANDLER_MAP = new HashMap<>();
    public static final Map<String, HandlerInter> currentMap = new HashMap<>();

    static{
        HashMap<String,HandlerInter> metaFunction = new HashMap<>();
        metaFunction.put("use",new USE());
        HANDLER_MAP.put("live.midreamsheep.jssc.meta",metaFunction);
        HashMap<String,HandlerInter> TestFunction = new HashMap<>();

        TestFunction.put("print",(arg)->{
            ArrayList<Token> objects = new ArrayList<>();
            objects.add(new Token(TokenTypeEnum.JSSC,"System.out.print("+arg+");",0));
            return objects;
        });
        HANDLER_MAP.put("test",TestFunction);
    }
}
