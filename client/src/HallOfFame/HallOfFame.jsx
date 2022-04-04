import React, { useState } from "react";
import "./HallOfFame.css";

export function HallOfFame() {

    const [newList, setList] = useState(undefined);

    async function HallOfFame() {
        try {
            const response = await fetch('/api/HallOfFame', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
            });

            if (response.ok) {
                const newList = await response.json()
                setList(newList)
            }

        } catch (error) {
            console.error(error.toString());
        }
    }


    return (
        <div>{newList ? (
            <div className="border">
                <div className="topper">Date, Time, Winner</div>
                <div className="text"> {newList[0]} </div>
                <div className="text"> {newList[1]} </div>
                <div className="text"> {newList[2]} </div>
                <div className="text"> {newList[3]} </div>
                <div className="text"> {newList[4]} </div>
                <div className="text"> {newList[5]} </div>
                <div className="text"> {newList[6]} </div>
                <div className="text"> {newList[7]} </div>
                <div className="text"> {newList[8]} </div>
                <div className="text"> {newList[9]} </div>
            </div>
        ) : (
            <div className="border">
                <button className="showFame" onClick={() => HallOfFame()}> Click here to see previous winners</button>

            </div>)}
        </div>
    )
}
