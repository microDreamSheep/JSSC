package live.midreamsheep.jssc.jar;

import live.midreamsheep.jssc.HandlerInter;
import live.midreamsheep.jssc.param.ParameterParser;
import live.midreamsheep.jssc.pojo.param.JssValue;
import live.midreamsheep.jssc.pojo.token.Token;

import java.util.List;

public abstract class JarHandlerAbstract implements HandlerInter {
    @Override
    public List<Token> handle(String arg, List<Token> tokens, int currentPointer) {
        return handle(ParameterParser.StandardParser(arg),tokens,currentPointer);
    }
    protected abstract List<Token> handle(JssValue[] args, List<Token> tokens, int currentPointer);
}
