package ludo.domain;

public class Square {
    boolean hasPawn = false;

    public void addPawn() {
        hasPawn = true;
    }

    public void removePawn() {
        hasPawn = false;
    }

    public boolean IsOccupied() {
        if (hasPawn) {
            return true;
        } else {
            return false;
        }

    }
}
