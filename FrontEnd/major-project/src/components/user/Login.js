import React, { Component } from "react"
import LoginForm from "./LoginForm"
import { connect } from "react-redux"
import  { login }   from "../../actions/securityActions"
// const axios = require('axios').default;

class Login extends Component {
    constructor(props) {
        super(props)
        this.state = {
            username: "",
            password: "",
            message: "",
            response: "",
        }
        this.onChange = this.onChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
    }

    onChange(event) {
        const {name, value} = event.target
        this.setState({[name]: value})
    }

    onSubmit(event) {
        event.preventDefault()
        this.setState({message: "Loading..."})
        const loginRequest = {
            username: this.state.username,
            password: this.state.password,
        }
        console.log("hello")
        this.props.login(loginRequest)
    }

    render() {
        return (
            <div className="container">
                <LoginForm 
                    onChange={this.onChange}
                    onSubmit={this.onSubmit}
                    data={this.state}
                />
            </div>
        ) 
    }
}

export default connect(null, {login})(Login);