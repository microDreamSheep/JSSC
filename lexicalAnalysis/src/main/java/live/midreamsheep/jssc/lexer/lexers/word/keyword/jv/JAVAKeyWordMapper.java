package live.midreamsheep.jssc.lexer.lexers.word.keyword.jv;

import live.midreamsheep.jssc.pojo.token.type.keyword.javakeyword.JAVAKeyWordEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author midreamsheep
 * java关键字映射器
 * */
public class JAVAKeyWordMapper {
    //java关键字映射
    public static final Map<String,JAVAKeyWordEnum> KEY_WORD_MAP = new HashMap<>();
    static {
        KEY_WORD_MAP.put("for", JAVAKeyWordEnum.FOR);
        KEY_WORD_MAP.put("while", JAVAKeyWordEnum.WHILE);
        KEY_WORD_MAP.put("if", JAVAKeyWordEnum.IF);
        KEY_WORD_MAP.put("else", JAVAKeyWordEnum.ELSE);
        KEY_WORD_MAP.put("switch", JAVAKeyWordEnum.SWITCH);
        KEY_WORD_MAP.put("case", JAVAKeyWordEnum.CASE);
        KEY_WORD_MAP.put("default", JAVAKeyWordEnum.DEFAULT);
        KEY_WORD_MAP.put("do", JAVAKeyWordEnum.DO);
        KEY_WORD_MAP.put("try", JAVAKeyWordEnum.TRY);
        KEY_WORD_MAP.put("catch", JAVAKeyWordEnum.CATCH);
        KEY_WORD_MAP.put("finally", JAVAKeyWordEnum.FINALLY);
        KEY_WORD_MAP.put("throw", JAVAKeyWordEnum.THROW);
        KEY_WORD_MAP.put("throws", JAVAKeyWordEnum.THROWS);
        KEY_WORD_MAP.put("return", JAVAKeyWordEnum.RETURN);
        KEY_WORD_MAP.put("continue", JAVAKeyWordEnum.CONTINUE);
        KEY_WORD_MAP.put("break", JAVAKeyWordEnum.BREAK);
        KEY_WORD_MAP.put("new", JAVAKeyWordEnum.NEW);
        KEY_WORD_MAP.put("instanceof", JAVAKeyWordEnum.INSTANCEOF);
        KEY_WORD_MAP.put("this", JAVAKeyWordEnum.THIS);
        KEY_WORD_MAP.put("import", JAVAKeyWordEnum.IMPORT);
        KEY_WORD_MAP.put("package", JAVAKeyWordEnum.PACKAGE);
        KEY_WORD_MAP.put("class", JAVAKeyWordEnum.CLASS);
        KEY_WORD_MAP.put("interface", JAVAKeyWordEnum.INTERFACE);
        KEY_WORD_MAP.put("extends", JAVAKeyWordEnum.EXTENDS);
        KEY_WORD_MAP.put("implements", JAVAKeyWordEnum.IMPLEMENTS);
        KEY_WORD_MAP.put("static", JAVAKeyWordEnum.STATIC);
        KEY_WORD_MAP.put("final", JAVAKeyWordEnum.FINAL);
        KEY_WORD_MAP.put("abstract", JAVAKeyWordEnum.ABSTRACT);
        KEY_WORD_MAP.put("private", JAVAKeyWordEnum.PRIVATE);
        KEY_WORD_MAP.put("protected", JAVAKeyWordEnum.PROTECTED);
        KEY_WORD_MAP.put("public", JAVAKeyWordEnum.PUBLIC);
        KEY_WORD_MAP.put("native", JAVAKeyWordEnum.NATIVE);
    }
}
