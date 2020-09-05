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