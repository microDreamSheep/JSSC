package live.midreamsheep.jssc.staticdata;

import java.io.File;
import java.util.Objects;

/**
 * @author midreamsheep
 * 文件源数据
 * */
public class FileMetaData {
    //扫描目录
    public static File rootFile;
    //输出目录
    public static File outPutFile;

    public static void setOutPutFile(File outPutFile) {
        FileMetaData.outPutFile = outPutFile;
        if(!outPutFile.getParentFile().exists()){
            outPutFile.getParentFile().mkdirs();
            return;
        }
        File[] files = outPutFile.listFiles();
        if(files==null){
            return;
        }
        for (File file : files) {
            delete(file);
        }
    }
    private static void delete(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files==null?new File[0]:files) {
                delete(f);
            }
        }
        if(!file.delete()){
            throw new RuntimeException("删除文件失败");
        }

    }
}
