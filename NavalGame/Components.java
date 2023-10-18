package NavalGame;

import java.util.HashMap;
import java.util.Map;

public class Components implements Configuration {
    private final HashMap<Integer,Integer> Bateaux = new HashMap<>();
    private final HashMap<Character, HashMap<Integer,Byte>> Grille = new HashMap<>() ;
    private int CaseVide = Ligne.length * Colonne ;
    public Components(){}
    public void initialization() {
        for (Character linge : Ligne) {
            Grille.put(linge,new HashMap<>()) ;
            for (Integer colonne = 0 ; colonne < Colonne ; colonne++) {
                Grille.get(linge).put(colonne, (byte) 0x00) ;
            }
        }
    }
    public void addBateaux(int size, int counter) throws Exception {
        if (size <= 10) {
            if (CaseVide - size * counter < 0) {
                throw new Exception("Pas assez de place dans la grille") ;
            } else {
                Bateaux.put(size,counter) ;
                CaseVide -= size * counter ;
            }
        } else {
            throw new IllegalStateException("Unexpected value: " + size);
        }
    }
    public void templateBateaux() {
        //generate algo for input ( input have to be into other hashmap with byte 4/5 (for player)
    }
    @Override
    public String toString(){
        String output = "" ;
        for (int i = 0 ; i <= Colonne ; i++) {
            output += Integer.toString(i) + " " ;
        }
        output +="  \n";
        for (Character ligne : Ligne) {
            output += ligne + " " ;
            for (int colonne = 0 ; colonne < Colonne ; colonne++) {
                String Message = "null";
                char Abrevation = '#' ;
                Byte status = Grille.get(ligne).get(colonne) ;
                switch (status) {
                    case 0x00 : Message = "Vide" ; Abrevation = '@' ; break ;
                    case 0x01 : Message = "Selectionner"; Abrevation = 'X' ; break ;
                    case 0x02 : Message = "Toucher" ; Abrevation = 'O' ; break ;
                    case 0x03 : Message = "Couler" ; Abrevation = 'C' ; break ;
                }
                if (colonne <= 9) {
                    output += Abrevation + " " ;
                } else if(colonne >= 10 && colonne <= 99) {
                    output += " " + Abrevation + " " ;
                } else if(colonne >= 100 && colonne <= 999) {
                    output += "  " + Abrevation + " " ;
                }
            }
            output += "\n" ;
        }
        return output ;
    }
    public String toString(boolean configShow){
        String output ;
        output = "[[===== Menu de configuration =====]]\n" ;
        output = output + "Ligne : " ;
        for (Character linge : Ligne) {
            output = output + linge ;
        }
        output = output + " (" + Ligne.length + ")\n" ;
        output = output + "Colonne : " ;
        for (Integer colonne = 0 ; colonne < Colonne ; colonne++) {
            output = output + colonne ;
        }
        output = output + " (" + Colonne + ")\n" ;
        output = output + "Case utilisé : " + Integer.toString(Ligne.length * Colonne - CaseVide) + "/" + Integer.toString(Ligne.length * Colonne) + "\n" ;
        for (Map.Entry<Integer,Integer> data : Bateaux.entrySet()) {
            Integer size = data.getKey() ;
            Integer counter = data.getValue() ;
            output = output + "Bateaux : " + size + ", présent " + counter + " fois\n";
        }
        output += "Tableau\n" ;
        output += toString() ;
        return output ;
    }
}
