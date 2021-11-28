import React, { useState, useEffect } from 'react';
import { Row, Col } from "react-bootstrap";
import { Link } from "react-router-dom";
import axios from "axios";
import cassete from './casette.png';

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

const Dumm = () => {
    return (
        <Link to={`/film/${0}`}>
        <Row className = "filmDiv">
            <Col className="filmInfo" ><img src={cassete} style={{width: "64px", height: "128px"}}/></Col>
            <Col className="filmInfo">{10}</Col>
            <Col className="filmInfo">{"xddd"}</Col>
            <Col className="filmInfo">{2000}</Col>
        </Row>
        </Link>
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