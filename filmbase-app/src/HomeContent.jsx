import { Container, Row, Col } from "react-bootstrap";
import { Link } from "react-router-dom";

const HomeContent = () => {
  return (
    <Container fluid>
      <Row>
        <Col className="colFilms"><Link to="/films">FILMS</Link></Col>
        <Col className="colActors"><Link to="/actors">ACTORS</Link></Col>
      </Row>
    </Container>
  )
}

export default HomeContent;