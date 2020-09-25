import React, { Component } from "react"
import RegistrationForm from "./RegistrationForm"

const axios = require('axios').default;

class Registration extends Component {
    constructor() {
        super()
        this.state = {
            firstName: "",
            lastName: "",
            address:"",
            phoneNumber: "",
            email:"",
            passwordHash: "",
            confirmPassword: "",

            // For error handling
            message: ""
        }
        this.onChange = this.onChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
        
    }

    onChange(event) {
      const {name, value} = event.target
      this.setState({[name]: value})
    }

    onSubmit(event) {
      this.setState({message: "Loading..."})
      const customer = {
        firstName: this.state.firstName,
        lastName: this.state.lastName,
        address: this.state.address,
        phoneNumber: this.state.phoneNumber,
        email: this.state.email,
        passwordHash: this.state.passwordHash,
        confirmPassword: this.state.confirmPassword,
      }

      const data = JSON.stringify(customer);
      const config = {
          headers: {'Content-Type': 'application/json'}
      }

      async function sendRequest(data, config) {
        const response = await axios.post("http://localhost:8080/customer/register", data, config)
        return response
      }
    
      sendRequest(data, config).then(
          this.setState({message: "Success!"})
      )
      
      // if(this.state.passwordHash !== this.state.confirmPassword) {
      //   //event.preventDefault();
      //     this.setState({
      //       passwordHash: "",
      //       confirmPassword: "",
      //       message:"Error: Passwords don't match!"
      //     })
      // } else {
          
      // }
    }

    render() {
        return(
          <div>
              <RegistrationForm 
                onChange={this.onChange}
                onSubmit={this.onSubmit}
                data={this.state}
              />
          </div>
         
        )
    }
}

export default Registration