package ludo.api.models;

public class GameStatusDTO {

    public boolean gameStatus;
    public String winner;

    public GameStatusDTO(ludo.domain.Board board) {
        gameStatus = board.endOfGameCheck();

        if (board.getWinner() == board.getPlayerOne()) {
            winner = "PlayerOne";
        } else if (board.getWinner() == board.getPlayerTwo()) {
            winner = "PlayerTwo";
        } else if (board.getWinner() == board.getPlayerThree()) {
            winner = "PlayerThree";
        } else if (board.getWinner() == board.getPlayerFour()) {
            winner = "PlayerFour";
        }
    }

    public boolean getGameStatus() {
        return gameStatus;
    }

    public String getWinner() {
        return winner;
    }

}
