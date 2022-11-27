package live.midreamsheep.jssc.lexer.lexers.special;

import live.midreamsheep.jssc.pojo.token.Token;

public enum Others {
    //换行
    NEW_LINE(){
        @Override
        public Token getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //空格
    SPACE(){
        @Override
        public Token getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //制表符
    TAB(){
        @Override
        public Token getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //#{
    START(){
        @Override
        public Token getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //}
    END(){
        @Override
        public Token getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //.
    POINT(){
        @Override
        public Token getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //(
    LEFT_BRACKET(){
        @Override
        public Token getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //)
    RIGHT_BRACKET(){
        @Override
        public Token getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //;
    SEMICOLON(){
        @Override
        public Token getTaken(int pointer, byte[] datas) {
            return null;
        }
    };
    public abstract Token getTaken(int pointer, byte[] datas);
}
