import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Header } from "./Header/Header";
import { StartLudo } from "./Ludo/Ludo";

export function App() {
    return (
        <Router>{ }
            <Header />

            <div className="page">
                { }
                <Routes>
                    <Route path="/">
                        <StartLudo />
                    </Route>
                </Routes>
            </div>
        </Router>
    )
}