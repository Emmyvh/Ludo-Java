import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Header } from "./Header/Header";
import { PlayLudo } from "./Ludo/Ludo";

export function App() {
    return (
        < Router >
            <div>
                <Header />
                <PlayLudo />
                <Routes>
                    <Route path='/' component={PlayLudo} />
                </Routes>
            </div>
        </Router >
    )

}
