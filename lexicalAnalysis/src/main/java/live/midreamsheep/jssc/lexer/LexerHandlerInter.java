package live.midreamsheep.jssc.lexer;

import live.midreamsheep.jssc.pojo.token.Token;

import java.util.List;

public interface LexerHandlerInter {

    int handle(byte[] bytes, int pointer, List<Token> takenList);
}
