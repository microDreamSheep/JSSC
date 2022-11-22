package live.midreamsheep.jssc.lexer;

import live.midreamsheep.jssc.pojo.taken.Taken;

import java.util.List;

public interface LexerHandlerInter {

    int handle(byte[] bytes, int pointer, List<Taken> takenList);
}
