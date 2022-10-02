package live.midreamsheep.jssc;

import live.midreamsheep.jssc.staticdata.FileMetaData;

import java.io.File;
import java.util.Objects;

public class LexerAnalyzer {

    public void analyze(File dictionary) {
        //扫描根目录
        FileMetaData.rootFile = dictionary;
        //输出目录
        FileMetaData.outPutFile = new File(dictionary.getAbsolutePath()+File.separator+"../" + File.separator + "outPut");
        //递归调用分析器寻找.java文件
        findJavaFile(dictionary);
    }
    public void findJavaFile(File file) {
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                findJavaFile(f);
            }
            return;
        }
        if (!file.getName().endsWith(".java")) {
            return;
        }

    }
}
