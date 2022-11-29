package live.midreamsheep.jssc.lexer.lexers.number;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;

import java.util.List;

/**
 * @author midreamsheep
 * 数字处理器
 * */
public class NumberHandler implements LexerHandlerInter {

    @Override
    public int handle(byte[] bytes, int pointer, List<Token> takenList) {
        StringBuilder sb = new StringBuilder();
        while (bytes[pointer] >= '0' && bytes[pointer] <= '9') {
            sb.append((char) bytes[pointer]);
            pointer++;
        }
        takenList.add(new Token(TokenTypeEnum.NUMBER, sb.toString(),0));
        return pointer;
    }
}
