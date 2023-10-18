package NavalGame;

import java.util.HashMap;
import java.util.Scanner;

public class Player {
    private boolean IsHoster ;
    private HashMap<Character,HashMap<Integer,Byte>> IsSolution ;
    public Player() {

    }
    public void PRE_START_GAME(){
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Voulez vous lancer une partie ? [OUI/NON]");
        while (!sc.nextLine().equals("STOP")) {

        }
    }
}
