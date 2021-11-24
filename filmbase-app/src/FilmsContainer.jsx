import React, { Component, useState, useEffect } from 'react';
import { Container, Row, Col } from "react-bootstrap";
import { BrowserRouter, Routes, Route, Link , useParams } from "react-router-dom";
import Film from './Film';
import axios from "axios";
import cassete from './casette.png';
import { height } from 'dom-helpers';

const FilmsHeader = () => {
return (
    <Row>
        <Col>IMG</Col>
        <Col>GRADE</Col>
        <Col>TITLE</Col>
        <Col>PREMIERE</Col>
    </Row>
    )
}

const FilmDiv = (props) => {
return (
    <Link to={`/film/${props.data.id}`}>
    <Row className = "filmDiv">
        <Col className="filmInfo" ><img src={cassete} style={{width: "64px", height: "128px"}}/></Col>
        <Col className="filmInfo">{props.data.avgGrade}</Col>
        <Col className="filmInfo">{props.data.title}</Col>
        <Col className="filmInfo">{props.data.premiereDate}</Col>
    </Row>
    </Link>
    )
}

const FilmsContainer = (props) => {
    const [list, setList] = useState([]);

    useEffect(() => {
        console.log(props);
        axios.get("http://localhost:8080/api/film/" + props.data)
        .then(res => {
            console.log(res.data)
            setList(res.data)
            })
        .catch(err => {
            console.log(err)
        })
    }, [setList, props.data]);

    return (
        <div className="filmsContainer">
            {list.map(film => (<FilmDiv key={film.id} data={film} />))}
        </div>
        )
    }

export default FilmsContainer;