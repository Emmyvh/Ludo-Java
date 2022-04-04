import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Header } from "./Header/Header";
import { Home } from "./Home/Home";
import { PlayLudo } from "./Ludo/Ludo";
import { HallOfFame } from "./HallOfFame/HallOfFame";

export function App() {
    return (
        < Router >
            <div>
                <Header />
                <Routes>
                    <Route exact path='/' element={<Home />} />
                    <Route path='/PlayLudo' element={<PlayLudo />} />
                    <Route path='/HallOfFame' element={<HallOfFame />} />
                </Routes>
            </div>
        </Router >
    )

}
