import Footer from "./Footer.jsx";
import "./style.css";
import NavigationBar from "./NavigationBar.jsx";
import { UserContext } from "./UserContext.jsx";
import React, { useState, useMemo } from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import HomeContent from "./HomeContent.jsx";
import Film from "./Film.jsx";
import Ranking from "./Ranking.jsx";
import Search from "./Search.jsx";
import Login from "./Login.jsx";

const App = () => {
  const[user, setUser] = useState();
  const value = useMemo(() => ({ user, setUser }), [user, setUser]);

    return (
      <UserContext.Provider value={ value }>
        <div>
          <Router>
            <NavigationBar />            
            <Routes>
                    <Route exact path="/" element={ <HomeContent/> } />
                    <Route exact path="/ranking" element={ <Ranking/> } />
                    <Route exact path="/search" element={ <Search/> } />
                    <Route path="/film/:id" element={ <Film /> } />
                    <Route path="/login" element={ <Login /> } />
            </Routes>
          </Router>

            <Footer />
        </div>
      </UserContext.Provider>
    )
}

export default App;
