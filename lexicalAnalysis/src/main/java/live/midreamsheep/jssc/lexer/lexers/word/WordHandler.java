package live.midreamsheep.jssc.lexer.lexers.word;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.lexer.lexers.word.keyword.jssc.JSSCKeyWordMapper;
import live.midreamsheep.jssc.lexer.lexers.word.keyword.jv.JAVAKeyWordMapper;
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
        //判断是否java关键字
        if (JAVAKeyWordMapper.KEY_WORD_MAP.containsKey(stringBuilder.toString())) {
            takenList.add(new Token(TokenTypeEnum.KEYWORD, stringBuilder.toString(), JAVAKeyWordMapper.KEY_WORD_MAP.get(stringBuilder.toString()).getId()));
        } else if (JSSCKeyWordMapper.KEY_WORD_MAP.containsKey(stringBuilder.toString())) {
            takenList.add(new Token(TokenTypeEnum.JSSC_KEYWORD, stringBuilder.toString(), JSSCKeyWordMapper.KEY_WORD_MAP.get(stringBuilder.toString()).getId()));
        } else {
            takenList.add(new Token(TokenTypeEnum.IDENTIFIER, stringBuilder.toString(), 0));
        }
        return pointer;
    }
}
