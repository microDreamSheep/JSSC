package live.midreamsheep.jssc.lexer.lexers;

import live.midreamsheep.jssc.pojo.token.Token;

import java.util.List;

/**
 * @author midreamsheep
 * 处理器统一接口
 * */
public interface ProcessInter {
    /**
     * 处理器
     * @param bytes 字节流
     * @param pointer 指针
     * @param takenList 词素列表
     * @return 指针
     * */
    int handle(byte[] bytes, int pointer, List<Token> takenList);
}
