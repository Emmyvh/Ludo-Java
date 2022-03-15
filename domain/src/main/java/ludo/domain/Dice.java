package ludo.domain;

import java.util.Random;

public class Dice {

    private int diceThrow;
    private final int upperbound = 6;

    private Random random = new Random();

    public int getDiceThrow() {
        return diceThrow;
    }

    public void setDiceThrow() {
        diceThrow = random.nextInt(upperbound);
    }

}
