package live.midreamsheep.jssc.lexer.lexers;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenHandler;
import live.midreamsheep.jssc.pojo.token.type.Operator.OperatorMapper;

import java.util.List;

public class OperatorHandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Token> takenList) {
        return OperatorMapper.operatorMap.get(((char) bytes[pointer]) + "").handle(bytes, pointer, takenList);
    }
}
