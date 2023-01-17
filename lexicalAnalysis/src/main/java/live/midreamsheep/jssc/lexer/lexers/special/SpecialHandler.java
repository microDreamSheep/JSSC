package live.midreamsheep.jssc.lexer.lexers.special;

import live.midreamsheep.jssc.lexer.LexerHandlerInter;
import live.midreamsheep.jssc.lexer.lexers.special.bracket.BracketMapper;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;

import java.util.List;

/**
 * @author midreamsheep
 * 特殊符处理器
 * */
public class SpecialHandler implements LexerHandlerInter {
    @Override
    public int handle(byte[] bytes, int pointer, List<Token> takenList) {
        char currentChar = (char)bytes[pointer];
        //处理注释
        if(currentChar=='/'){
            pointer = CommentParse.parse(bytes,pointer,takenList);
            return ++pointer;
        }
        //处理JSSC关键字符
        if(currentChar == '#'){
            takenList.add(new Token(TokenTypeEnum.JSSC,"#%",0));
            pointer++;
            return ++pointer;
        } else if (currentChar == '%') {
            takenList.add(new Token(TokenTypeEnum.JSSC,"#%",1));
            pointer++;
            return ++pointer;
        }
        //制表符
        if (BlankMapper.blankMap.containsKey(""+currentChar)) {
            return parseBlank(bytes, pointer, takenList);
        }
        //处理界符
        if (BracketMapper.bracketMap.containsKey(""+currentChar)) {
            takenList.add(new Token(TokenTypeEnum.BRACKET,""+currentChar,BracketMapper.bracketMap.get(""+currentChar)));
            return ++pointer;
        }
        //处理括号等
        switch (bytes[pointer]) {
            case '.':
                takenList.add(new Token(TokenTypeEnum.QUOTATION_MARK, ".", 2));
                return ++pointer;
            case ';':
                takenList.add(new Token(TokenTypeEnum.DELIMITER, ";", 5));
                return ++pointer;
        }
        takenList.add(new Token(TokenTypeEnum.SPECIAL_SYMBOL,((char)bytes[pointer])+"",-1));
        return ++pointer;
    }
    /**
     * 空白符
     * @param bytes 字节流
     * @param pointer 指针
     * @param takenList token组
     * @return 新指针
     * */
    private int parseBlank(byte[] bytes, int pointer, List<Token> takenList) {
        StringBuilder sb = new StringBuilder();
        while (pointer<bytes.length&&(
                bytes[pointer] == ' '
             || bytes[pointer] == '\t'
             || bytes[pointer] == '\n'
             || bytes[pointer] == '\b'
             || bytes[pointer] == '\r'
        )) {
            sb.append((char) bytes[pointer]);
            pointer++;
        }
        takenList.add(new Token(TokenTypeEnum.BLANK, sb.toString(), 0));
        return pointer;
    }
}