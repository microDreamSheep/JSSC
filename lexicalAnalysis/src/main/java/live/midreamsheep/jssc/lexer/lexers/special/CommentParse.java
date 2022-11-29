package live.midreamsheep.jssc.lexer.lexers.special;

import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;
import live.midreamsheep.jssc.pojo.token.type.comment.CommentEnum;

import java.util.List;

public class CommentParse {
    public static int parse(byte[] bytes, int pointer, List<Token> takenList) {
        switch (bytes[pointer + 1]) {
            case '/':
                return SingleLineCommentParse(bytes, pointer, takenList);
            case '*':
                return MultiLineCommentParse(bytes, pointer, takenList);
        }
        return pointer+1;
    }

    private static int MultiLineCommentParse(byte[] bytes, int pointer, List<Token> takenList) {
        pointer+=2;
        StringBuilder sb = new StringBuilder();
        sb.append("/*");
        while(!(bytes[pointer] == '*'&&bytes[pointer+1] == '/')){
            sb.append((char)bytes[pointer]);
            pointer++;
        }
        pointer+=2;
        sb.append("*/");
        takenList.add(new Token(TokenTypeEnum.COMMENT,sb.toString(), CommentEnum.MULTI_OR_DOC_LINE.getType()));
        return pointer;
    }

    private static int SingleLineCommentParse(byte[] bytes, int pointer, List<Token> takenList) {
        pointer+=2;
        StringBuilder sb = new StringBuilder();
        sb.append("//");
        while(bytes[pointer] != '\n'){
            sb.append((char)bytes[pointer]);
            pointer++;
        }
        takenList.add(new Token(TokenTypeEnum.COMMENT,sb.toString(), CommentEnum.MULTI_OR_DOC_LINE.getType()));
        return pointer;
    }
}
