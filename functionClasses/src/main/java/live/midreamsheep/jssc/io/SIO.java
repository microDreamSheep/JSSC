package live.midreamsheep.jssc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SIO {
    public static String readAFile(File path) {
        try (FileInputStream inputStream = new FileInputStream(path)) {
            StringBuilder sb = new StringBuilder();
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = inputStream.read(buffer)) != -1) {
                sb.append(new String(buffer,0,len));
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
