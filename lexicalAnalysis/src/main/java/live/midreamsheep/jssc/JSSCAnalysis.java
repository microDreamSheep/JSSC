package live.midreamsheep.jssc;

import live.midreamsheep.jssc.io.SIO;
import live.midreamsheep.jssc.pojo.taken.Taken;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class JSSCAnalysis {

    public static List<Taken> analyzeAJavaFile(File file) {
        List<Taken> takenList = new LinkedList<>();
        String content = SIO.readAFile(file);
        System.out.println(removeComments(content));
        return takenList;
    }
    private static String removeComments(String content) {
        content= content.replaceAll("//.+?n", "");
        return content;
    }
}
