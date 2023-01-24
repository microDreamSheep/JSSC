package live.midreamsheep.jssc.lexer.lexers.word;

import live.midreamsheep.jssc.constant.ConstantChar;
import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;

import java.util.List;
/**
 * @author midreamsheep
 * 关键字处理器
 * */
public class WordHandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Token> takenList) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = pointer;
        while (pointer < bytes.length && (bytes[pointer] >= 'a' && bytes[pointer] <= 'z' || bytes[pointer] >= 'A' && bytes[pointer] <= 'Z' || bytes[pointer] >= '0' && bytes[pointer] <= '9' || bytes[pointer] == '_'||bytes[pointer]=='$')) {
            pointer++;
        }
        stringBuilder.append(new String(bytes, i, pointer - i));

        i=pointer;
        if(bytes[pointer]== ConstantChar.JSSC_START_ONE &&bytes[pointer+1]==ConstantChar.JSSC_START_TWO){
            pointer+=2;
            while (bytes[pointer]!=ConstantChar.JSSC_END_ONE||bytes[pointer+1]!=ConstantChar.JSSC_END_TWO){
                pointer++;
            }
            pointer+=2;
            stringBuilder.append(new String(bytes, i, pointer - i));
            takenList.add(new Token(TokenTypeEnum.JSSC, stringBuilder.toString(), 0));
            return pointer;
        }
        takenList.add(new Token(TokenTypeEnum.IDENTIFIER, stringBuilder.toString(), 0));
        return pointer;
    }
}
