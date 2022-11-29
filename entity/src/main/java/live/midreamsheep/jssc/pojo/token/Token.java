package live.midreamsheep.jssc.pojo.token;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author midreamsheep
 * 词法分析的token
 */
@Data
@AllArgsConstructor
public class Token {
    //token的类型
    TokenTypeEnum tokenType;
    //token的值
    String value;
    //token的指向值
    int type;
}
