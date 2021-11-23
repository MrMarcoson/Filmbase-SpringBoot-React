import React, { Component, useEffect, useState, initialState } from "react";
import { Row } from "react-bootstrap";
import { useParams } from "react-router-dom";
import axios from 'axios'

function FilmDiv(props) {
    return (
        <div>
            <Row>{props.data.avgGrade}</Row>
            <Row>{props.data.title}</Row>
            <Row>{props.data.premiereDate}</Row>
            <Row>{props.data.description}</Row>
        </div>
    )
  }

//singular film rendering
function Film() {
  const [list, setList] = useState([]);

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
    <div>
      { <FilmDiv key={0} data={list}/>}
      {/*
      Object.keys(list).map((item, i) => (
          <FilmDiv key={i} data={list}/>
      ))*/} 
    </div>
  )
}

export default Film;
