package finnwinch.quicknavalgame;

public class QuickNavalGame {

    public static void main(String[] args) throws Exception {
        Components c = new Components() ;
        System.out.println(c.toString());
        c.play('A', 4);
        System.out.println(c.toString());
        c.play('A', 4);
    }
}
