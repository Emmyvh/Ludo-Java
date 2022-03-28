package ludo.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int score;
    private List<Integer> indexListSquaresOccupied;

    public Player() {
        this.score = 0;
        this.indexListSquaresOccupied = new ArrayList<Integer>();
    }

    public void addPoint() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public void addPawn(int index) {
        if (indexListSquaresOccupied.size() + score < 4) {
            indexListSquaresOccupied.add(Integer.valueOf(index));
        }
    }

    public void losePawn(int index) {
        if (indexListSquaresOccupied.size() > 0) {
            indexListSquaresOccupied.remove(Integer.valueOf(index));
        }
    }

    public List<Integer> getPawnList() {
        return indexListSquaresOccupied;
    }
}
