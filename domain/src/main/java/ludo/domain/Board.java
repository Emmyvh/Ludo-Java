package ludo.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Player playerOne;
    private Player playerTwo;
    private Player playerThree;
    private Player playerFour;
    private Player activePlayer;
    private Player winner;
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
    }

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

    public Player getWinner() {
        return winner;
    }

    public List<Square> getField() {
        return field;
    }

    public List<Integer> getActivePawnList() {
        return this.getActivePlayer().getPawnList();
    }

    public int getDiceThrow() {
        diceThrow = this.dice.getDiceThrow();
        return diceThrow;
    }

    public int getIndexStartSquare() {
        if (activePlayer == playerOne) {
            this.startSquareIndex = 0;
        } else if (activePlayer == playerTwo) {
            this.startSquareIndex = 10;
        } else if (activePlayer == playerThree) {
            this.startSquareIndex = 20;
        } else if (activePlayer == playerFour) {
            this.startSquareIndex = 30;
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

    public void setIndexOfNewSquare(int index) {
        indexOfNewSquare = index;
    }

    public void removeOldPawn(int pawnNumber) {
        this.getField().get(indexOfOldSquare).removePawn();
        this.getActivePlayer().losePawn(pawnNumber - 1);
    }

    public void pointCheck(int pawnNumber) {
        if (indexOfOldSquare + diceThrow >= getIndexEndSquare() && indexOfOldSquare < getIndexEndSquare()) {
            this.getActivePlayer().addPoint();
        } else {
            if (indexOfOldSquare + diceThrow > 39) {
                indexOfNewSquare = indexOfOldSquare + diceThrow - 40;
            } else {
                indexOfNewSquare = indexOfOldSquare + diceThrow;
            }

            this.hitCheck();

            this.returnPawn(pawnNumber);
        }
    }

    public void hitCheck() {
        if (this.getPlayerOne().getPawnList().contains(indexOfNewSquare)) {
            this.getPlayerOne().getPawnList().remove(Integer.valueOf(indexOfNewSquare));
        } else if (this.getPlayerTwo().getPawnList().contains(indexOfNewSquare)) {
            this.getPlayerTwo().getPawnList().remove(Integer.valueOf(indexOfNewSquare));
        } else if (this.getPlayerThree().getPawnList().contains(indexOfNewSquare)) {
            this.getPlayerThree().getPawnList().remove(Integer.valueOf(indexOfNewSquare));
        } else if (this.getPlayerFour().getPawnList().contains(indexOfNewSquare)) {
            this.getPlayerFour().getPawnList().remove(Integer.valueOf(indexOfNewSquare));
        }
    }

    public void returnPawn(int pawnNumber) {
        this.getField().get(indexOfNewSquare).addPawn();
        this.getActivePawnList().add(pawnNumber - 1, indexOfNewSquare);
    }

    public void checkForWinner() {
        if (playerOne.getScore() == 4) {
            winner = playerOne;
        } else if (playerTwo.getScore() == 4) {
            winner = playerTwo;
        } else if (playerThree.getScore() == 4) {
            winner = playerThree;
        } else if (playerFour.getScore() == 4) {
            winner = playerFour;
        }
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

    public boolean endOfGameCheck() {
        if (playerOne.getScore() == 4 || playerTwo.getScore() == 4 || playerThree.getScore() == 4
                || playerFour.getScore() == 4) {
            return true;
        } else {
            return false;
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
        this.getDiceThrow();
        indexOfOldSquare = getActivePawnList().get(pawnNumber - 1);

        this.removeOldPawn(pawnNumber);

        this.pointCheck(pawnNumber);

        this.checkForWinner();

        if (diceThrow != 6 && !(endOfGameCheck())) {
            this.nextPlayer();
        }
    }
}
