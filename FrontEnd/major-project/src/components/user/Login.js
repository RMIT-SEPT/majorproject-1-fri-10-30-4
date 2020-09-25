import React, { Component } from "react"
import LoginForm from "./LoginForm"
const axios = require('axios').default;
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

    onSubmit() {
        this.setState({message: "Loading..."})
        const loginRequest = {
            username: this.state.username,
            password: this.state.password,
        }
    
        const data = JSON.stringify(loginRequest);
        const config = {
            headers: {'Content-Type': 'application/json'}
        }
    
        async function sendRequest(data, config) {
            const response = await axios.post("http://localhost:8080/customer/login", data, config)
            return response
        }
        
       sendRequest(data, config).then(
            this.setState({message: "Success!"}),
            // this.props.history.push('/')
            // this.props.
           )
    }

    render() {
   
        return (
            <div className="login-form-block">
                <LoginForm 
                    onChange={this.onChange}
                    onSubmit={this.onSubmit}
                    data={this.state}
                />
            </div>
        ) 
    }
}

export default Login