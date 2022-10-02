package live.midreamsheep.jssc.pojo.taken;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public final class TakenHandler {
    private final List<Taken> taken = new LinkedList<>();
    private File filePath;

    public void addTaken(Taken taken) {
        this.taken.add(taken);
    }

    public List<Taken> getTaken() {
        return taken;
    }

    public Taken getTaken(int index) {
        return taken.get(index);
    }

    public File getFilePath() {
        return filePath;
    }

    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }
}
