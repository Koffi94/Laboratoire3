package ch.heigvd.gen.component;

import java.util.Random;

public class Die {

    private int faceValue;
    private Random rand = new Random();

    public Die(int faceValue) {
        this.faceValue = faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    /**
     * Compute a random number and assign it to the face value.
     */
    public void roll() {
        faceValue = rand.nextInt(6) + 1;
    }
}
