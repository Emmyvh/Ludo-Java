import React from "react";
import { Link } from "react-router-dom";
import "./Header.css";

export function Header() {
    return (
        <header className="header">
            <div>Ludo</div>
            <div className="navigation">
                <Link to="/">Home</Link>
                <Link to="/PlayLudo">Play Ludo</Link>
                <Link to="/HallOfFame"> Hall of fame</Link>
            </div>
        </header >)
}