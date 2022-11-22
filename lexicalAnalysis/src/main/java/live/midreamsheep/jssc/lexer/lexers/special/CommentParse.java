package live.midreamsheep.jssc.lexer.lexers.special;

import live.midreamsheep.jssc.pojo.taken.Taken;
import live.midreamsheep.jssc.pojo.taken.TakenType;

import java.util.List;

public class CommentParse {
    public static int parse(byte[] bytes, int pointer, List<Taken> takenList) {
        switch (bytes[pointer + 1]) {
            case '/':
                return SingleLineCommentParse(bytes, pointer, takenList);
            case '*':
                return MultiLineCommentParse(bytes, pointer, takenList);
        }
        return pointer+1;
    }

    private static int MultiLineCommentParse(byte[] bytes, int pointer, List<Taken> takenList) {
        pointer+=2;
        StringBuilder sb = new StringBuilder();
        sb.append("/*");
        while(!(bytes[pointer] == '*'&&bytes[pointer+1] == '/')){
            sb.append((char)bytes[pointer]);
            pointer++;
        }
        takenList.add(new Taken(TakenType.COMMENT,sb.toString()));
        return pointer;
    }

    private static int SingleLineCommentParse(byte[] bytes, int pointer, List<Taken> takenList) {
        pointer+=2;
        StringBuilder sb = new StringBuilder();
        sb.append("//");
        while(bytes[pointer] != '\n'){
            sb.append((char)bytes[pointer]);
            pointer++;
        }
        takenList.add(new Taken(TakenType.COMMENT,sb.toString()));
        return pointer;
    }
}
