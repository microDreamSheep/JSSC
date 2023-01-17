package live.midreamsheep.jssc.parse;

import live.midreamsheep.jssc.FileOut;
import live.midreamsheep.jssc.Handler;
import live.midreamsheep.jssc.HandlerInter;
import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;
import live.midreamsheep.jssc.staticdata.FileMetaData;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author midreamsheep
 * 语法分析器
 * */
public class GrammarParse {
    /**
     * 语法分析并输出
     * @param tokenList 词法分析的token组
     * */
    public static void ParseAndOut(List<Token> tokenList,File toFile){
        System.out.println("语法分析开始");
        Handler.currentMap.clear();
        Map<Token,List<Token>> replaceMap = new HashMap<>();
        List<Token> removeList = new LinkedList<>();
        for (Token token : tokenList) {
            if(!token.getTokenType().equals(TokenTypeEnum.JSSC)){
                continue;
            }
            String total = token.getValue();
            String name = total.substring(0, total.indexOf("!#"));
            //源宏加载
            HandlerInter inter = Handler.HANDLER_MAP.get("live.midreamsheep.jssc.meta").get(name);
            String args = total.substring(total.indexOf("#(") + 2, total.lastIndexOf(")#"));
            if(inter!=null){
                inter.handle(args);
                removeList.add(token);
                continue;
            }
            //用户宏加载
            inter = Handler.currentMap.get(name);
            if(inter==null){
                throw new RuntimeException("not found "+name);
            }
            List<Token> handle = inter.handle(args);
            replaceMap.put(token,handle);
        }
        removeList.forEach(tokenList::remove);
        replaceMap.forEach((token, tokens) -> {
            int pointer = tokenList.indexOf(token);
            tokenList.remove(token);
            tokenList.addAll(pointer,tokens);
        });
        //输出
        FileOut.outFile(tokenList,new File(FileMetaData.outPutFile.getAbsolutePath()+ toFile.getAbsolutePath().replace(FileMetaData.rootFile.getAbsolutePath(),"")));
    }
}
