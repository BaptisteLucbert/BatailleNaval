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
    //Constuire un bateaux
    public void make() {
        // Sélectioner Une coordoné random depuis le registre dans l'interface
        Character Ligne = RegisterLigne[new Random().nextInt(RegisterLigne.length)] ; //C
        Integer Colonne = RegisterColonne[new Random().nextInt(RegisterColonne.length)] ; //5
        // Sélectioner si il est un axe X ou pas
        Boolean isAxeX = new Random().nextBoolean() ;
        // retour de la data direct
        HashMap<Integer,Boolean> Origin = grill.get(Ligne) ;
        // Sélection d'une taille de bateaux depuis l'interface
        int size = TaillePossible[new Random().nextInt(TaillePossible.length)] ;
        
        switch(size) {
            // Bateau de 2, 3, 4, 5 cases
            case 2: case 3: case 4: case 5:
                // On controle l'Axe X
                if (isAxeX) {
                    for (int i = 0; i < size; i++) {
                        // Vérifier si la case existe ou pas
                        if (Origin.get(Colonne + i) == null) {
                            // Check si la case est vide et touche pas un autre bateau
                            if (!Origin.get(Colonne + i).booleanValue()) {
                                Origin.put(Colonne + i,true) ;
                            }
                        }
                    }
                }
                // On controle l'Axe Y
                if (!isAxeX) {
                    for (int i = 0; i < size; i++) {
                        // Vérifier si la case existe ou pas
                        if (Origin.get(Ligne + i) == null) {
                            // Check si la case est vide et touche pas un autre bateau
                            if (!Origin.get(Ligne + i).booleanValue()) {
                                Origin.put(Ligne + i,true) ;
                            }
                        }                       
                    }
                }
            break;
        }






        // Etape 1 = selectioner un point d'origin 
        /*
        un Character
        un Integer
        */
        //Etape 2 = SELECTION axe X OU Y
        // Etpae 3 = SELECTION une taille de bateaux
        // Etape 4 = calculer les possibilités ( algo selon les tailles)
        /*
        #NOTE : si la case est deja occuper, annuler le cas
        */
        // Etape 5 = APPLIQUER UN CAS RANDOM dans le hashmap
        // Etape 6 = VERIFIER
    }
}