package live.midreamsheep.jssc.pojo.token;

/**
 * @author midreamsheep
 * token类型的枚举
 * */
public enum TokenTypeEnum {
    //数字
    NUMBER,
    //java 关键字
    KEYWORD,
    //jssc标识符
    JSSC_KEYWORD,
    //标识符
    IDENTIFIER,
    //运算符
    OPERATOR,
    //界符 ;
    DELIMITER,
    //左右括号()与左右{}与左右[] 界符
    BRACKET,
    //特殊符号 ,。等
    SPECIAL_SYMBOL,
    //引用符 .
    QUOTATION_MARK,
    //空白
    BLANK,
    //注释
    COMMENT,
    //字符串
    String
}
