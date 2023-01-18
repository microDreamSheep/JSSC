package live.midreamsheep.jssc;

import live.midreamsheep.jssc.pojo.token.Token;
import java.util.List;

public interface HandlerInter {
    List<Token> handle(String arg,List<Token> tokens,int currentPointer);
}