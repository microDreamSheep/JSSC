package live.midreamsheep.jssc.lexer;

import live.midreamsheep.jssc.lexer.lexers.number.NumberHandler;
import live.midreamsheep.jssc.lexer.lexers.oprator.OperatorHandler;
import live.midreamsheep.jssc.lexer.lexers.special.SpecialHandler;
import live.midreamsheep.jssc.lexer.lexers.word.StringHandler;
import live.midreamsheep.jssc.lexer.lexers.word.WordHandler;

public class LexerHandOut {
    static NumberHandler numberHandler = new NumberHandler();
    static WordHandler wordhandler = new WordHandler();
    static OperatorHandler operatorHandler = new OperatorHandler();

    static SpecialHandler specialHandler = new SpecialHandler();
    static StringHandler stringHandler = new StringHandler();
    public static LexerHandlerInter getHandler(byte[] data, int pointer) {
        int content = data[pointer];
        if(content>='0'&&content<='9'){
            return numberHandler;
        }
        if ((content>='a'&&content<='z')||(content>='A'&&content<='Z')||content=='_'||content=='$'){
            return wordhandler;
        }
        //运算符
        if(content=='+'||content=='-'||content=='*'||content=='%'||content=='='||content=='>'||content=='<'||content=='!'||(content=='/'&&!(data[pointer+1]=='/'||data[pointer+1]=='*'))){
            return operatorHandler;
        }
        //字符串
        if(content=='"'){
            return stringHandler;
        }
        return specialHandler;
    }
}
