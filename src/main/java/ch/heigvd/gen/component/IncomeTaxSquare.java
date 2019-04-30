package ch.heigvd.gen.component;

public class IncomeTaxSquare extends Square {
    public IncomeTaxSquare(String name, int number) {
        super(name, number);
    }

    @Override
    public void landedOn(Player player) {
        try {
            player.reduceCash(Math.min(200, player.getNetWorth() / 10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
