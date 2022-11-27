package live.midreamsheep.jssc.lexer.lexers;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenType;

import java.util.List;

public class StringHandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Token> takenList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((char) bytes[pointer]);
        while (pointer < bytes.length && bytes[pointer] != '"') {
            stringBuilder.append((char) bytes[pointer]);
            pointer++;
        }
        stringBuilder.append((char) bytes[pointer]);
        takenList.add(new Token(TokenType.String, stringBuilder.toString(), 0));
        return ++pointer;
    }
}
