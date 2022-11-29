package live.midreamsheep.jssc.lexer.lexers;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;

import java.util.List;

public class WordHandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Token> takenList) {
        StringBuilder stringBuilder = new StringBuilder();
        while (pointer < bytes.length && (bytes[pointer] >= 'a' && bytes[pointer] <= 'z' || bytes[pointer] >= 'A' && bytes[pointer] <= 'Z' || bytes[pointer] >= '0' && bytes[pointer] <= '9' || bytes[pointer] == '_'||bytes[pointer]=='$')) {
            stringBuilder.append((char) bytes[pointer]);
            pointer++;
        }
        takenList.add(new Token(TokenTypeEnum.IDENTIFIER, stringBuilder.toString(), 0));
        return pointer;
    }
}
