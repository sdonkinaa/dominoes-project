import java.util.List;

public class CPlayer {
    private int id;
    private List<DominoeChip> chips;

    public CPlayer(){

    }
    
    public CPlayer(int id, List<DominoeChip> chips) {
        this.id = id;
        this.chips = chips;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<DominoeChip> getChips() {
        return chips;
    }
    public void setChips(List<DominoeChip> chips) {
        this.chips = chips;
    }
    @Override
    public String toString() {
        return "CPlayer [id=" + id + ", chips=" + chips + "]";
    }
}
