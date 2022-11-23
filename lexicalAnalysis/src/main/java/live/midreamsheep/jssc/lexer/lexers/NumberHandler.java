package live.midreamsheep.jssc.lexer.lexers;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.taken.Taken;
import live.midreamsheep.jssc.pojo.taken.TakenType;

import java.util.List;

public class NumberHandler implements LexerHandlerInter {


    @Override
    public int handle(byte[] bytes, int pointer, List<Taken> takenList) {
        StringBuilder sb = new StringBuilder();
        while (bytes[pointer] >= '0' && bytes[pointer] <= '9') {
            sb.append((char) bytes[pointer]);
            pointer++;
        }
        takenList.add(new Taken(TakenType.NUMBER, sb.toString(),0));
        return pointer;
    }
}
