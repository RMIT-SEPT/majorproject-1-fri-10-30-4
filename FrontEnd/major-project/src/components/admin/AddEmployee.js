import React, { Component } from "react"
import "../../css/AddEmployeeForm.css"
import AddEmployeeComponent from "./AddEmployeeComponent"
const axios = require('axios').default;

class AddEmployee extends Component {
    constructor() {
        super()
        this.state = {
            businessId: 10, // Change to the businessId applicable to the business admin currently logged in.
            firstName: "",
            lastName: "",
            email:"",
            passwordHash:"",
            phoneNumber: "",
            service:"",

            mondayTime:"",
            tuesdayTime:"",
            wednesdayTime:"",
            thursdayTime:"",
            fridayTime:"",
            saturdayTime:"",
            sundayTime:"",

            error:""

        }
        this.onSubmit = this.onSubmit.bind(this)
        this.onChange = this.onChange.bind(this)
    }

    onSubmit() {
        const employee = {
            businessId: this.state.businessId,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email,
            passwordHash: this.state.passwordHash,
            phoneNumber: this.state.phoneNumber,
            service: this.state.service,

            mondayTime: this.state.mondayTime,
            tuesdayTime: this.state.tuesdayTime,
            wednesdayTime: this.state.wednesdayTime,
            thursdayTime: this.state.thursdayTime,
            fridayTime: this.state.fridayTime,
            saturdayTime: this.state.saturdayTime,
            sundayTime: this.state.sundayTime
        }

        const data = JSON.stringify(employee);
        const config = {
            headers: {'Content-Type': 'application/json'}
        }
        axios.post("http://localhost:8080/employee/create", data, config);
    }

    onChange(event) {
        const {name, value, type, checked} = event.target
        if(type === "checkbox"){
            this.setState({[name]: checked})
        } else {
            this.setState({[name]: value})
        }
    }w

    render() {
        return(
            <AddEmployeeComponent 
                onSubmit={this.onSubmit} 
                onChange={this.onChange} 
                data={this.state}
            />
        )
    }
}
export default AddEmployee