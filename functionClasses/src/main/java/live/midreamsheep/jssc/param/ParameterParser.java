package live.midreamsheep.jssc.param;

import live.midreamsheep.jssc.constant.ConstantChar;
import live.midreamsheep.jssc.constant.ConstantMapper;
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
            //去除空格
            if(ConstantMapper.BLANK.contains(chars[pointer])){
                pointer++;
                continue;
            }
            //判断是否为代码段
            if(chars[pointer]== ConstantChar.CODE_START_ONE &&chars[pointer+1]== ConstantChar.CODE_START_TWO){
                pointer = parseCode(chars,pointer,jssValues);
            }else {
                pointer = parseSimpleValue(chars,pointer,jssValues);
            }
        }
        return jssValues.toArray(new JssValue[0]);
    }
    private static int parseCode(char[] chars,int pointer,List<JssValue> jssValues){
        StringBuilder stringBuilder = new StringBuilder();
        pointer++;//增1 到达代码段第一个字符
        while (pointer<chars.length&&!(chars[pointer]==ConstantChar.CODE_END_ONE&&chars[pointer+1]==ConstantChar.CODE_END_TWO)){
            stringBuilder.append(chars[pointer]);
            pointer++;
        }
        jssValues.add(new JssValue(JssValueEnum.CODE,stringBuilder.substring(1)));
        while (pointer<chars.length&&!(chars[pointer]==','||chars[pointer]==')')){//循环到下一个参数起点
            pointer++;
        }
        pointer+=2;
        return pointer;
    }
    private static int parseSimpleValue(char[] chars,int pointer,List<JssValue> jssValues){
        StringBuilder stringBuilder = new StringBuilder();
        while (pointer < chars.length && chars[pointer] != ',') {
            stringBuilder.append(chars[pointer]);
            pointer++;
        }
        jssValues.add(new JssValue(JssValueEnum.STANDARD, stringBuilder.toString()));
        return ++pointer;
    }
}
