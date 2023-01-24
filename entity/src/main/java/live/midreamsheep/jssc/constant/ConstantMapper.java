package live.midreamsheep.jssc.constant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConstantMapper {
    //制表符常量
    public static final Set<Character> BLANK = new HashSet<>();
    static {
        BLANK.add(' ');
        BLANK.add('\t');
        BLANK.add('\r');
        BLANK.add('\n');
    }
    //分节符常量
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
