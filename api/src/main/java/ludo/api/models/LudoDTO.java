package ludo.api.models;

import ludo.domain.Board;

public class LudoDTO {

    public Board newBoard;
    public GameStatusDTO gameStatus;

    public LudoDTO(ludo.domain.Board board) {
        newBoard = board;
        gameStatus = new GameStatusDTO(board);
    }

    public Board getNewBoard() {
        return newBoard;
    }

    public GameStatusDTO getGameStatus() {
        return gameStatus;
    }
}
