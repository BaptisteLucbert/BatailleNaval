package finnwinch.quicknavalgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Components implements Rules {
    private HashMap<Character,HashMap<Integer,Byte>> Grill ;
    public Components(){
        this.Grill = new HashMap<>() ;
        GenerateDefaultGrill() ;
    }
    private void GenerateDefaultGrill(){
        for (Character ligne : Ligne) {
            Grill.put(ligne, new HashMap<>());
            for (int colonne = 0 ; colonne < Colonne ; colonne++){
                Grill.get(ligne).put(colonne,(byte)0x00) ;
            }
        }
    }
    public Byte GetCoordonateValue(Character ligne,Integer colonne) {
        return (byte) Grill.get(ligne).get(colonne) ;
    }
    public void SetCoordonateWithValue(Character ligne,Integer colonne, Byte val) throws Exception {
        if(!Grill.containsKey(ligne)) { throw new Exception("attempt to insert val into invalid ligne") ; }
        if(!Grill.get(ligne).containsKey(colonne)) { throw new Exception("attempt to insert val into invalid colonne") ; }
        Grill.get(ligne).put(colonne,(byte)val) ;
    }
    public void HelpByteIndication(){
        System.out.println("0x00 = Vide");
        System.out.println("0x01 = Bateau");
        System.out.println("0x02 = Touché sans bateau");
        System.out.println("0x03 = Touché avec bateau");
        // bonus
        System.out.println("0x04 = Touché bateau complet");
    }
    public void InsertBateau(int size) throws Exception{
        if (size <= 0) { throw new Exception("Invalide size") ; }
        HashMap<Character,Integer> calc = new HashMap<>() ;
        ArrayList<HashMap<Character,Integer>> registre = new ArrayList<>() ;
        Character ligne = Ligne[new Random().nextInt(0,Ligne.length - 1)] ;
        Integer colonne = new Random().nextInt(0,Colonne) ;
        System.out.println(Integer.toString(colonne) + Character.toString(ligne));
        if (new Random().nextBoolean()) { //axe x
            switch(size) {
                // regle absolut ici
                case 2, 3, 4, 5 -> {
                    // faire les calcul ici et finir avec les intructions si-bas
                    
                    // ajouter le calcul au registre possible
                    registre.add(calc ) ;
                    // reinitialiser le calcul
                    calc = new HashMap<>() ;
                }
                default -> {
                    throw new Exception("No valid size") ;
                }
            }
            // recupere random
            calc = registre.get(new Random().nextInt(0, registre.size())) ;
        } else { // axe y
            
        }
    }
    public void play(Character ligne,Integer colonne) throws Exception {
        switch(Grill.get(ligne).get(colonne - 1)) {
            case 0x00 -> {
                Grill.get(ligne).put(colonne - 1, (byte)0x02) ;
            }
            case 0x01 -> {
                Grill.get(ligne).put(colonne - 1, (byte)0x03) ;
            }
            default -> {
                throw new Exception("Case déja toucher") ;
            }
        }
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
                Byte status = Grill.get(ligne).get(colonne) ;
                switch (status) {
                    // ADAPTER LES MESSAGES AVEC LA NOUVELLE SOLUTION
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
}
