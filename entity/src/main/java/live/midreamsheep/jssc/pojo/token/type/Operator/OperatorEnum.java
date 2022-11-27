package live.midreamsheep.jssc.pojo.token.type.Operator;

public enum OperatorEnum {
    //加
    ADD("+", 0),
    //减
    SUB("-", 1),
    //乘
    MUL("*", 2),
    //除
    DIV("/", 3),
    //取余
    MOD("%", 4),
    //等于
    O_EQ("=", 5),
    //大于等于
    GE(">=", 6),
    //大于
    GT(">", 7),
    //小于等于
    LE("<=", 8),
    //小于
    LT("<", 9),
    //取反
    NE("!", 10),
    //与
    AND("&", 11),
    //或
    OR("|", 12),
    //非
    NOT("~", 13),
    //左移
    LSH("<<", 14),
    //右移
    RSH(">>", 15),
    //无符号右移
    URSH(">>>", 16),
    //不等于
    NOT_EQ("!=", 17),
    //相等
    EQUAL("==", 18),
    //三目？
    TERNARY("?", 19),
    //三目：
    TERNARY_COLON(":", 20),
    //^
    XOR("^", 21);
    final String value;
    final int key;
    OperatorEnum(String value, int key) {
        this.value = value;
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public int getKey() {
        return key;
    }
}
