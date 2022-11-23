package live.midreamsheep.jssc.pojo.taken.type;

/**
 * 注释类型
 * @author midreamsheep
 * @date 2020/10/26
 * */
public enum Comment {
    SINGLE_LINE(0),
    MULTI_OR_DOC_LINE(1);

    private int type;

    Comment(int i){
        this.type = i;
    }

    public int getType() {
        return type;
    }
}
