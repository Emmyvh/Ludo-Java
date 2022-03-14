package ludo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DiceTest {

    @Test
    public void whenADiceIsThrownARandomNumberIsReturned() {
        Dice dice = new Dice();

        dice.setDiceThrow();
        assertTrue(0 < dice.getDiceThrow());
        assertTrue(dice.getDiceThrow() < 7);
    }
}
