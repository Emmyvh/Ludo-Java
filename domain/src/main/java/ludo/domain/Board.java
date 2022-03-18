package ludo.domain;

import java.util.Collections;
import java.util.List;

public class Board {
    private Player playerOne;
    private Player playerTwo;
    private Player playerThree;
    private Player playerFour;
    private Player activePlayer;
    private Dice dice;
    private int diceThrow;
    private List<Square> field;
    private int startSquareIndex;
    private int endSquareIndex;

    public Board() {
        this.dice = new Dice();
        this.playerOne = new Player();
        this.playerTwo = new Player();
        this.playerThree = new Player();
        this.playerFour = new Player();
        this.activePlayer = playerOne;

        this.field = Collections.nCopies(40, new Square());
    };

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getPlayerThree() {
        return playerThree;
    }

    public Player getPlayerFour() {
        return playerFour;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public List<Square> getField() {
        return field;
    }

    public void nextPlayer() {
        if (activePlayer == playerOne) {
            activePlayer = playerTwo;
        } else if (activePlayer == playerTwo) {
            activePlayer = playerThree;
        } else if (activePlayer == playerThree) {
            activePlayer = playerFour;
        } else if (activePlayer == playerFour) {
            activePlayer = playerOne;
        }
    }

    public int getStartSquare() {
        if (activePlayer == playerOne) {
            this.startSquareIndex = 0;
        } else if (activePlayer == playerTwo) {
            this.startSquareIndex = 9;
        } else if (activePlayer == playerThree) {
            this.startSquareIndex = 19;
        } else if (activePlayer == playerFour) {
            this.startSquareIndex = 29;
        }
        return startSquareIndex;
    }

    public int getEndSquare() {
        if (activePlayer == playerOne) {
            this.endSquareIndex = getStartSquare() + 39;
        } else if (activePlayer == playerTwo) {
            this.endSquareIndex = getStartSquare() + 39 - 40;
        } else if (activePlayer == playerThree) {
            this.endSquareIndex = getStartSquare() + 39 - 40;
        } else if (activePlayer == playerFour) {
            this.endSquareIndex = getStartSquare() + 39 - 40;
        }
        return endSquareIndex;
    }

    public int getDiceThrow() {
        return diceThrow;
    }

    public void PlaceNewPawn() {
        if (activePlayer.getNumberOfSquaresOccupied() < 4 && !(this.getField().get(getStartSquare()).IsOccupied())) {
            this.getField().get(getStartSquare()).addPawn();
            this.getActivePlayer().addPawn(getStartSquare());
        }
    }

    public void makeMovePawn(int index) {
        this.dice.setDiceThrow();
        diceThrow = this.dice.getDiceThrow();

        this.getField().get(getActivePlayer().getPawnList().get(index - 1)).removePawn();
        this.getActivePlayer().losePawn(index - 1);
        this.getField().get(index - 1 + diceThrow).addPawn();

        if (diceThrow != 6) {
            this.nextPlayer();
        }
    }
}
