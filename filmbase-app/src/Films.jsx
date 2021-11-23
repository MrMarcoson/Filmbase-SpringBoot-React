import React, { Component } from 'react';
import { Container, Row, Col } from "react-bootstrap";
import { BrowserRouter, Routes, Route, Link , } from "react-router-dom";
import Film from './Film';

//multiple films rendering in a list

const FilmsHeader = () => {
  return (
    <Row>
      <Col>GRADE</Col>
      <Col>TITLE</Col>
      <Col>PREMIERE</Col>
      <Col>DESCRIPTION</Col>
    </Row>
  )
}

function FilmDiv(props) {
  return (
    <Link to={`/film/${props.data.id}`}>
      <Row>
          <Col>{props.data.avgGrade}</Col>
          <Col>{props.data.title}</Col>
          <Col>{props.data.premiereDate}</Col>
          <Col>{props.data.description}</Col>
      </Row>
    </Link>
  )
}

//fetching info from api, and rendering divs
class FilmsContainer extends Component{
  state = {
    list: []
  }

  componentDidMount() {
    fetch("http://localhost:8080/api/film/ranking/0")
    .then(response => response.json())
    .then(data => {
      this.setState({list: data})
    })
    .catch(rejected => {
      console.log(rejected);
    });
  }

  render() {  
    return (
      <div className="dataDiv">
        <FilmsHeader />
        {this.state.list.map(film => <FilmDiv key={film.id} data={film}/> )}    
      </div>
    )
  }
}

function Films() {
  return (
    <Container fluid>
      <h1>Films</h1>
      <FilmsContainer/>
    </Container>
  )
}

export default Films;
