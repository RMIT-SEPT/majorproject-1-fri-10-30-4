import React, {Component} from "react"
import "../../css/EditEmployeeResult.css"
import {NavLink} from 'react-router-dom'
import { Jumbotron } from "react-bootstrap"

class EditEmployeeResult extends Component {
    constructor() {
        super()
        this.state = {}
    }
    render() {
        return (
            <div className="">
                <Jumbotron className="update-success jumbotron text-center">
                    <h5 className="display-5">Changes Submitted</h5>
                    <hr></hr>
                    <NavLink to="/employee-list">
                        <button className="btn btn-success">See Employees</button>
                    </NavLink>
                </Jumbotron>
                
            </div>
        )
    }
}

export default EditEmployeeResult