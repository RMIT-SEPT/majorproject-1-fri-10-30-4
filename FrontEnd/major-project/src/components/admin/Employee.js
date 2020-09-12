import React, { Component } from "react"
import "../../css/EmployeePage.css"
import "../../css/Loading.css"
const axios = require('axios').default;

class Employee extends Component {
    constructor(props){
        super(props)
        this.state = {
            employee: {},
            loading: true
        }
    }

    componentDidMount() {
        this.setState({loading: true})
        axios.get(`http://localhost:8080/employee/${this.props.match.params.userId}`)
        .then(response =>{
            const employeeData = response.data
            this.setState(
                prevState => { 
                    return {
                        employee: employeeData,
                        loading: !prevState.loading
                    }
                }
              )
        })
    }

    render() {
        const {employee } = this.state;
        const loading = () => {
            return (
                <div className="loader"></div>
            )
        }

        const getDetails = () => {
            return (
                <div>
                    <h1 className="title ">Employee Details</h1><hr></hr>
                    <div className="main">
                        <div className="row">
                            <div className="column">
                                <p><b>First Name</b>:</p>
                            </div>
                            <div className="column">
                                <p>{employee.firstName}</p>
                            </div>
                        </div>
                        <div className="row">
                            <div className="column">
                                <p><b>Last Name:</b></p>
                            </div>
                            <div className="column">
                                <p>{employee.lastName}</p>
                            </div>
                        </div>
                        <div className="row">
                            <div className="column">
                                <p><b>Email:</b></p>
                            </div>
                            <div className="column">
                                <p>{employee.email}</p>
                            </div>
                        </div>
                        <div className="row">
                            <div className="column">
                                <p><b>Phone Number:</b></p>
                            </div>
                            <div className="column">
                                <p>{employee.phoneNumber}</p>
                            </div>
                        </div>
                    </div>
                </div>
            )
        }
        const renderPage = this.state.loading ? loading() : getDetails()


        return (
            <div>
                {renderPage}
            </div>
        )
    }
}
export default Employee