import React, { Component } from "react"
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'
import Button from 'react-bootstrap/Button'
import { NavLink } from 'react-router-dom'
import "../../css/NavigationBar.css"

class NavigationBar extends Component {
    constructor(){
        super()
        this.goToLogin = this.goToLogin.bind(this)
    }
    goToLogin() {
        window.location.href = "http://localhost:3000/login"
    }
    render() {
        return (
            <Navbar bg="dark" variant="dark">
                <NavLink to="/home">
                    <img
                        src={require("../../img/logo.png")} alt="logo"
                        className="logo"
                    ></img>
                </NavLink>
                <Nav className="mr-auto">
                    <NavLink to="/home" className="navbar-element-style">Home</NavLink>
                    <NavLink to="/profile" className="navbar-element-style">Profile</NavLink>
                    <NavLink to="/booking" className="navbar-element-style">Bookings</NavLink>
                </Nav>
                <Button onClick={this.goToLogin}>Log out</Button>
            </Navbar>
        )
    }
}

export default NavigationBar