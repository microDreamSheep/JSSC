package live.midreamsheep.jssc.pojo.token.type.comment;

/**
 * 注释类型
 * @author midreamsheep
 * @date 2020/10/26
 * */
public enum CommentEnum {
    SINGLE_LINE(0),
    MULTI_OR_DOC_LINE(1);

    private int type;

    CommentEnum(int i){
        this.type = i;
    }

    public int getType() {
        return type;
    }
}
