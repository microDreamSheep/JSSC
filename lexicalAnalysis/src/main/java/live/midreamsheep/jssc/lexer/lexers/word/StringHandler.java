package live.midreamsheep.jssc.lexer.lexers.word;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;

import java.util.List;

/**
 * @author midreamsheep
 * 字符串处理器
 * */
public class StringHandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Token> takenList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((char) bytes[pointer]);
        pointer++;
        int i = pointer;
        while (pointer < bytes.length && bytes[pointer] != '"') {
            pointer++;
        }
        stringBuilder.append(new String(bytes, i, pointer - i));
        stringBuilder.append((char) bytes[pointer]);
        takenList.add(new Token(TokenTypeEnum.String, stringBuilder.toString(), 0));
        pointer++;
        return pointer;
    }
}
