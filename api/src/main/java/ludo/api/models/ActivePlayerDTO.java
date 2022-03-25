package ludo.api.models;

public class ActivePlayerDTO {
    String activePlayer;

    public ActivePlayerDTO(ludo.domain.Board board) {
        if (board.getActivePlayer() == board.getPlayerOne()) {
            activePlayer = "player one";
        } else if (board.getActivePlayer() == board.getPlayerTwo()) {
            activePlayer = "player two";
        } else if (board.getActivePlayer() == board.getPlayerThree()) {
            activePlayer = "player three";
        } else if (board.getActivePlayer() == board.getPlayerFour()) {
            activePlayer = "player four";
        }
    }

    public String getActivePlayer() {
        return activePlayer;
    }
}
