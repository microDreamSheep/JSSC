package live.midreamsheep.jssc.jss.meta;

import live.midreamsheep.jssc.Handler;
import live.midreamsheep.jssc.HandlerInter;
import live.midreamsheep.jssc.jss.JssHandlerAbstract;
import live.midreamsheep.jssc.pojo.token.Token;

import java.util.List;
import java.util.Map;

public class USE extends JssHandlerAbstract {
    @Override
    public List<Token> handle(String arg) {
        String[] split = arg.split(",");
        for (String s : split) {
            Map<String, HandlerInter> map = Handler.HANDLER_MAP.get(s.trim());
            if(map==null){
                throw new RuntimeException("not found "+s+",please check your package name");
            }
            Handler.currentMap.putAll(map);
        }
        return null;
    }
}
