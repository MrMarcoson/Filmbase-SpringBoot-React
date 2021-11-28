import React, { useContext, useState } from "react"
import { Container, Row } from "react-bootstrap"
import { UserContext } from "./UserContext"
import axios from "axios"

const Login = () => {
    const value = useContext(UserContext);
    const[x, setX] = useState();

    const handleSubmit = async(event) => {
        try {
            //implementation of post and tokens should be implemented here
            const resp = axios.get("http://localhost:8080/api/user/" + event.target.login.value + "/" + event.target.password.value);
        }
        catch(err) {
            console.log(err);
        }
            
    }

    return (
        <Container fluid>
            <h1 style={{textAlign: "center", margin: "2pc"}}>Welcome to Filmbase {x}</h1>
            <div className="loginWindow">
                <form className="loginForm" onSubmit={handleSubmit}>
                    <p>Login</p>
                    <input type="text" name="login"/>
                    <p>Password</p>
                    <input type="password" name="password"/>
                    <Row className="applyBtn">
                        <button type="submit">Login</button>
                    </Row>
                </form>
            </div>
        </Container>
    )
}

export default Login;