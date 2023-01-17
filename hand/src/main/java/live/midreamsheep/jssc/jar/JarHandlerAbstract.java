package live.midreamsheep.jssc.jar;

import live.midreamsheep.jssc.HandlerInter;
import live.midreamsheep.jssc.param.ParameterParser;
import live.midreamsheep.jssc.pojo.param.JssValue;
import live.midreamsheep.jssc.pojo.token.Token;

import java.util.List;

public abstract class JarHandlerAbstract implements HandlerInter {
    @Override
    public List<Token> handle(String arg) {
        return handle(ParameterParser.StandardParser(arg));
    }
    protected abstract List<Token> handle(JssValue[] args);
}
