import React, { Component } from "react"
import data from "../../data/EmployeesData"
const axios = require('axios').default;

class Employee extends Component {
    constructor(props){
        super(props)
        this.state = {
            employee: {}
        }
    }

    componentDidMount() {
        const { match: { params } } = this.props;
      
        axios.get(`/employee/${params.userId}`)
          .then((data) => {
            this.setState({ employee: data });
          });
      }

    render() {
        return (
            <h1>This is a Employee Component</h1>
        )
    }
}
export default Employee