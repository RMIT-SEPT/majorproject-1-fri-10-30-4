import React, { Component } from "react"
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav';
//import FormControl from 'react-bootstrap/FormControl';
//import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

class NavigationBar extends Component {
    render() {
        return (
          <Navbar bg="dark" variant="dark">
          <Navbar.Brand href="/home">Vought</Navbar.Brand>
          <Nav className="mr-auto">
            <Nav.Link href="/home">Home</Nav.Link>
            <Nav.Link href="/booking">Employees</Nav.Link>
            <Nav.Link href="/businesses">Businesses</Nav.Link>
          </Nav>
            <Button href="/logout">Log out</Button>
          </Navbar>
        )
    }
}

export default NavigationBar