import { Container, Navbar, Nav } from "react-bootstrap";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Films from "./Films.jsx";
import Actors from "./Actors.jsx";
import HomeContent from "./HomeContent.jsx";
import Film from "./Film.jsx";

const NavigationBar = () => {
    return (
    <Router>
        <Navbar bg="dark" variant="dark">
            <Container fluid>
                <Nav.Link as={Link} to="/">Home</Nav.Link>
                <Nav.Link as={Link} to="/films">Films</Nav.Link>
                <Nav.Link as={Link} to="/actors">Actors</Nav.Link>
            </Container>
        </Navbar>

        <Routes>
            <Route exact path="/" element={ <HomeContent/> } />
            <Route exact path="/films" element={ <Films/> } />
            <Route exact path="/actors" element={ <Actors/> } />
            <Route path="/film/:id" element={ <Film /> } />
        </Routes>
    </Router>
    )
}

export default NavigationBar