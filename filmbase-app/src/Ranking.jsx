import React, {  } from 'react';
import { Container } from "react-bootstrap";
import FilmsContainer from './FilmsContainer';

const Ranking = () => {
  return (
    <Container>
      <h1 style={{textAlign: "center", margin: "2pc"}}> Films </h1>
      <FilmsContainer data={"ranking/0"}/>
    </Container>
  )
}

export default Ranking;
