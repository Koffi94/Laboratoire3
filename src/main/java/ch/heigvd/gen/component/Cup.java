package ch.heigvd.gen.component;

public class Cup {
    private Die[] cup;

    public Cup(int numberOfDies) {
        cup = new Die[numberOfDies];
        intitializeDies(numberOfDies);
    }

    /**
     * Roll all Die inside the Cup.
     */
    public void roll() {
        for (Die d : cup) {
            d.roll();
        }
    }

    /**
     * Compute the sum of the face value of each Die in the Cup.
     *
     * @return
     */
    public int getTotal() {
        int total = 0;
        for (Die d : cup) {
            total += d.getFaceValue();
        }
        return total;
    }

    /**
     * Initialize Die at a fixed starting face value.
     *
     * @param numberOfDies
     */
    private void intitializeDies(int numberOfDies) {
        for (int i = 0; i < numberOfDies; i++) {
            cup[i] = new Die(0);
        }
    }
}
