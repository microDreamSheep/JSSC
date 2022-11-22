package live.midreamsheep.jssc.lexer;

import live.midreamsheep.jssc.lexer.lexers.NumberHandler;
import live.midreamsheep.jssc.lexer.lexers.special.SpecialHandler;
import live.midreamsheep.jssc.lexer.lexers.Wordhandler;

public class LexerHandOut {
    static NumberHandler numberHandler = new NumberHandler();
    static Wordhandler wordhandler = new Wordhandler();

    static SpecialHandler specialHandler = new SpecialHandler();
    public static LexerHandlerInter getHandler(byte content){
        if(content>='0'&&content<='9'){
            return numberHandler;
        }
        if ((content>='a'&&content<='z')||(content>='A'&&content<='Z')||content=='_'||content=='$'){
            return wordhandler;
        }
        return specialHandler;
    }
}
