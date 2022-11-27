package live.midreamsheep.jssc.lexer.lexers;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenType;

import java.util.List;

public class NumberHandler implements LexerHandlerInter {


    @Override
    public int handle(byte[] bytes, int pointer, List<Token> takenList) {
        StringBuilder sb = new StringBuilder();
        while (bytes[pointer] >= '0' && bytes[pointer] <= '9') {
            sb.append((char) bytes[pointer]);
            pointer++;
        }
        takenList.add(new Token(TokenType.NUMBER, sb.toString(),0));
        return pointer;
    }
}
