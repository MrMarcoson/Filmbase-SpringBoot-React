import React, { Component, useEffect, useState, initialState } from "react";
import { Container, Row, Col, Image  } from "react-bootstrap";
import { useParams } from "react-router-dom";
import axios from 'axios'
import cassete from './casette.png';
import Grade from "./Grade";

const GradeHeader = (props) => {
  return (
      <div className="gradeHeader">
          <div className="circle"><p>{props.data}</p></div>
      </div>
  )
}

function FilmDiv(props) {
  return (
    <Container className="filmSelected">
      <h1 style={{textAlign: "center", margin: "2pc"}}> {props.data.title} </h1>
      <Row>
        <Col sm = {1}/>
        <Col sm = {4}><Image  src={cassete} fluid /></Col>
        <Col sm = {1}/>
        <Col>
            <Row> 
              <GradeHeader data={props.data.avgGrade}/> 
            </Row>

            <Row> 
              <Grade/> 
            </Row>
        </Col>
      </Row>
      <Row><h4 style={{ marginTop: "3vh"}}>Date of premiere: {props.data.premiereDate}</h4></Row>
      <Row>
        <div className="desc">
          {props.data.description}
        </div>
      </Row>
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
      setList(res.data)
    })
    .catch(err => {
      console.log(err)
    })
  }, [setList]);

  return (
    <FilmDiv data={list}/>
  )
}

export default Film;
