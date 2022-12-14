package live.midreamsheep.jssc;

import java.io.File;

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
        File file = new File(args[0]);
        if (!(file.exists() && file.isDirectory())) {
            System.err.println("File not found or not a directory because of input file path:" + args[0]);
        }
        System.out.println(args[0]+"开始处理");
        new LexerAnalyzer().analyze(file);
        System.out.println("所有文件都已经处理完成");
    }
}
