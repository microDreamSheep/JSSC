package live.midreamsheep.jssc.lexer;

import live.midreamsheep.jssc.lexer.lexers.number.NumberHandler;
import live.midreamsheep.jssc.lexer.lexers.oprator.OperatorHandler;
import live.midreamsheep.jssc.lexer.lexers.special.SpecialHandler;
import live.midreamsheep.jssc.lexer.lexers.WordHandler;

public class LexerHandOut {
    static NumberHandler numberHandler = new NumberHandler();
    static WordHandler wordhandler = new WordHandler();
    static OperatorHandler operatorHandler = new OperatorHandler();

    static SpecialHandler specialHandler = new SpecialHandler();
    public static LexerHandlerInter getHandler(byte content){
        if(content>='0'&&content<='9'){
            return numberHandler;
        }
        if ((content>='a'&&content<='z')||(content>='A'&&content<='Z')||content=='_'||content=='$'){
            return wordhandler;
        }
        //运算符
        if(content=='+'||content=='-'||content=='*'||content=='%'||content=='='||content=='>'||content=='<'||content=='!'){
            return operatorHandler;
        }
        //字符串
        if(content=='"'){
            return specialHandler;
        }
        return specialHandler;
    }
}
