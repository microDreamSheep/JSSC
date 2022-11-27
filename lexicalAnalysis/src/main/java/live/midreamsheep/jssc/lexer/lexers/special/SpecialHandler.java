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
            return ++pointer;
        }
        //处理JSSC关键字符
        if(bytes[pointer] == '#'){
            takenList.add(new Taken(TakenType.JSSC_KEYWORD,"#%",0));
            pointer++;
            return ++pointer;
        } else if (bytes[pointer] == '%') {
            takenList.add(new Taken(TakenType.JSSC_KEYWORD,"#%",1));
            pointer++;
            return ++pointer;
        }
        //制表符
        switch (bytes[pointer]) {
            case ' ':
                takenList.add(new Taken(TakenType.BLANK, " ", 0));
                return ++pointer;
            case '\t':
                takenList.add(new Taken(TakenType.BLANK, "\t", 1));
                return ++pointer;
            case '\n':
                takenList.add(new Taken(TakenType.BLANK, "\n", 2));
                return ++pointer;
            case '\b':
                takenList.add(new Taken(TakenType.BLANK, "\b", 3));
                return ++pointer;
            case '\r':
                takenList.add(new Taken(TakenType.BLANK, "\r", 4));
                return ++pointer;
        }
        //处理括号等
        switch (bytes[pointer]) {
            case '(':
                takenList.add(new Taken(TakenType.BRACKET, "(", 0));
                return ++pointer;
            case ')':
                takenList.add(new Taken(TakenType.BRACKET, ")", 1));
                return ++pointer;
            case '{':
                takenList.add(new Taken(TakenType.BRACKET, "{", 3));
                return ++pointer;
            case '}':
                takenList.add(new Taken(TakenType.BRACKET, "}", 4));
                return ++pointer;
            case '[':
                takenList.add(new Taken(TakenType.BRACKET, "[", 5));
                return ++pointer;
            case ']':
                takenList.add(new Taken(TakenType.BRACKET, "]", 6));
                return ++pointer;
            case '.':
                takenList.add(new Taken(TakenType.SPECIAL_SYMBOL, ".", 2));
                return ++pointer;
            case ';':
                takenList.add(new Taken(TakenType.DELIMITER, ";", 5));
                return ++pointer;
        }
        takenList.add(new Taken(TakenType.SPECIAL_SYMBOL,((char)bytes[pointer])+"",-1));
        return ++pointer;
    }
}