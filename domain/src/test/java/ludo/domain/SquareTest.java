package ludo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SquareTest {

    @Test
    public void whenASquareIsCreatedItDoesNotHoldAPawn() {
        Square square = new Square();
        boolean status = square.isOccupied();
        assertFalse(status);
    }

    @Test
    public void whenASquareIsCreatedItCanHoldAPawn() {
        Square square = new Square();
        square.addPawn();
        boolean status = square.isOccupied();
        assertTrue(status);
    }

    @Test
    public void whenAPawnIsMovedASquareDoesNoLongerHoldOne() {
        Square square = new Square();
        square.addPawn();
        square.removePawn();
        boolean status = square.isOccupied();
        assertFalse(status);
    }
}
