import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner; // import the Scanner class 
import java.lang.Thread;



public class DominoGame {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
        //Initializing Dominoes
        ArrayList<DominoeChip> dominoList = new ArrayList<DominoeChip>(){
            {
                add(new DominoeChip(0, 0));
                add(new DominoeChip(1, 1));
                add(new DominoeChip(1, 0));
                add(new DominoeChip(2, 0));
                add(new DominoeChip(2, 1));
                add(new DominoeChip(2, 2));
                add(new DominoeChip(3, 0));
                add(new DominoeChip(3, 1));
                add(new DominoeChip(3, 2));
                add(new DominoeChip(3, 3));
                add(new DominoeChip(4, 0));
                add(new DominoeChip(4, 1));
                add(new DominoeChip(4, 2));
                add(new DominoeChip(4, 3));
                add(new DominoeChip(4, 4));
                add(new DominoeChip(5, 0));
                add(new DominoeChip(5, 1));
                add(new DominoeChip(5, 2));
                add(new DominoeChip(5, 3));
                add(new DominoeChip(5, 4));
                add(new DominoeChip(5, 5));
                add(new DominoeChip(6, 0));
                add(new DominoeChip(6, 1));
                add(new DominoeChip(6, 2));
                add(new DominoeChip(6, 3));
                add(new DominoeChip(6, 4));
                add(new DominoeChip(6, 5));
                add(new DominoeChip(6, 6));
            }
        };

        CDominoes dominoObj = new CDominoes(dominoList);
        
        CPlayer curPlayer = null;
        // CRandom.randomizedDraw(dominoObj.getDominoes(), 10).forEach(x -> {System.out.println(x);});
        CPlayer player1 = new CPlayer(1, CRandom.randomizedDraw(dominoObj.getDominoes(), 10));

        CPlayer player2 = new CPlayer(2, CRandom.randomizedDraw(dominoObj.getDominoes(), 10));

        //Initializing the train
        ArrayList<DominoeChip> domtrain = new ArrayList<>();

        // System.out.println(player1.getChips());
        // System.out.println("---------");
        // System.out.println(player2.getChips());
        // System.out.println("---------");
        // System.out.println(dominoObj.getDominoes());

        // CTable.print(player2, domtrain);

        //Start game on console
        System.out.println("Welcome to the 2 player Dominoes Game");
        try{
        Thread.sleep(2000);
        } catch (InterruptedException m){
            System.out.println(m);
        }   

        System.out.println("Randomly selecting a player to go first");
        Random rand = new Random();
        if(rand.nextInt(2) == 1){
            curPlayer = player1;
        } else {
            curPlayer = player2;
        }
        try{
        Thread.sleep(2000);
        } catch (InterruptedException m){
            System.out.println(m);
        }   

        System.out.println(String.format("Player %s will play the first play",curPlayer.getId()));
        try{
        Thread.sleep(2000);
        } catch (InterruptedException m){
            System.out.println(m);
        }   

        boolean winnerDeclared = false;
        boolean isGameDraw = false;
        Integer head = -1;
        Integer tail = -1;

        boolean isFirstMove = true;
        //Game Begins
        while(!winnerDeclared){
            boolean canPlay = false;
            boolean switchPlayer = false;

            while(!canPlay){

                
                if(dominoObj.getDominoes().isEmpty()){
                    //Is any domino from both players playable?
                    ArrayList<DominoeChip> bothPlayerChips = new ArrayList<>();
                    bothPlayerChips.addAll(player1.getChips());
                    bothPlayerChips.addAll(player2.getChips());
                    boolean conditionMet = false;
                    for(DominoeChip dce: bothPlayerChips){
                        if(dce.getLeftChip() == head || dce.getLeftChip() == tail || dce.getRightChip() == head || dce.getRightChip() == tail ){
                            conditionMet = true;
                        }
                        if(!conditionMet) isGameDraw = true; 
                }
            }
                //Check if any of the domino is playable
                for(DominoeChip dc: curPlayer.getChips()){
                    if(dc.getLeftChip() == head || dc.getLeftChip() == tail || dc.getRightChip() == head || dc.getRightChip() == tail ){
                        canPlay = true;
                    }
                }
            }

        
                
            
        }

    


    }
}
