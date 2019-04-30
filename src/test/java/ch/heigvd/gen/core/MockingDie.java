package ch.heigvd.gen.core;

import ch.heigvd.gen.component.Die;

public class MockingDie extends Die {

    public MockingDie(int faceValue) {
        super(faceValue);
    }

    @Override
    public void roll() {
        this.setFaceValue(3);
    }
}
