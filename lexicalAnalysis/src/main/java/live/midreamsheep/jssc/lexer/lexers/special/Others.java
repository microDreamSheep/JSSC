package live.midreamsheep.jssc.lexer.lexers.special;

import live.midreamsheep.jssc.pojo.taken.Taken;

public enum Others {
    //换行
    NEW_LINE(),
    //空格
    SPACE(),
    //制表符
    TAB(),
    //#{
    START(),
    //}
    END(),
    //.
    POINT(),
    //(
    LEFT_BRACKET(),
    //)
    RIGHT_BRACKET(),
    //;
    SEMICOLON();
    public abstract Taken getTaken(int pointer,byte[] datas);
}
