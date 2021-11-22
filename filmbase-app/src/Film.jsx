import React, {Component} from "react";
import { useParams } from "react-router-dom";

//todo fix this
//singular film rendering
function Film() {
    state = {
        film: []
    }
    let { id } = useParams();
    
    fetch("http://localhost:8080/api/film/" + id)
    .then(response => response.json())
    .then(data => this.setState({film: data}))
    
    return (
        <Row>{state.id}</Row>
    )
}

export default Film;
