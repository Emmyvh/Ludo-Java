import React, { useState } from "react";
import "./Ludo.css";
import One from "./one.png";
import Two from "./two.png";
import Three from "./three.png";
import Four from "./four.png";
import Five from "./five.png";
import Six from "./six.png";

export function PlayLudo() {

    // These are the import statements for the JSon information
    const [newBoard, setNewBoard] = useState(undefined);
    const [gameStatus, setGameStatus] = useState(undefined);
    const [activePlayer, setActivePlayer] = useState(undefined);

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
                const data = await response.json()
                setNewBoard(data.newBoard)
                setGameStatus(data.gameStatus)
                setActivePlayer(data.activePlayer.activePlayer)
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

            if (response.ok) {
                const data = await response.json()
                setNewBoard(data.newBoard)
                setGameStatus(data.gameStatus)
                setActivePlayer(data.activePlayer.activePlayer)
            }
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

            if (response.ok) {
                const data = await response.json()
                setNewBoard(data.newBoard)
                setGameStatus(data.gameStatus)
                setActivePlayer(data.activePlayer.activePlayer)
            }
        } catch (error) {
            console.error(error.toString());
        }
    }

    function diceImage() {
        if (newBoard) {
            let list = [One, Two, Three, Four, Five, Six]
            return list[newBoard.diceThrow - 1]
        }
    }

    // predefined variables for the return.
    if (newBoard) {

        var playerOnePawnOneLocation = Number(newBoard.playerOne.pawnList[0]) + 1;
        var playerOnePawnTwoLocation = Number(newBoard.playerOne.pawnList[1]) + 1;
        var playerOnePawnThreeLocation = Number(newBoard.playerOne.pawnList[2]) + 1;
        var playerOnePawnFourLocation = Number(newBoard.playerOne.pawnList[3]) + 1;

        var playerTwoPawnOneLocation = Number(newBoard.playerTwo.pawnList[0]) + 1;
        var playerTwoPawnTwoLocation = Number(newBoard.playerTwo.pawnList[1]) + 1;
        var playerTwoPawnThreeLocation = Number(newBoard.playerTwo.pawnList[2]) + 1;
        var playerTwoPawnFourLocation = Number(newBoard.playerTwo.pawnList[3]) + 1;

        var playerThreePawnOneLocation = Number(newBoard.playerThree.pawnList[0]) + 1;
        var playerThreePawnTwoLocation = Number(newBoard.playerThree.pawnList[1]) + 1;
        var playerThreePawnThreeLocation = Number(newBoard.playerThree.pawnList[2]) + 1;
        var playerThreePawnFourLocation = Number(newBoard.playerThree.pawnList[3]) + 1;

        var playerFourPawnOneLocation = Number(newBoard.playerFour.pawnList[0]) + 1;
        var playerFourPawnTwoLocation = Number(newBoard.playerFour.pawnList[1]) + 1;
        var playerFourPawnThreeLocation = Number(newBoard.playerFour.pawnList[2]) + 1;
        var playerFourPawnFourLocation = Number(newBoard.playerFour.pawnList[3]) + 1;
    }

    // The layout of the board.
    return (
        <div>{newBoard ? (
            <div>
                <div className="controls">
                    <button className="startOver" onClick={() => StartLudo()}>restart Game</button>
                    <div className="dice" ><img src={diceImage()} /></div>
                    <button className="addPawn" onClick={() => PlacePawn()}>Place a pawn</button>
                    <button className="movePawn" onClick={() => MovePawn(1)}>Move Pawn 1</button>
                    <button className="movePawn" onClick={() => MovePawn(2)}>Move Pawn 2</button>
                    <button className="movePawn" onClick={() => MovePawn(3)}>Move pawn 3</button>
                    <button className="movePawn" onClick={() => MovePawn(4)}>move pawn 4</button>
                </div>


                <div className="textBox">The current player is: {activePlayer}</div>
                <div className="textBox">Player one's pawns are at the following locations: {playerOnePawnOneLocation}, {playerOnePawnTwoLocation}, {playerOnePawnThreeLocation}, {playerOnePawnFourLocation}</div>
                <div className="textBox">Player two's pawns are at the following locations: {playerTwoPawnOneLocation}, {playerTwoPawnTwoLocation}, {playerTwoPawnThreeLocation}, {playerTwoPawnFourLocation}</div>
                <div className="textBox">Player three's pawns are at the following locations: {playerThreePawnOneLocation}, {playerThreePawnTwoLocation}, {playerThreePawnThreeLocation}, {playerThreePawnFourLocation}</div>
                <div className="textBox">Player four's pawns are at the following locations: {playerFourPawnOneLocation}, {playerFourPawnTwoLocation}, {playerFourPawnThreeLocation}, {playerFourPawnFourLocation}</div>

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
                    <div className={(newBoard.field[0].isOccupied) ? "occupied" : "startSquareOne"}>01</div>
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
            </div>)
            : <div className="controls">
                <button className="startGame" onClick={() => StartLudo()}>start a new Game</button>
            </div>}
        </div>
    )
}