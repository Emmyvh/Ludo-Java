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
        assertTrue(board.getField().get(0).isOccupied());
        board.makeMovePawn(1);
        assertFalse(board.getField().get(0).isOccupied());
        assertTrue(board.getField().get(board.getDiceThrow()).isOccupied());
        assertEquals(board.getDiceThrow(), board.getPlayerOne().getPawnList().get(0));
        if (board.getDiceThrow() == 6) {
            assertEquals(board.getActivePlayer(), board.getPlayerOne());
        } else {
            assertEquals(board.getActivePlayer(), board.getPlayerTwo());
        }
    }

    @Test
    public void whenPlayerOneHasHadTheirTurnPlayerTwoGetsToMove() {
        Board board = new Board();
        board.placeNewPawn();
        assertTrue(board.getField().get(0).isOccupied());
        board.makeMovePawn(1);
        assertFalse(board.getField().get(0).isOccupied());
        assertTrue(board.getField().get(board.getDiceThrow()).isOccupied());
        assertEquals(board.getDiceThrow(), board.getPlayerOne().getPawnList().get(0));

        if (board.getDiceThrow() == 6) {
            assertEquals(board.getActivePlayer(), board.getPlayerOne());
            board.placeNewPawn();
            board.makeMovePawn(1);
        } else {
            assertEquals(board.getActivePlayer(), board.getPlayerTwo());
            board.placeNewPawn();
            assertTrue(board.getField().get(9).isOccupied());
            board.makeMovePawn(1);
            assertFalse(board.getField().get(9).isOccupied());
            assertTrue(board.getField().get(board.getDiceThrow() + 9).isOccupied());
            assertEquals(board.getDiceThrow() + 9, board.getPlayerTwo().getPawnList().get(0));
        }
    }

    @Test
    public void whenAGameStartsItHasNotEnded() {
        Board board = new Board();
        assertFalse(board.endOfGameCheck());
    }

    @Test
    public void whenPlayerOneHasFourPointsTheGameEnds() {
        Board board = new Board();
        assertFalse(board.endOfGameCheck());
        board.getActivePlayer().addPoint();
        board.getActivePlayer().addPoint();
        board.getActivePlayer().addPoint();
        board.getActivePlayer().addPoint();
        assertTrue(board.endOfGameCheck());
    }

    @Test
    public void whenPlayerTwoHasFourPointsTheGameEnds() {
        Board board = new Board();
        assertFalse(board.endOfGameCheck());
        board.getPlayerTwo().addPoint();
        board.getPlayerTwo().addPoint();
        board.getPlayerTwo().addPoint();
        board.getPlayerTwo().addPoint();
        assertTrue(board.endOfGameCheck());
    }

    @Test
    public void whenPlayerThreeHasFourPointsTheGameEnds() {
        Board board = new Board();
        assertFalse(board.endOfGameCheck());
        board.getPlayerThree().addPoint();
        board.getPlayerThree().addPoint();
        board.getPlayerThree().addPoint();
        board.getPlayerThree().addPoint();
        assertTrue(board.endOfGameCheck());
    }

    @Test
    public void whenPlayerFourHasFourPointsTheGameEnds() {
        Board board = new Board();
        assertFalse(board.endOfGameCheck());
        board.getPlayerFour().addPoint();
        board.getPlayerFour().addPoint();
        board.getPlayerFour().addPoint();
        board.getPlayerFour().addPoint();
        assertTrue(board.endOfGameCheck());
    }

    @Test
    public void whenAGameEndsPlayerOneWins() {
        Board board = new Board();
        assertFalse(board.endOfGameCheck());
        board.getActivePlayer().addPoint();
        board.getActivePlayer().addPoint();
        board.getActivePlayer().addPoint();
        assertEquals(3, board.getPlayerOne().getScore());

        board.getField().get(38).addPawn();
        board.getActivePlayer().addPawn(38);
        assertTrue(board.getField().get(38).isOccupied());
        board.makeMovePawn(1);
        assertFalse(board.getField().get(38).isOccupied());
        assertEquals(4, board.getPlayerOne().getScore());

        assertTrue(board.endOfGameCheck());
        assertEquals(board.getPlayerOne(), board.getActivePlayer());
        assertEquals(board.getPlayerOne(), board.getWinner());
    }

    @Test
    public void whenAGameEndsPlayerTwoWins() {
        Board board = new Board();
        assertFalse(board.endOfGameCheck());
        board.getPlayerTwo().addPoint();
        board.getPlayerTwo().addPoint();
        board.getPlayerTwo().addPoint();
        assertEquals(3, board.getPlayerTwo().getScore());

        board.nextPlayer();
        board.getField().get(7).addPawn();
        board.getActivePlayer().addPawn(7);
        assertTrue(board.getField().get(7).isOccupied());
        board.makeMovePawn(1);
        assertFalse(board.getField().get(7).isOccupied());
        assertEquals(4, board.getPlayerTwo().getScore());

        assertTrue(board.endOfGameCheck());
        assertEquals(board.getPlayerTwo(), board.getActivePlayer());
        assertEquals(board.getPlayerTwo(), board.getWinner());
    }

    @Test
    public void whenAGameEndsPlayerThreeWins() {
        Board board = new Board();
        assertFalse(board.endOfGameCheck());
        board.getPlayerThree().addPoint();
        board.getPlayerThree().addPoint();
        board.getPlayerThree().addPoint();
        assertEquals(3, board.getPlayerThree().getScore());

        board.nextPlayer();
        board.nextPlayer();
        board.getField().get(17).addPawn();
        board.getActivePlayer().addPawn(17);
        assertTrue(board.getField().get(17).isOccupied());
        board.makeMovePawn(1);
        assertFalse(board.getField().get(17).isOccupied());
        assertEquals(4, board.getPlayerThree().getScore());

        assertTrue(board.endOfGameCheck());
        assertEquals(board.getPlayerThree(), board.getActivePlayer());
        assertEquals(board.getPlayerThree(), board.getWinner());
    }

    @Test
    public void whenAGameEndsPlayerFourWins() {
        Board board = new Board();
        assertFalse(board.endOfGameCheck());
        board.getPlayerFour().addPoint();
        board.getPlayerFour().addPoint();
        board.getPlayerFour().addPoint();
        assertEquals(3, board.getPlayerFour().getScore());

        board.nextPlayer();
        board.nextPlayer();
        board.nextPlayer();
        board.getField().get(27).addPawn();
        board.getActivePlayer().addPawn(27);
        assertTrue(board.getField().get(27).isOccupied());
        board.makeMovePawn(1);
        assertFalse(board.getField().get(27).isOccupied());
        assertEquals(4, board.getPlayerFour().getScore());

        assertTrue(board.endOfGameCheck());
        assertEquals(board.getPlayerFour(), board.getActivePlayer());
        assertEquals(board.getPlayerFour(), board.getWinner());
    }

    @Test
    public void whenASquareIsAlreadyOccupiedThePreviousPawnGetsRemoved() {
        Board board = new Board();
        assertFalse(board.endOfGameCheck());
        board.getField().get(6).addPawn();
        board.getPlayerTwo().addPawn(6);
        assertTrue(board.getField().get(6).isOccupied());
        assertEquals(6, board.getPlayerTwo().getPawnList().get(0));

        board.setIndexOfNewSquare(6);
        board.hitCheck();
        assertFalse(board.getField().get(6).isOccupied());
        assertThrows(IndexOutOfBoundsException.class, () -> board.getPlayerTwo().getPawnList().get(0));
    }
}
