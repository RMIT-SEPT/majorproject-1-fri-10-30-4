import React, { Component } from "react"
import "../../css/EmployeeList.css"
import "../../css/Loading.css"
import {NavLink} from 'react-router-dom'
import { Jumbotron } from "react-bootstrap";
const axios = require('axios').default;
class EmployeeList extends Component {
    constructor() {
        super()
        this.state = {
            loading: true,
            employees: []
        }
    }

    componentDidMount() {
        this.setState({loading: true})
        axios.get(`http://localhost:8080/employee/all`)
        .then(response =>{
            const employeesList= response.data
            this.setState(
                prevState => { 
                    return {
                        employees: employeesList,
                        loading: !prevState.loading
                    }
                }
              )
        })
    }

    render() {
        const employees = this.state.employees.map(item => 
                            {return ( 
                                <Jumbotron className="jumbotron-container">
                                        <NavLink key={item.userId} to={"/employee/" + item.userId}>
                                            <p>{item.userFirstName} {item.userLastName}</p>
                                        </NavLink>
                                        <span>
                                        <button className="btn btn-primary employee-button">Edit</button>
                                        <button className="btn btn-danger employee-button">Remove</button>
                                        </span>
                                </Jumbotron >
                            
                            )})

        const loading = () => {
            return (
                <div className="loader"></div>
            )
        }
        const renderPage = this.state.loading ? loading() : employees
      
        return (
            <div>
                <div>
                    <h2 className="employee-title">Employees</h2>
                </div>
                <div className="buttons">
                    <NavLink to="/employee/add"><button className="btn btn-success add-employee-button">Add Employee</button></NavLink>
                </div>
                <hr></hr>
                <div className="employee">
                    <ul>
                        {renderPage}
                    </ul>
                </div>
            </div>

        )
    }
   
}
export default EmployeeList