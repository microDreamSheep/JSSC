package live.midreamsheep.jssc.io;

import java.io.*;
import java.nio.file.Files;

/**
 * @author midreamsheep
 * IO流工具类
 * */
public class SIO {
    /**
     * 读取一个文件为字符串
     * @param path 文件路径
     * @return 文件内容
     * */
    public static String readAFile(File path) {
        try (FileInputStream inputStream = new FileInputStream(path)) {
            StringBuilder sb = new StringBuilder();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = inputStream.read(buffer)) != -1) {
                sb.append(new String(buffer,0,len));
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void FileOut(String content, File outFile) throws IOException {
        System.out.println("输出到"+outFile.getAbsolutePath());
        System.out.println(content.length());
        OutputStream os = Files.newOutputStream(outFile.toPath());
        os.write(content.getBytes());
        os.flush();
        os.close();
    }
}
