package ludo.domain;

public class Square {
    boolean hasPawn = false;

    public void setHasPawn() {
        hasPawn = true;
    }

    public boolean IsOccupied() {
        if (hasPawn) {
            return true;
        } else {
            return false;
        }

    }
}
