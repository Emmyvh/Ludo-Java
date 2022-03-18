package ludo.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int score;
    private int numberOfSquaresOccupied;
    private List<Integer> indexListSquaresOccupied;

    public Player() {
        this.score = 0;
        this.numberOfSquaresOccupied = 0;
        this.indexListSquaresOccupied = new ArrayList<Integer>();
    }

    public void addPoint() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public void addPawn(int index) {
        if (numberOfSquaresOccupied + score < 4) {
            numberOfSquaresOccupied++;
            indexListSquaresOccupied.add(index);
        }
    }

    public void losePawn(int index) {
        if (numberOfSquaresOccupied + score > 0) {
            numberOfSquaresOccupied--;
            indexListSquaresOccupied.remove(index);
        }
    }

    public int getNumberOfSquaresOccupied() {
        return numberOfSquaresOccupied;
    }

    public List<Integer> getPawnList() {
        return indexListSquaresOccupied;
    }
}
