import React, { Component, useEffect, useState, initialState } from "react";
import { Container, Row, Col } from "react-bootstrap";
import { useParams } from "react-router-dom";
import axios from 'axios'

function FilmDiv(props) {
    return (
        <Container fluid>
            <Row>
              <Col sm = {4}>IMG</Col>
              <Col sm = {8}>{props.data.title}</Col>
            </Row>
            <Row>{props.data.avgGrade}</Row>
            <Row>{props.data.premiereDate}</Row>
            <Row>{props.data.description}</Row>
        </Container>
    )
  }

//singular film rendering
function Film() {
  const [list, setList] = useState(Object);

  const { id } = useParams();
  
  useEffect(() => { 
    axios.get("http://localhost:8080/api/film/" + id)
    .then(res => {
      console.log(res.data)
      setList(res.data)
    })
    .catch(err => {
      console.log(err)
    })
  }, [setList]);

  useEffect(() => {
    console.log({ list });
  }, [list]);
  
  return (
    <FilmDiv key={0} data={list}/>
  )
}

export default Film;
