package ludo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SquareTest {

    @Test
    public void whenASquareIsCreatedItDoesNotHoldAPawn() {
        Square square = new Square();
        boolean status = square.IsOccupied();
        assertFalse(status);
    }

    @Test
    public void whenASquareIsCreatedItHoldAPawn() {
        Square square = new Square();
        square.setHasPawn();
        boolean status = square.IsOccupied();
        assertTrue(status);
    }
}
