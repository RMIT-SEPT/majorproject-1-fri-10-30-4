import React, { Component } from "react"
import "../../css/AddEmployeeForm.css"
import AddEmployeeComponent from "./AddEmployeeComponent"

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

            mondayTime:"12:00-15:00",
            tuesdayTime:"",
            wednesdayTime:"",
            thursdayTime:"",
            fridayTime:"",
            saturdayTime:"",
            sundayTime:""

        }
        this.onSubmit = this.onSubmit.bind(this)
        this.onChange = this.onChange.bind(this)
    }

    onSubmit() {

    }

    onChange(event) {
        const {name, value, type, checked} = event.target
        if(type === "checkbox"){
            this.setState({[name]: checked})
        } else {
            this.setState({[name]: value})
        }
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