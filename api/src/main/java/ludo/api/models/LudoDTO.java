package ludo.api.models;

public class LudoDTO {

    public int diceThrow;

    public LudoDTO(ludo.domain.Dice dice) {
        dice.setDiceThrow();
        diceThrow = dice.getDiceThrow();
    }

    public int getDiceThrow() {
        return diceThrow;
    }
}
