import React, { Component } from "react"
import "../../css/EmployeeForm.css"
import AddEmployeeComponent from "./AddEmployeeComponent"
import {Jumbotron} from "react-bootstrap";

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
            services:[],

            mondayTime:"",
            tuesdayTime:"",
            wednesdayTime:"",
            thursdayTime:"",
            fridayTime:"",
            saturdayTime:"",
            sundayTime:"",


            added: false

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
            services: this.state.services,

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
        axios.post("http://localhost:8080/employee/create", data, config).then(this.setState({added:true}))
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
        let renderPage;
        const addEmployee = () => {
            return(
                <AddEmployeeComponent 
                    onSubmit={this.onSubmit} 
                    onChange={this.onChange} 
                    data={this.state}
                />
            )
        }
        const addedMessage = () => {
            return(
                <div>
                    <Jumbotron>
                    <h5 className="display-5">
                        Employee Added
                    </h5>
                    </Jumbotron>
                </div>
            )
        }

        if(this.state.added){
            renderPage = addedMessage()
        } else {
            renderPage = addEmployee()
        }

        return(
           renderPage
        )
    }
}
export default AddEmployee