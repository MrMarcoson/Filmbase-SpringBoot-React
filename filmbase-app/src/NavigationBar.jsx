import { Container, Navbar, Nav } from "react-bootstrap";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";


const NavigationBar = () => {
    return (
            <Navbar className="navbar-custom">
                    <Navbar.Brand as={Link} to="/">FILMBASE</Navbar.Brand>
                        <Container fluid className="justify-content-end">
                            <Nav.Link as={Link} to="/">Home</Nav.Link>
                            <Nav.Link as={Link} to="/ranking">Ranking</Nav.Link>
                            <Nav.Link as={Link} to="/search">Search</Nav.Link>
                            <Nav.Link as={Link} to="/login">Login</Nav.Link>
                    </Container>
            </Navbar>

    );
}

export default NavigationBar