package ludo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void whenAPlayerStartsTheirScoreIsZero() {
        Player playerOne = new Player();
        assertEquals(0, playerOne.getScore());
    }

    @Test
    public void whenAPlayerScoresAPointTheirScoreIsAltered() {
        Player playerOne = new Player();
        playerOne.addPoint();
        assertEquals(1, playerOne.getScore());
    }

    @Test
    public void whenAplayerStartsTheyOccupyZeroSquares() {
        Player playerOne = new Player();
        assertEquals(0, playerOne.getPawnList().size());
    }

    @Test
    public void whenAPlayerPlaysAPawnTheyHaveOnePawn() {
        Player playerOne = new Player();
        playerOne.addPawn(0);
        assertEquals(1, playerOne.getPawnList().size());
        assertEquals(0, playerOne.getPawnList().get(0));
    }

    @Test
    public void whenAPlayerHasAPawnTheyCanLoseIt() {
        Player playerOne = new Player();
        playerOne.addPawn(0);
        playerOne.losePawn(0);
        assertEquals(0, playerOne.getPawnList().size());
    }

    @Test
    public void whenAPlayerHasFourPawnsTheyCannotGetMore() {
        Player playerOne = new Player();
        playerOne.addPawn(0);
        playerOne.addPawn(1);
        playerOne.addPawn(2);
        playerOne.addPawn(3);
        playerOne.addPawn(4);
        assertEquals(4, playerOne.getPawnList().size());
        assertEquals(0, playerOne.getPawnList().get(0));
        assertEquals(1, playerOne.getPawnList().get(1));
        assertEquals(2, playerOne.getPawnList().get(2));
        assertEquals(3, playerOne.getPawnList().get(3));
    }

    @Test
    public void whenPawnsAreLostSquaresOccupiedCannotGoBelowZero() {
        Player playerOne = new Player();
        playerOne.losePawn(0);
        assertEquals(0, playerOne.getPawnList().size());
    }

    @Test
    public void whenAPlayerHasScoredAPointThisIsStillCountedAsAnActivePawn() {
        Player playerOne = new Player();
        playerOne.addPoint();
        playerOne.addPoint();
        playerOne.addPawn(0);
        playerOne.addPawn(1);
        playerOne.addPawn(2);
        assertEquals(2, playerOne.getPawnList().size());
        assertEquals(0, playerOne.getPawnList().get(0));
        assertEquals(1, playerOne.getPawnList().get(1));
    }

}
