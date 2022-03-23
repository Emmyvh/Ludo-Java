import React, { useState } from "react";
import "./Ludo.css";

export function PlayLudo() {

    // These are the import statements for the JSon information
    const [newBoard, setnewBoard] = useState(0);
    const [activePlayer, setActivePlayer] = useState(0);
    const [gameState, setGameStatus] = useState(0);

    // This function starts the game.
    async function StartLudo() {
        try {
            const response = await fetch('/api/start', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
            });

            if (response.ok) {
                const newBoard = await response.json();
                setNewBoard(newBoard);
                const activePlayer = await response.json();
                setNewBoard(newBoard.activePlayer);
                const gameState = await response.json();
                setGameStatus(gameState);
            }

        } catch (error) {
            console.error(error.toString());
        }
    }

    // This function is used to place a new pawn at your statring square.
    async function PlacePawn() {
        try {
            const response = await fetch('/api/place', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
            });

        } catch (error) {
            console.error(error.toString());
        }
    }

    //This function is used to move existing pawns.
    async function MovePawn(index) {
        try {
            const response = await fetch('/api/move', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ index: index })
            });
        } catch (error) {
            console.error(error.toString());
        }
    }

    // Here the variables are declared for the HTML return statement.

    var diceThrow = newBoard.diceThrow;

    var activePlayerName;
    if (newBoard.ActivePlayer == newBoard.PlayerOne) {
        activePlayerName = "player one";
    } else if (newBoard.ActivePlayer == newBoard.PlayerTwo) {
        activePlayerName = "player two";
    } else if (newBoard.ActivePlayer == newBoard.PlayerThree) {
        activePlayerName = "player three";
    } else {
        activePlayerName = "player four";
    }

    var pawnList = activePlayer.pawnList;

    const winner = gameState.winner;


    // The layout of the board.
    return (
        <div>
            <class className="controls">
                <class className="dice" >{diceThrow}</class>
                <button className="addPawn" onClick={() => PlacePawn()}>Place new pawn</button>
                <button className="movePawn" onClick={() => MovePawn(1)}>Move Pawn 1</button>
                <button className="movePawn" onClick={() => MovePawn(2)}>Move Pawn 2</button>
                <button className="movePawn" onClick={() => MovePawn(3)}>Move pawn 3</button>
                <button className="movePawn" onClick={() => MovePawn(4)}>move pawn 4</button>
            </class>

            <class className="textBox">The current player is: {activePlayerName}</class>
            <class className="textBox">Your pawns are at the following locations:{pawnList} </class>
            <class className="textBox">The winner is: {winner} </class>

            <class className="board">
                <class className="startSquareOne">01</class>
                <class className="square">02</class>
                <class className="square">03</class>
                <class className="square">04</class>
                <class className="square">05</class>
                <class className="square">06</class>
                <class className="square">07</class>
                <class className="square">08</class>
                <class className="square">09</class>
                <class className="square">10</class>
                <class className="startSquareTwo">11</class>
                <class className="square">12</class>
                <class className="square">13</class>
                <class className="square">14</class>
                <class className="square">15</class>
                <class className="square">16</class>
                <class className="square">17</class>
                <class className="square">18</class>
                <class className="square">19</class>
                <class className="square">20</class>
            </class>

            <class className="board">
                <class className="startSquareThree">21</class>
                <class className="square">22</class>
                <class className="square">23</class>
                <class className="square">24</class>
                <class className="square">25</class>
                <class className="square">26</class>
                <class className="square">27</class>
                <class className="square">28</class>
                <class className="square">29</class>
                <class className="square">30</class>
                <class className="startSquareFour">31</class>
                <class className="square">32</class>
                <class className="square">33</class>
                <class className="square">34</class>
                <class className="square">35</class>
                <class className="square">36</class>
                <class className="square">37</class>
                <class className="square">38</class>
                <class className="square">39</class>
                <class className="square">40</class>
            </class>

        </div>
    )
}