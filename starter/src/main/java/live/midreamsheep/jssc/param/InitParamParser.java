package live.midreamsheep.jssc.param;

import java.util.function.Consumer;

public class InitParamParser {
    public static void Parser(String[] args){
        for (String arg : args) {
            String[] key_value = arg.split("=");
            Consumer<String> stringConsumer = ParamMapper.get(key_value[0]);
            if (stringConsumer != null) {
                stringConsumer.accept(key_value[1]);
                continue;
            }
            throw new RuntimeException("not found " + key_value[0] + ",please check your param");
        }
    }
}
