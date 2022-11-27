package live.midreamsheep.jssc.lexer.lexers;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.token.Token;

import java.util.List;

public class JAVAKeyWordHandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Token> takenList) {
        return 0;
    }
}
