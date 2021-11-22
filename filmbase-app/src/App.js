import { Component } from "react";
import { Container } from "react-bootstrap";

import NavigationBar from "./NavigationBar.jsx";

class App extends Component {
  render() {
    return (
      <Container fluid>
        <NavigationBar />
      </Container>
    )
  }
}

export default App;
