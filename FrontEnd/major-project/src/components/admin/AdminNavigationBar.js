import React, { Component } from "react"
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav';
import Button from 'react-bootstrap/Button';
import {NavLink} from 'react-router-dom'
import "../../css/NavigationBar.css"

class NavigationBar extends Component {
  // if admin is logged in render this:
    render() {
        return (
          <Navbar bg="dark" variant="dark">
            <NavLink to="/">
              <img 
                src={require("../../img/logo.png")} alt="logo"
                className="logo"
                ></img>
            </NavLink>
            <Nav className="mr-auto">
              <NavLink to="/" className="navbar-element-style">Home</NavLink>
              <NavLink to="/employee-list" className="navbar-element-style">Employees</NavLink>
              <NavLink to="/businesses" className="navbar-element-style">Business</NavLink>
              <NavLink to="/profile" className="navbar-element-style">Profile</NavLink>
            </Nav>
              <NavLink to="/login" className="navbar-element-style"><Button>Log out</Button></NavLink>
          </Navbar>
        )
    }
}

export default NavigationBar