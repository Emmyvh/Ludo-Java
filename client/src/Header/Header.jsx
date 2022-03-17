import React from "react";
import { Link } from "react-router-dom";
import "./Header.css";

export function Header() {
    return (
        <header className="header">
            <div>Ludo</div>
            <div className="navigation">
                <Link to="/">Start Game</Link>
            </div>
        </header>)
}