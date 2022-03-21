package ludo.domain;

public class Square {
    private boolean hasPawn = false;

    public void addPawn() {
        hasPawn = true;
    }

    public void removePawn() {
        hasPawn = false;
    }

    public boolean isOccupied() {
        return hasPawn;
    }
}
