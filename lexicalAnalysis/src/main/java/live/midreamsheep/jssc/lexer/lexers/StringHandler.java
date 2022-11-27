package live.midreamsheep.jssc.lexer.lexers;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.taken.Taken;
import live.midreamsheep.jssc.pojo.taken.TakenType;

import java.util.List;

public class StringHandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Taken> takenList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((char) bytes[pointer]);
        while (pointer < bytes.length && bytes[pointer] != '"') {
            stringBuilder.append((char) bytes[pointer]);
            pointer++;
        }
        stringBuilder.append((char) bytes[pointer]);
        takenList.add(new Taken(TakenType.String, stringBuilder.toString(), 0));
        return ++pointer;
    }
}
