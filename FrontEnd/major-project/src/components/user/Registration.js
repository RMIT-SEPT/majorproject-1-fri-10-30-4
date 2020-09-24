import React, { Component } from "react"
import RegistrationForm from "./RegistrationForm"

class Registration extends Component {
    constructor() {
        super()
        this.state = {
            firstName: "",
            lastName: "",
            username: "",
            email:"",
            address:"",
            phoneNumber: "",
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
      event.preventDefault();
        if(this.state.passwordHash !== this.state.confirmPassword) {
            this.setState({
              passwordHash: "",
              confirmPassword: "",
              message:"Error: Passwords don't match!"
            })
        } else {
          this.setState({
            message:"Success!"
          })
        }
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