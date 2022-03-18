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
        assertEquals(0, board.getStartSquare());
    }

    @Test
    public void whenPlayerTwoIsActiveStartSquareIsIndexNine() {
        Board board = new Board();
        board.nextPlayer();
        assertEquals(9, board.getStartSquare());
    }

    @Test
    public void whenPlayerThreeIsActiveStartSquareIsIndexNineteen() {
        Board board = new Board();
        board.nextPlayer();
        board.nextPlayer();
        assertEquals(19, board.getStartSquare());
    }

    @Test
    public void whenPlayerOneIsActiveStartSquareIsIndexTwentynine() {
        Board board = new Board();
        board.nextPlayer();
        board.nextPlayer();
        board.nextPlayer();
        assertEquals(29, board.getStartSquare());
    }

    @Test
    public void whenPlayerOneIsActiveEndSquareIsIndexThirtynine() {
        Board board = new Board();
        assertEquals(39, board.getEndSquare());
    }

    @Test
    public void whenPlayerTwoIsActiveEndSquareIsIndexEight() {
        Board board = new Board();
        board.nextPlayer();
        assertEquals(8, board.getEndSquare());
    }

    @Test
    public void whenPlayerThreeIsActiveEndSquareIsIndexEightteen() {
        Board board = new Board();
        board.nextPlayer();
        board.nextPlayer();
        assertEquals(18, board.getEndSquare());
    }

    @Test
    public void whenPlayerOneIsActiveEndSquareIsIndexTwentyEight() {
        Board board = new Board();
        board.nextPlayer();
        board.nextPlayer();
        board.nextPlayer();
        assertEquals(28, board.getEndSquare());
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
        board.PlaceNewPawn();
        assertTrue(board.getField().get(0).IsOccupied());
        assertEquals(0, board.getActivePlayer().getPawnList().get(0));
    }

    @Test
    public void whenAPlayerHasAPawnTheyCanMoveIt() {
        Board board = new Board();
        board.PlaceNewPawn();
        board.makeMovePawn(1);
        assertFalse(board.getField().get(0).IsOccupied());
        assertTrue(board.getField().get(board.getDiceThrow()).IsOccupied());
        assertEquals(board.getDiceThrow(), board.getActivePlayer().getPawnList().get(board.getDiceThrow()));
    }

}
