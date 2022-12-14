package live.midreamsheep.jssc.lexer;

import live.midreamsheep.jssc.pojo.token.Token;

import java.util.List;

/**
 * @author midreamsheep
 * 词法分析处理器
 * */
public interface LexerHandlerInter {
    /**
     * 处理
     * @param bytes 字节流
     * @param pointer 指针
     * @param takenList 词素列表
     * @return 指针
     * */
    int handle(byte[] bytes, int pointer, List<Token> takenList);
}
