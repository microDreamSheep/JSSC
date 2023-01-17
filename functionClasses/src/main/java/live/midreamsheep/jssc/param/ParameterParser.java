package live.midreamsheep.jssc.param;

import live.midreamsheep.jssc.pojo.param.JssValue;
import live.midreamsheep.jssc.pojo.param.JssValueEnum;

import java.util.LinkedList;
import java.util.List;

public class ParameterParser {
    public static JssValue[] StandardParser(String arg) {
        char[] chars = arg.toCharArray();
        List<JssValue> jssValues = new LinkedList<>();
        int pointer = 0;
        while (pointer<chars.length){
            if(chars[pointer]==' '||chars[pointer]=='\t'||chars[pointer]=='\r'||chars[pointer]=='\n'){
                pointer++;
                continue;
            }
            if(chars[pointer]=='('&&chars[pointer+1]=='{'){
                pointer++;
                StringBuilder stringBuilder = new StringBuilder();
                while (pointer<chars.length&&chars[pointer]!='}'&&chars[pointer]!=')'){
                    stringBuilder.append(chars[pointer]);
                    pointer++;
                }
                jssValues.add(new JssValue(JssValueEnum.CODE,stringBuilder.substring(1)));
                while (pointer<chars.length&&chars[pointer]!=','&&chars[pointer]!=')'){
                    pointer++;
                }
                pointer++;
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (pointer<chars.length&&chars[pointer]!=','){
                stringBuilder.append(chars[pointer]);
                pointer++;
            }
            jssValues.add(new JssValue(JssValueEnum.STANDARD,stringBuilder.toString()));
            pointer++;
        }
        return jssValues.toArray(new JssValue[0]);
    }
}
