package live.midreamsheep.jssc.lexer.lexers.special.bracket;

import java.util.HashMap;
import java.util.Map;

public class BracketMapper {
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
