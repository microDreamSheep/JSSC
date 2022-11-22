package live.midreamsheep.jssc.lexer.lexers.special;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.taken.Taken;
import live.midreamsheep.jssc.pojo.taken.TakenType;

import java.util.List;

public class SpecialHandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Taken> takenList) {
        //处理注释
        if(bytes[pointer] == '/'){
            pointer = CommentParse.parse(bytes,pointer,takenList);
        }
        return ++pointer;
    }
}