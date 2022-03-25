import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Header } from "./Header/Header";
import { Home } from "./Home/Home";
import { PlayLudo } from "./Ludo/Ludo";

export function App() {
    return (
        < Router >
            <div>
                <Header />
                <Home />
                <PlayLudo />
                <Routes>
                    <Route path='/' element={Home} />
                    <Route path='/PlayLudo' element={PlayLudo} />
                </Routes>
            </div>
        </Router >
    )

}
