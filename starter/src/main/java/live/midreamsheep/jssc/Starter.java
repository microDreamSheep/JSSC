package live.midreamsheep.jssc;

import live.midreamsheep.jssc.param.InitParamParser;
import live.midreamsheep.jssc.staticdata.FileMetaData;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author midreamsheep
 * 启动器器
 * */
public class Starter {
    /**
     * 启动器
     * @param args 参数
     * */
    public static void main(String[] args) {
        //解析参数
        InitParamParser.Parser(args);
        //加载器
        Map<String, String[]> loaderMap = new HashMap<>();
        loaderMap.put("jars", FileMetaData.jarPaths.toArray(new String[0]));
        loaderMap.put("jssc", FileMetaData.jsscPaths.toArray(new String[0]));
        LoaderStarter.loadStart(loaderMap);
        //执行
        new LexerAnalyzer().analyze();
    }
}
