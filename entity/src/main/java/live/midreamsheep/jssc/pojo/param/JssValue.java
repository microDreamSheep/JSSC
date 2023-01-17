package live.midreamsheep.jssc.pojo.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JssValue {
    private JssValueEnum type;
    private String value;
}
