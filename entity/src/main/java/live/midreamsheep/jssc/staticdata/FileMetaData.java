package live.midreamsheep.jssc.staticdata;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
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

    public static List<String> jsscPaths = new LinkedList<>();
    public static List<String> jarPaths = new LinkedList<>();

    static{
        jarPaths.add(System.getProperty("user.dir") + File.separator+"jars");
        jsscPaths.add(System.getProperty("user.dir") + File.separator+"jssc");
    }

    public static void setRootFile(File rootFile) {
        FileMetaData.rootFile = rootFile;
        if(outPutFile!=null){
            return;
        }
        setOutPutFile(new File(rootFile.getAbsolutePath()+File.separator+".."+File.separator+"out"));
    }
    public static File getOutPutFile() {
        if(!outPutFile.getParentFile().exists()){
            outPutFile.getParentFile().mkdirs();
        }
        return outPutFile;
    }
    public static void setOutPutFile(File outPutFile) {
        FileMetaData.outPutFile = outPutFile;
    }

}
