package live.midreamsheep.jssc.lexer.lexers;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.taken.Taken;
import live.midreamsheep.jssc.pojo.taken.TakenType;

import java.util.List;

public class OperatorHandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Taken> takenList) {
        switch (bytes[pointer]) {
            case '+':
                takenList.add(new Taken(TakenType.OPERATOR, "+", 0));
                return ++pointer;
            case '-':
                takenList.add(new Taken(TakenType.OPERATOR, "-", 1));
                return ++pointer;
            case '*':
                takenList.add(new Taken(TakenType.OPERATOR, "*", 2));
                return ++pointer;
            case '/':
                takenList.add(new Taken(TakenType.OPERATOR, "/", 3));
                return ++pointer;
            case '%':
                takenList.add(new Taken(TakenType.OPERATOR, "%", 4));
                return ++pointer;
            case '=':
                takenList.add(new Taken(TakenType.OPERATOR, "=", 5));
                return ++pointer;
            case '>':
                if(bytes[pointer+1]=='='){
                    takenList.add(new Taken(TakenType.OPERATOR, ">=", 6));
                    return pointer+2;
                }
                takenList.add(new Taken(TakenType.OPERATOR, ">", 7));
                return ++pointer;
            case '<':
                if(bytes[pointer+1]=='='){
                    takenList.add(new Taken(TakenType.OPERATOR, "<=", 8));
                    return pointer+2;
                }
                takenList.add(new Taken(TakenType.OPERATOR, "<", 9));
                return ++pointer;
            case '!':
                takenList.add(new Taken(TakenType.OPERATOR, "!", 10));
                return ++pointer;
            case '&':
                takenList.add(new Taken(TakenType.OPERATOR, "&", 11));
                return ++pointer;
            case '|':
                takenList.add(new Taken(TakenType.OPERATOR, "|", 12));
                return ++pointer;
            case '^':
                takenList.add(new Taken(TakenType.OPERATOR, "^", 13));
                return ++pointer;
            case '~':
                takenList.add(new Taken(TakenType.OPERATOR, "~", 14));
                return ++pointer;
            case '?':
                takenList.add(new Taken(TakenType.OPERATOR, "?", 15));
                return ++pointer;
            case ':':
                takenList.add(new Taken(TakenType.OPERATOR, ":", 16));
                return ++pointer;
        }
        return ++pointer;
    }
}
