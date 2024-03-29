package live.midreamsheep.jssc;

import live.midreamsheep.jssc.parse.GrammarParse;
import live.midreamsheep.jssc.staticdata.FileMetaData;

import java.io.File;
import java.util.Objects;

/**
 * @author midreamsheep
 * 词法根分析器
 * */
public class LexerAnalyzer {
    //当前文件
    private File nowDictionary;
    /**
     * 词法分析
     * */
    public void analyze() {
        //扫描根目录
        nowDictionary = FileMetaData.rootFile;
        //递归调用分析器寻找.java文件
        findJavaFile(nowDictionary);
    }
    /**
     * 寻找.java文件并处理
     * @param file 文件
     * */
    public void findJavaFile(File file) {
        if (file.isDirectory()) {
            nowDictionary = file;
            for (File f : Objects.requireNonNull(file.listFiles())) {
                findJavaFile(f);
            }
            return;
        }
        if (!file.getName().endsWith(".java")) {
            return;
        }
        //找到.java文件后，调用分析器进行分析
        GrammarParse.ParseAndOut(JSSCAnalysis.analyzeAFile(file),file);
    }
}
