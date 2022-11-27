package live.midreamsheep.jssc.lexer.lexers.special;

import live.midreamsheep.jssc.pojo.taken.Taken;

public enum Others {
    //换行
    NEW_LINE(){
        @Override
        public Taken getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //空格
    SPACE(){
        @Override
        public Taken getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //制表符
    TAB(){
        @Override
        public Taken getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //#{
    START(){
        @Override
        public Taken getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //}
    END(){
        @Override
        public Taken getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //.
    POINT(){
        @Override
        public Taken getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //(
    LEFT_BRACKET(){
        @Override
        public Taken getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //)
    RIGHT_BRACKET(){
        @Override
        public Taken getTaken(int pointer, byte[] datas) {
            return null;
        }
    },
    //;
    SEMICOLON(){
        @Override
        public Taken getTaken(int pointer, byte[] datas) {
            return null;
        }
    };
    public abstract Taken getTaken(int pointer,byte[] datas);
}
