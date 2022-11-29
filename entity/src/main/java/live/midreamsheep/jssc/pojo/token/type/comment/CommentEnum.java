package live.midreamsheep.jssc.pojo.token.type.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 注释类型
 * @author midreamsheep
 * 用于分辨不同的注释类型
 * */
@AllArgsConstructor
@Getter
public enum CommentEnum {
    /**
     * 单行注释
     * */
    SINGLE_LINE(0),
    /**
     * 多行注释或文档注释
     * */
    MULTI_OR_DOC_LINE(1);
    //注释类型
    private final int type;

}
