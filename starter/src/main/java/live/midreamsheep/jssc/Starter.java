package live.midreamsheep.jssc;

import java.io.File;

public class Starter {
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
