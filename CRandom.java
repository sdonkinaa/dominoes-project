import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CRandom {

    //as sorting approach for the sequence that the domino pieces will be shown/picked
    public CRandom() {
    }
    
    public static List<DominoeChip> randomizedDraw(List<DominoeChip> dominoList, int drawCount){
        List<DominoeChip> returnList = new ArrayList<>();
        Random rand = new Random();
        int counter = 0;
        while(counter < drawCount){
            DominoeChip randomElement = dominoList.get(rand.nextInt(dominoList.size()));
            returnList.add(randomElement);
            dominoList.remove(randomElement);
            counter++;
        }
        return returnList;
    }   
}
