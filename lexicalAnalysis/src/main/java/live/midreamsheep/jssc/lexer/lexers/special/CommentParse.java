package live.midreamsheep.jssc.lexer.lexers.special;

import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;
import live.midreamsheep.jssc.pojo.token.type.comment.CommentEnum;

import java.util.List;

/**
 * @author midreamsheep
 * 注释处理器
 * */
public class CommentParse {

    /**
     * 处理注释
     * @param bytes 字节流
     * @param pointer 指针
     * @param takenList token组
     * @return 新指针
     * */
    public static int parse(byte[] bytes, int pointer, List<Token> takenList) {
        switch (bytes[pointer + 1]) {
            case '/':
                return SingleLineCommentParse(bytes, pointer, takenList);
            case '*':
                return MultiLineCommentParse(bytes, pointer, takenList);
        }
        return pointer+1;
    }
    /**
     * 处理多行注释
     * @param bytes 字节流
     * @param pointer 指针
     * @param takenList token组
     * @return 新指针
     * */
    private static int MultiLineCommentParse(byte[] bytes, int pointer, List<Token> takenList) {
        pointer+=2;
        StringBuilder sb = new StringBuilder();
        sb.append("/*");
        int i = pointer;
        while(!(bytes[pointer] == '*'&&bytes[pointer+1] == '/')){
            pointer++;
        }
        sb.append(new String(bytes, i, pointer - i));
        pointer+=2;
        sb.append("*/");
        takenList.add(new Token(TokenTypeEnum.COMMENT,sb.toString(), CommentEnum.MULTI_OR_DOC_LINE.getType()));
        return pointer;
    }
    /**
     * 处理单行注释
     * @param bytes 字节流
     * @param pointer 指针
     * @param takenList token组
     * @return 新指针
     * */
    private static int SingleLineCommentParse(byte[] bytes, int pointer, List<Token> takenList) {
        pointer+=2;
        StringBuilder sb = new StringBuilder();
        sb.append("//");
        int i = pointer;
        while (pointer < bytes.length && bytes[pointer] != '\n') {
            pointer++;
        }
        sb.append(new String(bytes, i, pointer - i));
        takenList.add(new Token(TokenTypeEnum.COMMENT,sb.toString(), CommentEnum.MULTI_OR_DOC_LINE.getType()));
        return pointer;
    }
}
