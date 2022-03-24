import React, { useState } from "react";
import "./Ludo.css";

export function PlayLudo() {

    // These are the import statements for the JSon information
    const [newBoard, setNewBoard] = useState(0);
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
                setActivePlayer(newBoard.activePlayer);
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


            <div className="controls">
                <button className="startGame" onClick={() => StartLudo()}>(re)start Game</button>
                <div className="dice" >{diceThrow}</div>
                <button className="addPawn" onClick={() => PlacePawn()}>Place a pawn</button>
                <button className="movePawn" onClick={() => MovePawn(1)}>Move Pawn 1</button>
                <button className="movePawn" onClick={() => MovePawn(2)}>Move Pawn 2</button>
                <button className="movePawn" onClick={() => MovePawn(3)}>Move pawn 3</button>
                <button className="movePawn" onClick={() => MovePawn(4)}>move pawn 4</button>
            </div>


            <div className="textBox">The current player is: {activePlayerName}</div>
            <div className="textBox">Your pawns are at the following locations:{pawnList} </div>

            <div className="box">
                <div className="startSquareTwo">11</div>
                <div className="square">12</div>
                <div className="square">13</div>
            </div>

            <div className="box">
                <div className="square">10</div>
                <div className="filler"></div>
                <div className="square">14</div>
            </div>

            <div className="box">
                <div className="square">09</div>
                <div className="filler"></div>
                <div className="square">15</div>
            </div>

            <div className="box">
                <div className="square">08</div>
                <div className="filler"></div>
                <div className="square">16</div>
            </div>

            <div className="box">
                <div className="square">03</div>
                <div className="square">04</div>
                <div className="square">05</div>
                <div className="square">06</div>
                <div className="square">07</div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="square">17</div>
                <div className="square">18</div>
                <div className="square">19</div>
                <div className="square">20</div>
                <div className="startSquareThree">21</div>
            </div>

            <div className="box">
                <div className="square">02</div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="square">22</div>
            </div>

            <div className="box">
                <div className="startSquareOne">01</div>
                <div className="square">40</div>
                <div className="square">39</div>
                <div className="square">38</div>
                <div className="square">37</div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="filler"></div>
                <div className="square">27</div>
                <div className="square">26</div>
                <div className="square">25</div>
                <div className="square">24</div>
                <div className="square">23</div>
            </div>

            <div className="box">
                <div className="square">36</div>
                <div className="filler"></div>
                <div className="square">28</div>
            </div>
            <div className="box">
                <div className="square">35</div>
                <div className="filler"></div>
                <div className="square">29</div>
            </div>

            <div className="box">
                <div className="square">34</div>
                <div className="filler"></div>
                <div className="square">30</div>
            </div>

            <div className="box">
                <div className="square">33</div>
                <div className="square">32</div>
                <div className="startSquareFour">31</div>
            </div>
        </div >
    )
}