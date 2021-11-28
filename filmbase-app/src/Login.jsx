import React, { useContext } from "react"
import { Container, Row } from "react-bootstrap"
import { UserContext } from "./UserContext"
import axios from "axios"

const Login = () => {
    const value = useContext(UserContext);

    const handleSubmit = (event) => {
        axios.get("http://localhost:8080/api/user/" + event.target.login.value + "/" + event.target.password.value)
            .then(res => {
                value.setUser(res.data)
            })
            .catch(err => {
              console.log(err)
            })
    }

    return (
        <Container fluid>
            <h1 style={{textAlign: "center", margin: "2pc"}}>Welcome to Filmbase</h1>
            <h1>{value.user}</h1>
            <div className="loginWindow">
                <form className="loginForm">
                    <p>Login</p>
                    <input type="text" name="login"/>
                    <p>Password</p>
                    <input type="password" name="password"/>
                    <Row className="applyBtn"><button type="Login" onClick={handleSubmit}>Search</button></Row>
                </form>
            </div>
        </Container>
    )
}

export default Login;