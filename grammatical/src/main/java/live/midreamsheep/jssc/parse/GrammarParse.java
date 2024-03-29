package live.midreamsheep.jssc.parse;

import live.midreamsheep.jssc.FileOut;
import live.midreamsheep.jssc.Handler;
import live.midreamsheep.jssc.HandlerInter;
import live.midreamsheep.jssc.constant.ConstantChar;
import live.midreamsheep.jssc.constant.MetaConstant;
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
        Handler.currentMap.clear();
        Map<Token,List<Token>> replaceMap = new HashMap<>();
        List<Token> removeList = new LinkedList<>();
        for (Token token : tokenList) {
            if(!token.getTokenType().equals(TokenTypeEnum.JSSC)){
                continue;
            }
            String total = token.getValue();
            String name = total.substring(0, total.indexOf(ConstantChar.JSSC_START));
            //源宏加载
            HandlerInter inter = Handler.HANDLER_MAP.get(MetaConstant.META_PACKAGE_NAME).get(name);
            String args = total.substring(total.indexOf(ConstantChar.JSSC_START) + 2, total.lastIndexOf(ConstantChar.JSSC_END));
            if(inter!=null){
                inter.handle(args,tokenList,tokenList.indexOf(token));
                removeList.add(token);
                continue;
            }
            //用户宏加载
            inter = Handler.currentMap.get(name);
            if(inter==null){
                throw new RuntimeException("not found "+name);
            }
            replaceMap.put(token,inter.handle(args,tokenList,tokenList.indexOf(token)));
        }
        removeList.forEach(tokenList::remove);
        replaceMap.forEach((token, tokens) -> {
            int pointer = tokenList.indexOf(token);
            tokenList.remove(token);
            tokenList.addAll(pointer,tokens);
        });
        //输出
        FileOut.outFile(tokenList,new File(FileMetaData.getOutPutFile().getAbsolutePath()+ toFile.getAbsolutePath().replace(FileMetaData.rootFile.getAbsolutePath(),"")));
    }
}
