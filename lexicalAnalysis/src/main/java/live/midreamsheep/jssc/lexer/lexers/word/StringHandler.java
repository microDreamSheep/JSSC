package live.midreamsheep.jssc.lexer.lexers.word;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;

import java.util.List;

/**
 * @author midreamsheep
 * 字符串处理器
 * */
public class StringHandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Token> takenList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((char) bytes[pointer]);
        pointer++;
        int i = pointer;
        while (pointer < bytes.length && (bytes[pointer]!='\"'&&(bytes[pointer] == '"'&&bytes[pointer-1]=='\\'))) {
            pointer++;
        }
        stringBuilder.append(new String(bytes, i, pointer - i));
        try {
            stringBuilder.append((char) bytes[pointer]);
        }catch (Exception e){
            System.out.println(takenList);
            throw new RuntimeException("字符串未闭合");
        }

        takenList.add(new Token(TokenTypeEnum.String, stringBuilder.toString(), 0));
        pointer++;
        return pointer;
    }
}
