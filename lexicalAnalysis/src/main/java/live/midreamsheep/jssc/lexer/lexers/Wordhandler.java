package live.midreamsheep.jssc.lexer.lexers;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.taken.Taken;
import live.midreamsheep.jssc.pojo.taken.TakenType;

import java.util.List;

public class Wordhandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Taken> takenList) {
        StringBuilder stringBuilder = new StringBuilder();
        while (pointer < bytes.length && (bytes[pointer] >= 'a' && bytes[pointer] <= 'z' || bytes[pointer] >= 'A' && bytes[pointer] <= 'Z' || bytes[pointer] >= '0' && bytes[pointer] <= '9' || bytes[pointer] == '_'||bytes[pointer]=='$')) {
            stringBuilder.append((char) bytes[pointer]);
            pointer++;
        }
        takenList.add(new Taken(TakenType.IDENTIFIER, stringBuilder.toString(), 0));
        return pointer;
    }
}
