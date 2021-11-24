import { useEffect, useState } from "react";
import { Container, Row, Col } from "react-bootstrap";
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
      <Container>
        <h1 style={{textAlign: "center", margin: "2pc"}}> Search films </h1>
        
        <form onSubmit={handleSubmit}>
          <input type="text" name="title" placeholder="Title" />
          <input type="text" name="date" placeholder="date" />
        <button type="submit" onClick={() => setInf(0)}/>
      </form>
        <FilmsContainer data={query}/>
      </Container>
    )
}

export default Search;