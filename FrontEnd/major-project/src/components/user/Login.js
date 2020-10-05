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
            error_username: "",
            error_password: "",
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
        const loginRequest = {
            username: this.state.username,
            password: this.state.password,
        }  
        this.props.login(loginRequest, this.props.history)
        this.setState({error_username: this.props.error.username})
        this.setState({error_password: this.props.error.password})
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
const mapStateToProps = state=>({
    error: state.error
})
export default connect(mapStateToProps, {login})(Login);