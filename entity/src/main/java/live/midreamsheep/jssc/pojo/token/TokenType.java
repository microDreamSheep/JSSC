package live.midreamsheep.jssc.pojo.token;

public enum TokenType {
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
    //左右括号()与左右{}与左右[]
    BRACKET,
    //特殊符号 , . 。等
    SPECIAL_SYMBOL,
    //空白
    BLANK,
    //注释
    COMMENT,
    //字符串
    String
}