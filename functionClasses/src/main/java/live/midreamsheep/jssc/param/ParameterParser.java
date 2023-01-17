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
            if(chars[pointer]=='#'){
                pointer++;
                StringBuilder stringBuilder = new StringBuilder();
                while (pointer<chars.length&&chars[pointer]!='#'){
                    stringBuilder.append(chars[pointer]);
                    pointer++;
                }
                jssValues.add(new JssValue(JssValueEnum.CODE,stringBuilder.toString()));
                while (pointer<chars.length&&chars[pointer]!=','){
                    pointer++;
                }
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (pointer<chars.length&&chars[pointer]!=','){
                stringBuilder.append(chars[pointer]);
                pointer++;
            }
            jssValues.add(new JssValue(JssValueEnum.STANDARD,stringBuilder.toString()));
        }
        return jssValues.toArray(new JssValue[0]);
    }
}
