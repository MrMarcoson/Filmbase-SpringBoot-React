import { useEffect, useState } from "react";
import { Container, Row } from "react-bootstrap";
import FilmsContainer from "./FilmsContainer"


const Search = () => {
  const [inf, setInf] = useState(-1);
  const [query, setQuery] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault()
    let str = event.target.title.value
    setQuery("title/" + str)
  }

  return (
      <Container className="searchBar">
        <h1 style={{textAlign: "center", margin: "2pc"}}> Search films </h1>
        
        <form onSubmit={handleSubmit}>
          <Row><input className="searchText" type="text" name="title" placeholder="Search by film title..."/></Row>
          <Row className="applyBtn"><button type="submit">Search</button></Row>
        </form>
        <FilmsContainer data={query}/>
      </Container>
    )
}

export default Search;