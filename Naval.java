import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Naval implements Rules {
    private HashMap<Character, HashMap<Integer, Boolean>> grill;

    public Naval(){
        this.grill = new HashMap<>();
        buildGrill();
    }

    // Construction de la grille
    public void buildGrill(){
        HashMap<Integer, Boolean> Data = new HashMap<>();

        // création des colonnes
        for (int i = 0; i < 10; i++){
            Data.put(i,false);
        }

        // création des lignes
        Character[] lettre = {'A','B','C','D','E','F','G','H','I','J'};
        for (int i = 0; i < 10; i++){
            grill.put(lettre[i],Data);
        }
    }

    // Vérification de la grille
    public void checkGrill(){
        System.out.println(grill);
    }

    public void checkGrill(boolean printed) {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        Character[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    
        for (Character letter : letters) {
            System.out.print(letter + " ");
            HashMap < Integer, Boolean> row = grill.get(letter);
            for (int i = 0; i < 10; i++) {
                System.out.print((row.get(i) ? "1" : "0") + " ");
            }
            System.out.println();
        }
    }

    public void make() {
        Random random = new Random();
        // Fin V1
    }
}