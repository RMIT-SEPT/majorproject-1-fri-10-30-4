import React, { Component } from "react"
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'
import Button from 'react-bootstrap/Button'
import { NavLink } from 'react-router-dom'
import "../../css/NavigationBar.css"

class NavigationBar extends Component {
    // if customer is logged in render this:
    render() {
        return (
            <Navbar className="navbar">
                <NavLink to="/" className="logo-container">
                    <img
                        src={require("../../img/logo.png")} alt="logo"
                        className="logo"
                    ></img>
                </NavLink>
                <Nav className="mr-auto">
                    <NavLink to="/" className="navbar-element-style">Home</NavLink>
                    <NavLink to="/profile" className="navbar-element-style">Profile</NavLink>
                    <NavLink to="/bookings" className="navbar-element-style">Bookings</NavLink>
                </Nav>
                <NavLink to="/login" className="navbar-element-style"><Button>Log out</Button></NavLink>
            </Navbar>
        )
    }
}

export default NavigationBar