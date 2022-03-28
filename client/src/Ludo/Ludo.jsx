import React, { useState } from "react";
import "./Ludo.css";
import One from "./one.png";
import Two from "./two.png";
import Three from "./three.png";
import Four from "./four.png";
import Five from "./five.png";
import Six from "./six.png";
import P1Pawn from "./P1Pawn.png";
import P2Pawn from "./P2Pawn.png";
import P3Pawn from "./P3Pawn.png";
import P4Pawn from "./P4Pawn.png";

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
    //These functions manage images.
    function DiceImage() {
        let list = [One, Two, Three, Four, Five, Six]
        return list[newBoard.diceThrow - 1]
    }

    function pawnPicture() {
        if (activePlayer == "player one") {
            return P1Pawn;
        } else if (activePlayer == "player two") {
            return P2Pawn;
        } else if (activePlayer == "player three") {
            return P3Pawn;
        } else if (activePlayer == "player four") {
            return P4Pawn;
        }
    }
    // These functions manage the visibility of occupied squares.
    function occupiedSquare(fieldIndex) {
        if (newBoard.field[fieldIndex].occupied) {
            if (newBoard.playerOne.pawnList.includes(fieldIndex)) {
                return "occupiedOne";
            } else if (newBoard.playerTwo.pawnList.includes(fieldIndex)) {
                return "occupiedTwo";
            } else if (newBoard.playerThree.pawnList.includes(fieldIndex)) {
                return "occupiedThree";
            } else if (newBoard.playerFour.pawnList.includes(fieldIndex)) {
                return "occupiedFour";
            }
        } else {
            return "square"
        }
    }

    function occSquareOne(fieldIndex) {
        if (newBoard.field[fieldIndex].occupied) {
            if (newBoard.playerOne.pawnList.includes(fieldIndex)) {
                return "occupiedOne";
            } else if (newBoard.playerTwo.pawnList.includes(fieldIndex)) {
                return "occupiedTwo";
            } else if (newBoard.playerThree.pawnList.includes(fieldIndex)) {
                return "occupiedThree";
            } else if (newBoard.playerFour.pawnList.includes(fieldIndex)) {
                return "occupiedFour";
            }
        } else {
            return "startSquareOne"
        }
    }

    function occSquareTwo(fieldIndex) {
        if (newBoard.field[fieldIndex].occupied) {
            if (newBoard.playerOne.pawnList.includes(fieldIndex)) {
                return "occupiedOne";
            } else if (newBoard.playerTwo.pawnList.includes(fieldIndex)) {
                return "occupiedTwo";
            } else if (newBoard.playerThree.pawnList.includes(fieldIndex)) {
                return "occupiedThree";
            } else if (newBoard.playerFour.pawnList.includes(fieldIndex)) {
                return "occupiedFour";
            }
        } else {
            return "startSquareTwo"
        }
    }

    function occSquareThree(fieldIndex) {
        if (newBoard.field[fieldIndex].occupied) {
            if (newBoard.playerOne.pawnList.includes(fieldIndex)) {
                return "occupiedOne";
            } else if (newBoard.playerTwo.pawnList.includes(fieldIndex)) {
                return "occupiedTwo";
            } else if (newBoard.playerThree.pawnList.includes(fieldIndex)) {
                return "occupiedThree";
            } else if (newBoard.playerFour.pawnList.includes(fieldIndex)) {
                return "occupiedFour";
            }
        } else {
            return "startSquareThree"
        }
    }

    function occSquareFour(fieldIndex) {
        if (newBoard.field[fieldIndex].occupied) {
            if (newBoard.playerOne.pawnList.includes(fieldIndex)) {
                return "occupiedOne";
            } else if (newBoard.playerTwo.pawnList.includes(fieldIndex)) {
                return "occupiedTwo";
            } else if (newBoard.playerThree.pawnList.includes(fieldIndex)) {
                return "occupiedThree";
            } else if (newBoard.playerFour.pawnList.includes(fieldIndex)) {
                return "occupiedFour";
            }
        } else {
            return "startSquareFour"
        }
    }

    //These functions are needed to help the player move their pawns.
    function PawnOne() {
        if (activePlayer == "player one") {
            return Number(newBoard.playerOne.pawnList[0]) + 1;
        } else if (activePlayer == "player two") {
            return Number(newBoard.playerTwo.pawnList[0]) + 1;
        } else if (activePlayer == "player three") {
            return Number(newBoard.playerThree.pawnList[0]) + 1;
        } else if (activePlayer == "player four") {
            return Number(newBoard.playerFour.pawnList[0]) + 1;
        }
    }

    function PawnTwo() {
        if (activePlayer == "player one") {
            return Number(newBoard.playerOne.pawnList[1]) + 1;
        } else if (activePlayer == "player two") {
            return Number(newBoard.playerTwo.pawnList[1]) + 1;
        } else if (activePlayer == "player three") {
            return Number(newBoard.playerThree.pawnList[1]) + 1;
        } else if (activePlayer == "player four") {
            return Number(newBoard.playerFour.pawnList[1]) + 1;
        }
    }

    function PawnThree() {
        if (activePlayer == "player one") {
            return Number(newBoard.playerOne.pawnList[2]) + 1;
        } else if (activePlayer == "player two") {
            return Number(newBoard.playerTwo.pawnList[2]) + 1;
        } else if (activePlayer == "player three") {
            return Number(newBoard.playerThree.pawnList[2]) + 1;
        } else if (activePlayer == "player four") {
            return Number(newBoard.playerFour.pawnList[2]) + 1;
        }
    }

    function PawnFour() {
        if (activePlayer == "player one") {
            return Number(newBoard.playerOne.pawnList[3]) + 1;
        } else if (activePlayer == "player two") {
            return Number(newBoard.playerTwo.pawnList[3]) + 1;
        } else if (activePlayer == "player three") {
            return Number(newBoard.playerThree.pawnList[3]) + 1;
        } else if (activePlayer == "player four") {
            return Number(newBoard.playerFour.pawnList[3]) + 1;
        }
    }

    // This fuction declares the winner.
    if (gameStatus) {
        var winner = " ";
        if (gameStatus.gameStatus) {
            winner = "The winner is " + gameStatus.winner;
            alert(winner);
        }
    }

    // The layout of the board.
    return (
        <div>{newBoard ? (
            <div>
                <div className="controls">
                    <button className="startOver" onClick={() => StartLudo()}>Restart game</button>
                    <div className="dice"><img src={DiceImage()} /></div>
                    <button className="addPawn" onClick={() => PlacePawn()}>Place a pawn</button>
                    <button className="movePawn" onClick={() => MovePawn(1)}><img src={pawnPicture()} /><br></br>{PawnOne()} </button>
                    <button className="movePawn" onClick={() => MovePawn(2)}><img src={pawnPicture()} /><br></br>{PawnTwo()} </button>
                    <button className="movePawn" onClick={() => MovePawn(3)}><img src={pawnPicture()} /><br></br>{PawnThree()} </button>
                    <button className="movePawn" onClick={() => MovePawn(4)}><img src={pawnPicture()} /><br></br>{PawnFour()} </button>
                </div>

                <div className="controls">
                    <div className="scoreBoardOne">Score player one: {newBoard.playerOne.score}</div>
                    <div className="scoreBoardTwo">Score player two: {newBoard.playerTwo.score}</div>
                    <div className="scoreBoardThree">Score player three: {newBoard.playerThree.score}</div>
                    <div className="scoreBoardFour">Score player four: {newBoard.playerFour.score}</div>
                </div>

                <br></br>
                <br></br>

                <div className="box">
                    <div className={occSquareTwo(10)}>11</div>
                    <div className={occupiedSquare(11)} >12</div>
                    <div className={occupiedSquare(12)}>13</div>
                </div>

                <div className="box">
                    <div className={occupiedSquare(9)}>10</div>
                    <div className="filler"></div>
                    <div className={occupiedSquare(13)}>14</div>
                </div>

                <div className="box">
                    <div className={occupiedSquare(8)}>09</div>
                    <div className="filler"></div>
                    <div className={occupiedSquare(14)}>15</div>
                </div>

                <div className="box">
                    <div className={occupiedSquare(7)}>08</div>
                    <div className="filler"></div>
                    <div className={occupiedSquare(15)}>16</div>
                </div>

                <div className="box">
                    <div className={occupiedSquare(2)}>03</div>
                    <div className={occupiedSquare(3)}>04</div>
                    <div className={occupiedSquare(4)}>05</div>
                    <div className={occupiedSquare(5)}>06</div>
                    <div className={occupiedSquare(6)}>07</div>
                    <div className="filler"></div>
                    <div className="filler"></div>
                    <div className="filler"></div>
                    <div className={occupiedSquare(16)}>17</div>
                    <div className={occupiedSquare(17)}>18</div>
                    <div className={occupiedSquare(18)}>19</div>
                    <div className={occupiedSquare(19)}>20</div>
                    <div className={occSquareThree(20)}>21</div>
                </div>

                <div className="box">
                    <div className={occupiedSquare(1)}>02</div>
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
                    <div className={occupiedSquare(21)}>22</div>
                </div>

                <div className="box">
                    <div className={occSquareOne(0)}>01</div>
                    <div className={occupiedSquare(39)}>40</div>
                    <div className={occupiedSquare(38)}>39</div>
                    <div className={occupiedSquare(37)}>38</div>
                    <div className={occupiedSquare(36)}>37</div>
                    <div className="filler"></div>
                    <div className="filler"></div>
                    <div className="filler"></div>
                    <div className={occupiedSquare(26)}>27</div>
                    <div className={occupiedSquare(25)}>26</div>
                    <div className={occupiedSquare(24)}>25</div>
                    <div className={occupiedSquare(23)}>24</div>
                    <div className={occupiedSquare(22)}>23</div>
                </div>

                <div className="box">
                    <div className={occupiedSquare(35)}>36</div>
                    <div className="filler"></div>
                    <div className={occupiedSquare(27)}>28</div>
                </div>
                <div className="box">
                    <div className={occupiedSquare(34)}>35</div>
                    <div className="filler"></div>
                    <div className={occupiedSquare(28)}>29</div>
                </div>

                <div className="box">
                    <div className={occupiedSquare(33)}>34</div>
                    <div className="filler"></div>
                    <div className={occupiedSquare(29)}>30</div>
                </div>

                <div className="box">
                    <div className={occupiedSquare(32)}>33</div>
                    <div className={occupiedSquare(31)}>32</div>
                    <div className={occSquareFour(30)}>31</div>
                </div>
            </div>)

            : <div className="controls">
                <button className="startGame" onClick={() => StartLudo()}>Start a new game</button>
            </div>}
        </div>
    )
}