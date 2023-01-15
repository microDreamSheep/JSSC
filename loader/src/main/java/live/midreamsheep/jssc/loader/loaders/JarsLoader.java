package live.midreamsheep.jssc.loader.loaders;

import live.midreamsheep.jssc.loader.LoaderInter;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Objects;

public class JarsLoader implements LoaderInter {
    @Override
    public boolean load(String[] dirs) {
        for (String dir : dirs) {
            loadDir(dir);
        }
        return false;
    }

    private void loadDir(String dir) {
        File file = new File(dir);
        //遍历
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File second : files != null ? files : new File[0]) {
                if (second.isDirectory()) {
                    loadDir(second.getAbsolutePath());
                } else {
                    if (second.getName().endsWith(".jar")) {
                        System.out.println("加载jar包:" + second.getAbsolutePath());
                        loadJar(second.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void loadJar(String jarPath) {
        File jarFile = new File(jarPath);
        // 从URLClassLoader类中获取类所在文件夹的方法，jar也可以认为是一个文件夹
        Method method = null;
        try {
            method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        } catch (NoSuchMethodException | SecurityException e1) {
            e1.printStackTrace();
        }
        //获取方法的访问权限以便写回
        boolean accessible = Objects.requireNonNull(method).isAccessible();
        try {
            method.setAccessible(true);
            // 获取系统类加载器
            URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            URL url = jarFile.toURI().toURL();
            method.invoke(classLoader, url);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.setAccessible(accessible);
        }
    }
}
