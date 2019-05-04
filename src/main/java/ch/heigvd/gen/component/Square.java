package ch.heigvd.gen.component;

public abstract class Square {
    private String name;
    private int number;

    public Square(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    /**
     * Make a Player land on the Square. Effects depend on which type of Square the Player is on.
     *
     * @param player the Player landing on the Square
     */
    public abstract void landedOn(Player player);
}
