import React, { useState } from "react";
import "./Ludo.css";

export function StartLudo() {

    const [diceThrow, setDiceThrow] = useState("");

    async function rollADice(dice) {
        try {
            const response = await fetch('/api/start', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ dice: dice })
            });

            if (response.ok) {
                const diceThrow = await response.json();
                setDiceThrow(10);
            }

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