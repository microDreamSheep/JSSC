package live.midreamsheep.jssc.loader;

/**
 * 加载器接口
 * */
public interface LoaderInter {
    /**
     * 加载器
     * @param dirs 文件夹
     * */
    boolean load(String[] dirs);
}