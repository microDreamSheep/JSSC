package live.midreamsheep.jssc.lexer.lexers.special;

import java.util.HashMap;
import java.util.Map;

import static live.midreamsheep.jssc.constant.ConstantData.NULL;

/**
 * @author midreamsheep
 * 空白映射器
 * */
public class BlankMapper {
    //空白映射
    public static final Map<String, Object> blankMap = new HashMap<>();
    static {
        blankMap.put(" ",NULL);
        blankMap.put("\t",NULL);
        blankMap.put("\r",NULL);
        blankMap.put("\n",NULL);
    }
}
