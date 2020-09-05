import React, { Component } from "react"
import EmployeeData from "../../data/EmployeesData"
import "../../css/EmployeeList.css"
import {NavLink} from 'react-router-dom'

class Employees extends Component {
    constructor() {
        super()
        this.state = {}
    }
    render() {
        /* Trying to link eack list item to an employee page (i.e Link to="/employee?{item.userId}") */
        const employees = EmployeeData.map(item => 
                            {return (
                            <NavLink to="/employee?">
                                <li>{item.firstName} {item.lastName}</li>
                            </NavLink>)
                            })
        return (
            <div>
                <h2 className="title">Employees</h2>
                <hr></hr>
                <div className="main">
                    <ul>
                        {employees}
                    </ul>
                </div>
            </div>

        )
    }
   
}
export default Employees