package live.midreamsheep.jssc.pojo.taken;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Taken {
    TakenType Taken_type;
    String value;
    int type;
}
