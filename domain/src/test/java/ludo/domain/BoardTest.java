package ludo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    public void whenAGameIsStartedPlayerOneIsAcitve() {
        Board board = new Board();
        assertEquals(board.getPlayerOne(), board.getActivePlayer());
    }

    @Test
    public void whenPlayerOneIsActivePlayerTwoIsNext() {
        Board board = new Board();
        board.nextPlayer();
        assertEquals(board.getPlayerTwo(), board.getActivePlayer());
    }

    @Test
    public void whenPlayerTwoIsActivePlayerThreeIsNext() {
        Board board = new Board();
        board.nextPlayer();
        board.nextPlayer();
        assertEquals(board.getPlayerThree(), board.getActivePlayer());
    }

    @Test
    public void whenPlayerThreeIsActivePlayerFourIsNext() {
        Board board = new Board();
        board.nextPlayer();
        board.nextPlayer();
        board.nextPlayer();
        assertEquals(board.getPlayerFour(), board.getActivePlayer());
    }

    @Test
    public void whenPlayerFourIsActivePlayerOneIsNext() {
        Board board = new Board();
        board.nextPlayer();
        board.nextPlayer();
        board.nextPlayer();
        board.nextPlayer();
        assertEquals(board.getPlayerOne(), board.getActivePlayer());
    }

    @Test
    public void whenPlayerOneIsActiveStartSquareIsIndexZero() {
        Board board = new Board();
        assertEquals(0, board.getIndexStartSquare());
    }

    @Test
    public void whenPlayerTwoIsActiveStartSquareIsIndexNine() {
        Board board = new Board();
        board.nextPlayer();
        assertEquals(9, board.getIndexStartSquare());
    }

    @Test
    public void whenPlayerThreeIsActiveStartSquareIsIndexNineteen() {
        Board board = new Board();
        board.nextPlayer();
        board.nextPlayer();
        assertEquals(19, board.getIndexStartSquare());
    }

    @Test
    public void whenPlayerOneIsActiveStartSquareIsIndexTwentynine() {
        Board board = new Board();
        board.nextPlayer();
        board.nextPlayer();
        board.nextPlayer();
        assertEquals(29, board.getIndexStartSquare());
    }

    @Test
    public void whenPlayerOneIsActiveEndSquareIsIndexThirtynine() {
        Board board = new Board();
        assertEquals(39, board.getIndexEndSquare());
    }

    @Test
    public void whenPlayerTwoIsActiveEndSquareIsIndexEight() {
        Board board = new Board();
        board.nextPlayer();
        assertEquals(8, board.getIndexEndSquare());
    }

    @Test
    public void whenPlayerThreeIsActiveEndSquareIsIndexEightteen() {
        Board board = new Board();
        board.nextPlayer();
        board.nextPlayer();
        assertEquals(18, board.getIndexEndSquare());
    }

    @Test
    public void whenPlayerOneIsActiveEndSquareIsIndexTwentyEight() {
        Board board = new Board();
        board.nextPlayer();
        board.nextPlayer();
        board.nextPlayer();
        assertEquals(28, board.getIndexEndSquare());
    }

    @Test
    public void whenAPlayerHasActivePawnsAListCanBeReturned() {
        Board board = new Board();
        board.getActivePlayer().addPawn(0);
        board.getActivePlayer().addPawn(5);
        assertEquals(0, board.getActivePlayer().getPawnList().get(0));
        assertEquals(5, board.getActivePlayer().getPawnList().get(1));
    }

    @Test
    public void whenAPlayerStartsTheyCanPlaceAPawn() {
        Board board = new Board();
        board.placeNewPawn();
        assertTrue(board.getField().get(0).isOccupied());
        assertEquals(0, board.getActivePlayer().getPawnList().get(0));
    }

    @Test
    public void whenTwoPawnsWantToOccpyTheSameSpaceTheSecondPawnIsNotCreated() {
        Board board = new Board();
        board.placeNewPawn();
        board.placeNewPawn();
        assertTrue(board.getField().get(0).isOccupied());
        assertEquals(0, board.getActivePlayer().getPawnList().get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> board.getActivePlayer().getPawnList().get(1));
    }

    @Test
    public void whenAPlayerHasFourPointsAPawnIsNotCreated() {
        Board board = new Board();
        board.getActivePlayer().addPoint();
        board.getActivePlayer().addPoint();
        board.getActivePlayer().addPoint();
        board.getActivePlayer().addPoint();
        board.placeNewPawn();
        assertThrows(IndexOutOfBoundsException.class, () -> board.getActivePlayer().getPawnList().get(0));
    }

    @Test
    public void whenADiceIsThrownItGivesARandomNumber() {
        Board board = new Board();
        board.placeNewPawn();
        assertTrue(board.getField().get(0).isOccupied());
        board.makeMovePawn(1);
        assertTrue(0 < board.getDiceThrow());
        assertTrue(board.getDiceThrow() < 7);
    }

    @Test
    public void whenAPlayerHasAPawnTheyCanMoveIt() {
        Board board = new Board();
        board.placeNewPawn();
        assertTrue(board.getField().get(0).isOccupied());
        board.makeMovePawn(1);
        assertFalse(board.getField().get(0).isOccupied());
        assertTrue(board.getField().get(board.getDiceThrow()).isOccupied());
        assertEquals(board.getDiceThrow(), board.getPlayerOne().getPawnList().get(0));
    }

    @Test
    public void whenAPlayerMovesAPawnTheyCanScoreAPoint() {
        Board board = new Board();
        board.getField().get(38).addPawn();
        board.getActivePlayer().addPawn(38);
        assertTrue(board.getField().get(38).isOccupied());
        board.makeMovePawn(1);
        assertFalse(board.getField().get(38).isOccupied());
        assertEquals(1, board.getPlayerOne().getScore());
    }

    @Test
    public void whenAPlayerDoesNotThrowSixTheNextPlayerGetsToMove() {
        Board board = new Board();
        board.placeNewPawn();
        board.makeMovePawn(1);
        if (board.getDiceThrow() == 6) {
            assertEquals(board.getActivePlayer(), board.getPlayerOne());
        } else {
            assertEquals(board.getActivePlayer(), board.getPlayerTwo());
        }
    }
}
