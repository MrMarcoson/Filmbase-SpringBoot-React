import { Component } from "react";
import { Container } from "react-bootstrap";
import Footer from "./Footer.jsx";

import NavigationBar from "./NavigationBar.jsx";

class App extends Component {
  render() {
    return (
      <div>
        <NavigationBar />
        <Footer />
      </div>
    )
  }
}

export default App;
