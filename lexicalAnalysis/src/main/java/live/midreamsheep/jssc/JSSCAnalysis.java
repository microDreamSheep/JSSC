package live.midreamsheep.jssc;

import live.midreamsheep.jssc.io.SIO;
import live.midreamsheep.jssc.lexer.LexerHandOut;
import live.midreamsheep.jssc.pojo.token.Token;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author midreamsheep
 * 词法分析器
 * */
public class JSSCAnalysis {
    /**
     * 词法分析
     * @param file 文件
     * @return 词素列表
     * */
    public static List<Token> analyzeAJavaFile(File file) {
        List<Token> takenList = new LinkedList<>();
        byte[] bytes = SIO.readAFile(file).getBytes();
        for(int i = 0;i<bytes.length;){
            i = LexerHandOut.getHandler(bytes,i).handle(bytes,i,takenList);
        }
        return takenList;
    }
}
