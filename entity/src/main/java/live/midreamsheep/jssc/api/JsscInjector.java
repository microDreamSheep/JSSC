package live.midreamsheep.jssc.api;

import java.util.Map;

public interface JsscInjector {
    /**
     * 获取命名空间名
     * @return 命名空间名
     * */
    String getNamespace();
    /**
     * 获取宏处理对象
     * @return 宏处理对象map
     *          key:宏名
     *          value:宏处理对象
     * */
    Map<String,Class<?>> getHandlerMap();
}
