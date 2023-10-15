import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class test implements Rules{
    // Quand le bateau fait 4 et est sur l'axe Y
    public void Cas4Y(){
        HashMap<Character, HashMap<Integer,Boolean>> grille = new HashMap<>();
        HashMap<Integer,Boolean> Data = new HashMap<>();
        int bateau = 4 ;
        char axe = 'Y' ;
        Data.put(1,true) ;
        Data.put(2,true) ;
        Data.put(3,true) ;
        Data.put(4,true) ;
        Data.put(5,true) ;
        Data.put(6,false) ; // ORIGIN A6
        Data.put(7,false) ;
        Data.put(8,false) ;
        Data.put(9,false) ;
        Data.put(10,false) ;
        grille.put('A',Data) ;
        System.out.println(grille) ;
        
        // parcours toutes les possibilités de placement et annule les cas impossible
        for (Map.Entry<Character, HashMap<Integer,Boolean>> entry : grille.entrySet()) {
            Character key = entry.getKey();
            HashMap<Integer,Boolean> value = entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("Value = " + value);
            for (Map.Entry<Integer,Boolean> entry2 : value.entrySet()) {
                Integer key2 = entry2.getKey();
                Boolean value2 = entry2.getValue();
                System.out.println("Key = " + key2);
                System.out.println("Value = " + value2);
                if (value2 == true) {
                    System.out.println("Case occupé");
                }
                else {
                    System.out.println("Case libre");
                }
            }
        }
    }

    public static void main(String[] args) {
        test test = new test() ;
        test.Cas4Y() ;
    }
}


/*
        HashMap<Character, HashMap<Integer,Boolean>> grille = new HashMap<>();
        HashMap<Integer,Boolean> Data = new HashMap<>();
        Data.put(1,true) ;
        grille.put('A',Data) ;

        A,1 = true
*/