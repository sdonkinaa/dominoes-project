import java.util.ArrayList;
import java.util.List;

public class CTable {

    public CTable() {
    }
    
    public static void print(CPlayer player, List<DominoeChip> train){
        
        System.out.println(String.format("Train: %s", ( train == null || train.isEmpty() ? "[]":printArrayList(train))));
        System.out.println(String.format("Player %s Dominoes:", player.getId()));
        player.getChips().forEach(x -> {
            System.out.println(String.format("%s: [%s, %s]", player.getChips().indexOf(x), x.getLeftChip(), x.getRightChip()));
        });
        // System.out.println(String.format("Player: %s", (player.getChips() == null || player.getChips().isEmpty())? "[]":printArrayList(player.getChips())));
    
    }

    private static String printArrayList(List<DominoeChip> chipArray){
        String retStr = "";
        for(DominoeChip chip: chipArray){
            retStr+= String.format("[%s,%s]",chip.getLeftChip(),chip.getRightChip());
        }
        return retStr;
    }


    @Override
    public String toString() {
        return "CTable []";
    }
    
}
