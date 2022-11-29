package live.midreamsheep.jssc.lexer.lexers.special.bracket;

import java.util.HashMap;
import java.util.Map;

/**
 * @author midreamsheep
 * 界符映射器
 * */
public class BracketMapper {
    //界符映射
    public static final Map<String,Integer> bracketMap = new HashMap<>();
    static{
        bracketMap.put("(",1);
        bracketMap.put(")",1);
        bracketMap.put("{",2);
        bracketMap.put("}",2);
        bracketMap.put("[",3);
        bracketMap.put("]",3);
    }
}
