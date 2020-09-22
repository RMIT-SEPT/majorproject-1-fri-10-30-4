import React, { Component } from "react"
import "../../css/EmployeeForm.css"
import EditEmployeeComponent from "./EditEmployeeComponent"
import "../../css/Loading.css"
import { Jumbotron } from "react-bootstrap";
// import { NavLink } from 'react-router-dom';
const axios = require('axios').default;


class EditEmployee extends Component {
    constructor(props) {
        super(props)
        this.state = {

            employeeId: this.props.match.params.employeeId,
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
            
            updated: false,
            loading: false

        }
        this.onSubmit = this.onSubmit.bind(this)
        this.onChange = this.onChange.bind(this)
        this.loadData = this.loadData.bind(this)
      
    }

    loadData() {
        const id = this.state.employeeId
        this.setState({loading: true})
        async function getData() {
           const response = await axios.get(`http://localhost:8080/employee/${id}`)
            return response 
        }
        getData().then(response =>{
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

        async function update(data, config) {
            const response = await axios.put("http://localhost:8080/employee/update", data, config)
            return response
        }
       
        update(data, config).then(
            this.loadData(),
            this.setState({updated: true})
        )
        
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
        const updatedMessage = () => {
            return (
                <div>
                    <Jumbotron>
                    <h5 className="display-5 submitted-label">
                        Changes Submitted.
                    </h5>
                    </Jumbotron>
                </div>
            )
        }
        let renderPage;
        if(this.state.updated){
             renderPage = this.state.loading ? loading() : updatedMessage()
        } else {
             renderPage =  this.state.loading ? loading() : editEmployeeComponent()
        }
       
        return(
           renderPage
        )
    }
}
export default EditEmployee