import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testReg {
    public static void main(String[] args) {
        String a ="public class test {\n" +
                "    /**\n" +
                "     * wadasdasd\n" +
                "     * asdasd\n" +
                "     **/\n" +
                "    public static void main(String[] args){\n" +
                "        System.out.print(\"test\");\n" +
                "        /*sa\n" +
                "        * awdwa\n" +
                "        * asdasd*/\n" +
                "        System.out.println();\n" +
                "        if ( 5==5){\n" +
                "            return;//的撒大苏打\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n";
        String str = a;
        String pattern = "/\\*(.|\\n)+?\\*/";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        while (m.find()){
            str = str.replace(m.group(),"");
        }
        System.out.println(str);
    }
}
