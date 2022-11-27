package live.midreamsheep.jssc.pojo.token.type;

import live.midreamsheep.jssc.pojo.token.Token;

import java.util.List;

public interface ProcessInter {
    int handle(byte[] bytes, int pointer, List<Token> takenList);
}
