import React, { Component } from "react"
import "../../css/AddEmployeeForm.css"
import AddEmployeeComponent from "./AddEmployeeComponent"

class AddEmployee extends Component {
    constructor() {
        super()
        this.state = {
            firstName: "",
            lastName: "",
            email:"",
            password:"",
            phoneNumber: "",
            availability: "",
            services: {},
        }
        this.onSubmit = this.onSubmit.bind(this)
        this.onChange = this.onChange.bind(this)
    }

    onSubmit() {

    }

    onChange() {

    }

    render() {
        return(
            <AddEmployeeComponent 
                onClick={this.onSubmit} 
                onChange={this.onChange} 
                data={this.state}
            />
        )
    }
}
export default AddEmployee