import React, { Component } from "react"
import "../../css/AddEmployeeForm.css"
import EditEmployeeComponent from "./EditEmployeeComponent"
import "../../css/Loading.css"
//import { Redirect } from 'react-router-dom';
const axios = require('axios').default;


class EditEmployee extends Component {
    constructor() {
        super()
        this.state = {

            employeeId: 0,
            businessId: 0, 
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
            
            success: false,
            loading: false

        }
        this.onSubmit = this.onSubmit.bind(this)
        this.onChange = this.onChange.bind(this)
        this.loadData = this.loadData.bind(this)
      
    }

    loadData() {
        this.setState({loading: true})
        axios.get(`http://localhost:8080/employee/${this.props.match.params.employeeId}`)
        .then(response =>{
            const employeeData= response.data
            this.setState(
                prevState => { 
                    return {
                        loading: !prevState.loading,
                        
                        employeeId: employeeData.employeeId,
                        businessId: employeeData.businessId, 
                        firstName: employeeData.firstName,
                        lastName: employeeData.lastName,
                        email: employeeData.email,
                        passwordHash: employeeData.passwordHash,
                        phoneNumber: employeeData.phoneNumber,
                        service: employeeData.service,

                        mondayTime: employeeData.mondayTime,
                        tuesdayTime: employeeData.tuesdayTime,
                        wednesdayTime: employeeData.wednesdayTime,
                        thursdayTime: employeeData.thursdayTime,
                        fridayTime: employeeData.fridayTime,
                        saturdayTime: employeeData.saturdayTime,
                        sundayTime: employeeData.sundayTime
                    }
                }
              )
        })
    }

    componentDidMount() {
       this.loadData()
    }

    onSubmit() {
        
        const employee = {
            employeeId: this.state.employeeId,
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
        axios.put("http://localhost:8080/employee/update", data, config)
        //this.props.history.push("/employee/update-result/" + this.state.employeeId)
        //this.props.history.push("/")
        this.loadData()
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
        const editEmployeeComponent = () => {
            return (
                <EditEmployeeComponent 
                    onSubmit={this.onSubmit} 
                    onChange={this.onChange} 
                    data={this.state}
                />
            )
        }
        const loading = () => {
            return (
                <div className="loader"></div>
            )
        }
        const renderPage = this.state.loading ? loading() : editEmployeeComponent()
        return(
           renderPage
        )
    }
}
export default EditEmployee