package live.midreamsheep.jssc.loader.loaders.jssc;

import live.midreamsheep.jssc.JSSCAnalysis;
import live.midreamsheep.jssc.io.SIO;
import live.midreamsheep.jssc.load.JssGrammar;
import live.midreamsheep.jssc.loader.LoaderInter;
import live.midreamsheep.jssc.pojo.token.Token;

import java.io.File;

public class HandlerLoader implements LoaderInter {
    @Override
    public boolean load(String[] dirs) {
        for (String dir : dirs) {
            loadDir(dir);
        }
        return true;
    }

    private void loadDir(String dir) {
        File file = new File(dir);
        //遍历
        if (!(file.exists() && file.isDirectory())) {
            return;
        }
        File[] files = file.listFiles();
        for (File second : files != null ? files : new File[0]) {
            if (!second.isDirectory()) {
                if (second.getName().endsWith(".jss")) {
                    JssGrammar.parse(JSSCAnalysis.analyzeAFile(second).toArray(new Token[0]));
                }else if (second.getName().endsWith(".jssc")) {
                    String s = SIO.readAFile(second);
                    String namespace = s.substring(0, s.indexOf("\n"));
                    for (String s1 : s.split("\n")) {
                        String[] split = s1.split("=");
                        String name = split[0];
                        String path = split[1];
                        //加载类
                        loadClass(namespace, name, path);
                    }
                }
                continue;
            }
            loadDir(second.getAbsolutePath());
        }
    }

    private void loadClass(String namespace, String name, String path) {

    }
}