package ch.heigvd.gen.component;

public class GoToJailSquare extends Square {
    private JailSquare jailSquare;

    public GoToJailSquare(String name, int number, JailSquare jailSquare) {
        super(name, number);
        this.jailSquare = jailSquare;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println(" Go To Jail Square");
        player.setLocation(jailSquare);
    }
}
