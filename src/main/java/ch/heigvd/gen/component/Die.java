package ch.heigvd.gen.component;
import java.util.Random;

public class Die {

    private int faceValue;
    private Random rand = new Random();


    public int getFaceValue() {
        return faceValue;
    }

    public void roll() {
        faceValue = rand.nextInt(6) + 1;
    }
}
