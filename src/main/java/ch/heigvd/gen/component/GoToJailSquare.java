package ch.heigvd.gen.component;

public class GoToJailSquare extends Square {
    private JailSquare jailSquare = new JailSquare("Jail", 0);

    public GoToJailSquare(String name, int number) {
        super(name, number);
    }

    @Override
    public void landedOn(Player player) {
        player.setLocation(jailSquare);
    }
}
