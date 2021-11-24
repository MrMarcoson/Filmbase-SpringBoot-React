import { Container, Navbar, Nav } from "react-bootstrap";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import HomeContent from "./HomeContent.jsx";
import Film from "./Film.jsx";
import Ranking from "./Ranking.jsx";
import Search from "./Search.jsx";

const NavigationBar = () => {
    return (
    <Router>
        <Navbar className="navbar-custom">
                <Navbar.Brand as={Link} to="/">FILMBASE</Navbar.Brand>
                    <Container fluid className="justify-content-end">
                        <Nav.Link as={Link} to="/">Home</Nav.Link>
                        <Nav.Link as={Link} to="/ranking">Ranking</Nav.Link>
                        <Nav.Link as={Link} to="/search">Search</Nav.Link>
                </Container>
        </Navbar>

        <Routes>
            <Route exact path="/" element={ <HomeContent/> } />
            <Route exact path="/ranking" element={ <Ranking/> } />
            <Route exact path="/search" element={ <Search/> } />
            <Route path="/film/:id" element={ <Film /> } />
        </Routes>
    </Router>
    )
}

export default NavigationBar