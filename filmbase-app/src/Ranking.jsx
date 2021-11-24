import React, { Component, useState, useEffect } from 'react';
import { Container, Row, Col } from "react-bootstrap";
import { useParams } from "react-router-dom";
import FilmsContainer from './FilmsContainer';
import axios from "axios";
import cassete from './casette.png';
import { height } from 'dom-helpers';

//multiple films rendering in a list

const Ranking = () => {
  return (
    <Container>
      <h1 style={{textAlign: "center", margin: "2pc"}}> Films </h1>
      <FilmsContainer data={"ranking/0"}/>
    </Container>
  )
}

export default Ranking;
