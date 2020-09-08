import React, { Component } from "react"
import "../../css/EmployeeList.css"
import "../../css/Loading.css"
import {NavLink} from 'react-router-dom'
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
                            <NavLink 
                                key={item.userId} 
                                to={"/employee/" + item.userId}>
                                <li>{item.userFirstName} {item.userLastName}</li>
                            </NavLink>
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
                    <h2 className="title">Employees</h2>
                </div>
                <div className="buttons">
                    <NavLink to="/employee/add"><button className="btn btn-success button">Add Employee</button></NavLink>
                    <NavLink to="/employee/remove"><button className="btn btn-danger button">Remove Employee</button></NavLink>
                </div>
                <hr></hr>
                <div className="main">
                    <ul>
                        {renderPage}
                    </ul>
                </div>
            </div>

        )
    }
   
}
export default EmployeeList