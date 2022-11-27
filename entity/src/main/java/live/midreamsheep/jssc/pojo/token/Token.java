package live.midreamsheep.jssc.pojo.token;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Token {
    TokenType tokenType;
    String value;
    int type;
}
