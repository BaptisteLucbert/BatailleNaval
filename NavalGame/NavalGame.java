package NavalGame;
public class NavalGame {
    public static void main(String[] args) throws Exception {
        Components GAME = new Components() ;
        GAME.addBateaux(2,5);
        GAME.addBateaux(3,4);
        GAME.addBateaux(4,3);
        GAME.addBateaux(5,1);
        GAME.addBateaux(1,1);
        GAME.addBateaux(10,1);
        GAME.initialization();
        GAME.templateBateaux();
        System.out.println(GAME.toString());
    }
}
