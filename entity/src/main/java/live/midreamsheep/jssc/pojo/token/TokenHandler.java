package live.midreamsheep.jssc.pojo.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author midreamsheep
 * 词法分析中间值
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class TokenHandler {
    //用于分析的token组
    private final List<Token> tokens = new LinkedList<>();
    //文件输出路径
    private File filePath;

}
