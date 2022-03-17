import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Header } from "./Header/Header";
import { StartLudo } from "./Ludo/Ludo";

export function App() {
    return (
        < Router >
            <div>
                <Header />
                <StartLudo />
                <Routes>
                    <Route path='/' component={StartLudo} />
                </Routes>
            </div>
        </Router >
    )

}
