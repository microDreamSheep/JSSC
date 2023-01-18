package live.midreamsheep.jssc.jss;

import live.midreamsheep.jssc.HandlerInter;
import live.midreamsheep.jssc.pojo.token.Token;

import java.util.List;

public abstract class JssHandlerAbstract implements HandlerInter {

    protected Executor executor;

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override
    public abstract List<Token> handle(String arg, List<Token> tokens, int currentPointer);
}
