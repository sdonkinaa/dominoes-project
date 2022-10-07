import java.util.HashSet;
import java.util.List;

public class CDominoes {

    private List<DominoeChip> dominoes;

    public CDominoes(List<DominoeChip> dominoes) {
        this.dominoes = dominoes;
    }

    public List<DominoeChip> getDominoes() {
        return dominoes;
    }

    public void setDominoes(List<DominoeChip> dominoes) {
        this.dominoes = dominoes;
    }

    @Override
    public String toString() {
        return "CDominoes [dominoes=" + dominoes + "]";
    }


}
