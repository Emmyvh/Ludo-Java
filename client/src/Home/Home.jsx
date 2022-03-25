import React, { useState } from "react";
import "./Home.css";

export function Home() {

    return (
        <div>
            <div className="homeAround">
                <div className="homeTop">Welcome to Ludo</div>
                <div className="homeBottom">Ludo is a boardgame you can play with four players.</div>
                <div className="homeBottom">Each player receives four pawns they can place on the board.</div>
                <div className="homeBottom">Each player starts in their own corner of the board and has their own color.</div>
                <div className="homeBottom">To place a new pawn click on the new pawn button in the control bar.</div>
                <div className="homeBottom">When you want to move a pawn click on its move button.</div>
                <div className="homeBottom">A dice will roll and the pawn will move the rolled number of steps.</div>
                <div className="homeBottom">If the dice rolls six you can move again.</div>
                <div className="homeBottom">If it rolls another number the next player gets to place and move a pawn.</div>
                <div className="homeBottom">If a pawn lands on a square that is already occupied the old pawn is removed.</div>
                <div className="homeBottom">Each time a pawn completes a complete round around the board, its player gets a point.</div>
                <div className="homeBottom">The first player who has four points wins.</div>
            </div>
        </div>
    )
}
