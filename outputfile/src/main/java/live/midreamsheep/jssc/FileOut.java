package live.midreamsheep.jssc;

import live.midreamsheep.jssc.io.SIO;
import live.midreamsheep.jssc.pojo.token.Token;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileOut {
    public static void outFile(List<Token> tokens, File outFile) {
        if(!outFile.getParentFile().exists()){
            boolean mkdirs = outFile.getParentFile().mkdirs();
            if(!mkdirs){
                throw new RuntimeException("mkdirs error"+outFile.getParentFile().getAbsolutePath());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Token token : tokens) {
            stringBuilder.append(token.getValue());
        }
        try {
            SIO.FileOut(stringBuilder.toString(),outFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
