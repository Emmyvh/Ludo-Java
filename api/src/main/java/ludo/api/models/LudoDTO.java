package ludo.api.models;

import ludo.domain.Board;

public class LudoDTO {

    public Board newBoard;
    public GameStatusDTO gameStatus;
    public ActivePlayerDTO activePlayer;

    public LudoDTO(ludo.domain.Board board) {
        newBoard = board;
        gameStatus = new GameStatusDTO(board);
        activePlayer = new ActivePlayerDTO(board);
    }

    public Board getNewBoard() {
        return newBoard;
    }

    public GameStatusDTO getGameStatus() {
        return gameStatus;
    }

    public ActivePlayerDTO getActivePlayer() {
        return activePlayer;
    }
}
