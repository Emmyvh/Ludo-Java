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
    public void whenASquareIsCreatedItCanHoldAPawn() {
        Square square = new Square();
        square.addPawn();
        boolean status = square.IsOccupied();
        assertTrue(status);
    }

    @Test
    public void whenAPawnIsMovedASquareDoesNoLongerHoldOne() {
        Square square = new Square();
        square.addPawn();
        square.removePawn();
        boolean status = square.IsOccupied();
        assertFalse(status);
    }
}
