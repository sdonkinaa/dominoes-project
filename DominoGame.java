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

                if(!canPlay){
                    if(dominoObj.getDominoes().isEmpty()){
                        CTable.print(curPlayer, domtrain);
                        System.out.println(String.format("Head: %s | Tail: %s", head, tail));
                        System.out.println("No more dominoes to draw from. ");
                        switchPlayer = true;
                        canPlay = true;
                    } else{
                        // CTable.print(curPlayer, domtrain);
                        // System.out.println(String.format("Head: %s | Tail: %s", head, tail));
                        if(isFirstMove) {
                            canPlay= true;
                        } 
                        else{

                            System.out.println("You do not have a playable domino, Select a domino from below to draw");
                            
                            for(DominoeChip cp: dominoObj.getDominoes()){
                                System.out.println(String.format("%s: [?,?]", dominoObj.getDominoes().indexOf(cp)));
                            }

                            boolean isPlayValid = false;
                            Integer inputVal = null;

                            System.out.println("Which domino would you like to draw");

                            while(!isPlayValid){
                                try{
                                inputVal = myObj.nextInt();
                                if (inputVal >= 0 && inputVal < dominoObj.getDominoes().size()){
                                    isPlayValid = true;
                                } else {
                                    System.out.println("InputVal is "+inputVal+" dom: "+dominoObj.getDominoes().size());
                                    System.out.println("Invalid option chosen. Please choose a number from the above displayed choices.");
                                }
                                } catch (InputMismatchException m) {
                                    System.out.println("Invalid number provided as input please re-enter");
                                }
                                myObj.nextLine();
                            }

                            DominoeChip chosenChip = dominoObj.getDominoes().get(inputVal);
                            System.out.println(String.format("Chosen Domino: [%s, %s]", chosenChip.getLeftChip(), chosenChip.getRightChip()));

                            curPlayer.getChips().add(chosenChip);
                            dominoObj.getDominoes().remove(chosenChip);
                        }
                        
                    }
                }
            }

                if(canPlay && !switchPlayer){
                    boolean isValidChoice = false;

                    while (!isValidChoice)
                    {

                        try{
                            Thread.sleep(1000);
                            } catch (InterruptedException m){
                                System.out.println(m);
                            }   
                        System.out.println(String.format("---Player %s Chance Now---", curPlayer.getId()));

                        CTable.print(curPlayer, domtrain);
                        // System.out.println(String.format("Head: %s | Tail: %s", head, tail));
                        boolean isValidPlay = false;
                        Integer playInp = null;

                        while(!isValidPlay){
                        System.out.println("Choose a domino to play from your dominoes");
                        try{
                        playInp = myObj.nextInt();
                        if(playInp >= 0 && playInp < curPlayer.getChips().size()){
                            isValidPlay = true;
                        } else {
                            System.out.println("Choose a valid option from above");
                        }
                        } catch(InputMismatchException m){
                            System.out.println("Please provide a valid number as input");
                        } 
                        myObj.nextLine();
                        }  
                        DominoeChip chosenChip2 = curPlayer.getChips().get(playInp);
                        System.out.println(String.format("Chosen Domino: [%s, %s]", chosenChip2.getLeftChip(), chosenChip2.getRightChip()));

                        if( (chosenChip2.getLeftChip() == tail && chosenChip2.getLeftChip() == head)
                         || (chosenChip2.getRightChip() == tail && chosenChip2.getRightChip() == head)
                         || (chosenChip2.getLeftChip() == head && chosenChip2.getRightChip() == tail)
                         || (chosenChip2.getLeftChip() == tail && chosenChip2.getRightChip() == head)
                         ){
                            boolean validEnd = false;
                            Integer endSelected = null;
                            while (!validEnd){
                                System.out.println("This domino can be played on either end of the train. Choose Head or Tail");
                                System.out.println("1: Head");
                                System.out.println("2: Tail");
                                try{
                                endSelected = myObj.nextInt();
                                if(endSelected == 1 || endSelected == 2 ){
                                    validEnd = true;
                                } else {
                                    System.out.println("Invalid option has been chosen");
                                }
                                } catch (InputMismatchException m){
                                    System.out.println("Choose a valid number 1  or 2");
                                }
                                myObj.nextLine();
                            }
                            if(endSelected == 1){
                                if (chosenChip2.getLeftChip() == head){
                                    domtrain.add(0,new DominoeChip(chosenChip2.getRightChip(), chosenChip2.getLeftChip()));
                                    head = chosenChip2.getRightChip();
                                    isValidChoice=true;
                                    curPlayer.getChips().remove(chosenChip2);
                                } else{
                                    domtrain.add(0,new DominoeChip(chosenChip2.getLeftChip(), chosenChip2.getRightChip()));
                                    head = chosenChip2.getLeftChip();
                                    isValidChoice=true;
                                    curPlayer.getChips().remove(chosenChip2);
                                }
                            } else {
                                if(chosenChip2.getLeftChip() == tail){
                                    domtrain.add(new DominoeChip(chosenChip2.getLeftChip(), chosenChip2.getRightChip()));
                                    tail = chosenChip2.getRightChip();
                                    isValidChoice=true;
                                    curPlayer.getChips().remove(chosenChip2);

                                } else {
                                    domtrain.add(new DominoeChip(chosenChip2.getRightChip(), chosenChip2.getLeftChip()));
                                    tail = chosenChip2.getLeftChip();
                                    isValidChoice=true;
                                    curPlayer.getChips().remove(chosenChip2);

                                }
                            }

                        } else if (isFirstMove){
                            domtrain.add(chosenChip2);
                            head = chosenChip2.getLeftChip();
                            tail = chosenChip2.getRightChip();
                            curPlayer.getChips().remove(chosenChip2);

                            isFirstMove = false;
                            if(curPlayer == player1){
                                curPlayer = player2;
                            } else {
                                curPlayer = player1;
                            }
                        } else if (chosenChip2.getLeftChip() == head){
                            System.out.println("Condition 1 invoked");
                            domtrain.add(0, new DominoeChip(chosenChip2.getRightChip(), chosenChip2.getLeftChip()));
                            head = chosenChip2.getRightChip();
                            isValidChoice = true;
                            curPlayer.getChips().remove(chosenChip2);
                        } else if (chosenChip2.getRightChip() == head){
                            System.out.println("Condition 2 invoked");
                            domtrain.add(0, chosenChip2);
                            head = chosenChip2.getLeftChip();
                            isValidChoice = true;
                            curPlayer.getChips().remove(chosenChip2);
                        } else if (chosenChip2.getLeftChip() == tail){
                            System.out.println("Condition 3 invoked");
                            domtrain.add(chosenChip2);
                            tail = chosenChip2.getRightChip();
                            isValidChoice = true;
                            curPlayer.getChips().remove(chosenChip2);
                        } else if (chosenChip2.getRightChip() == tail){
                            System.out.println("Condition 4 invoked");
                            domtrain.add( new DominoeChip(chosenChip2.getRightChip(), chosenChip2.getLeftChip()));
                            tail = chosenChip2.getLeftChip();
                            isValidChoice = true;
                            curPlayer.getChips().remove(chosenChip2);
                        } else {
                            System.out.println("Invalid domino chose, please rechoose the domino.");
                        }
                        
                     }    
                }

                if(curPlayer.getChips().size() == 0){
                    System.out.println(String.format("Player %s has won.", curPlayer.getId()));
                    if(curPlayer == player1) {
                        System.out.println("Remaining dominoes for player 2 are: ");
                        player2.getChips().forEach(x -> {
                            System.out.println(String.format("[%s ,%s]", x.getLeftChip(), x.getRightChip()));
                        });
                    } else {
                        System.out.println("Remaining dominoes for player 1 are: ");
                        player1.getChips().forEach(x -> {
                            System.out.println(String.format("[%s ,%s]", x.getLeftChip(), x.getRightChip()));
                        });
                    }
                    winnerDeclared = true;
                } else if (isGameDraw) { System.out.println("Game is draw"); winnerDeclared = true;} {
                    if (curPlayer == player1){
                        curPlayer = player2;
                    } else{
                        curPlayer = player1;
                    }
                }
                
            
        }

    


    }
}
