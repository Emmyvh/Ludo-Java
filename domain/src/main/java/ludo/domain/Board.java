package ludo.domain;

import java.util.ArrayList;
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
    private int indexOfOldSquare;
    private int indexOfNewSquare;

    public Board() {
        this.dice = new Dice();
        this.playerOne = new Player();
        this.playerTwo = new Player();
        this.playerThree = new Player();
        this.playerFour = new Player();
        this.activePlayer = playerOne;

        this.field = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            this.field.add(new Square());
        }
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

    public int getDiceThrow() {
        return diceThrow;
    }

    public int getIndexStartSquare() {
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

    public int getIndexEndSquare() {
        if (activePlayer == playerOne) {
            this.endSquareIndex = getIndexStartSquare() + 39;
        } else if (activePlayer == playerTwo) {
            this.endSquareIndex = getIndexStartSquare() + 39 - 40;
        } else if (activePlayer == playerThree) {
            this.endSquareIndex = getIndexStartSquare() + 39 - 40;
        } else if (activePlayer == playerFour) {
            this.endSquareIndex = getIndexStartSquare() + 39 - 40;
        }
        return endSquareIndex;
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

    public void placeNewPawn() {
        if (activePlayer.getNumberOfSquaresOccupied() + this.activePlayer.getScore() < 4
                && !(this.getField().get(getIndexStartSquare()).isOccupied())) {
            this.getField().get(getIndexStartSquare()).addPawn();
            this.getActivePlayer().addPawn(getIndexStartSquare());
        }
    }

    public void makeMovePawn(int pawnNumber) {
        this.dice.setDiceThrow();
        diceThrow = this.dice.getDiceThrow();
        indexOfOldSquare = getActivePlayer().getPawnList().get(pawnNumber - 1);

        this.getField().get(indexOfOldSquare).removePawn();
        this.getActivePlayer().losePawn(pawnNumber - 1);

        if (indexOfOldSquare + diceThrow >= getIndexEndSquare() && indexOfOldSquare < getIndexEndSquare()) {
            this.getField().get(indexOfOldSquare).removePawn();
            this.getActivePlayer().losePawn(indexOfOldSquare);
            this.getActivePlayer().addPoint();
        }

        indexOfNewSquare = (indexOfOldSquare + diceThrow) % 40;

        this.getField().get(indexOfNewSquare).addPawn();
        this.getActivePlayer().getPawnList().add(pawnNumber - 1, indexOfNewSquare);

        if (diceThrow != 6) {
            this.nextPlayer();
        }
    }
}
