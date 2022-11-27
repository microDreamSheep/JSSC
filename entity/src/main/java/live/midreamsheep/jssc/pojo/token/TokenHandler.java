package live.midreamsheep.jssc.pojo.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class TokenHandler {
    private final List<Token> tokens = new LinkedList<>();
    private File filePath;

    public void addToken(Token taken) {
        this.tokens.add(taken);
    }

    public Token getToken(int index) {
        return tokens.get(index);
    }

}
