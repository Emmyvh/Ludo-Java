import "./Ludo.css";

export function StartLudo() {

    const diceThrow = dice;

    async function rollADice() {
        try {
            const response = await fetch('mancala/api/start', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ dice: dice })
            });

        } catch (error) {
            console.error(error.toString());
        }
    }

    return (
        <div>
            <button className="Dice" onClick={() => rollADice()}>{diceThrow}
                Roll The Dice!
            </button>
        </div>
    )
}