package ch.heigvd.gen.component;

public class Cup {
    private Die[] cup;

    public Cup(int numberOfDies) {
        cup = new Die[numberOfDies];
        intitializeDies(numberOfDies);
    }

    public void roll() {
        for (Die d : cup) {
            d.roll();
        }
    }

    public int getTotal() {
        int total = 0;
        for (Die d : cup) {
            total += d.getFaceValue();
        }
        return total;
    }

    private void intitializeDies(int numberOfDies) {
        for (int i = 0; i < numberOfDies; i++) {
            cup[i] = new Die(0);
        }
    }
}
