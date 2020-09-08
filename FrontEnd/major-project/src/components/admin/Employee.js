import React, { Component } from "react"
const axios = require('axios').default;

// async function makeGetRequest() {
//     let res = await axios.get(`localhost:8080/employee/59`);
//     let data = res.data;
//     this.setState({employee: data})
// }

class Employee extends Component {
    constructor(props){
        super(props)
        this.state = {
            employee: {},
            success: false
        }
    }

    componentDidMount() {
        //makeGetRequest();
        axios.get(`http://localhost:8080/employee/${this.props.match.params.userId}`)
        .then(response => {
            this.setState(
                prevState => { 
                    return {
                        employee: response.data,
                        success: !prevState.success
                    }
                }
              )
        })
    }

    render() {
       const display = this.state.success ? "success" : "fail"
        return (
        <div>
            <h1>{display}</h1>
            <h2>{this.state.employee.userId}</h2>
        </div>
        )
    }
}
export default Employee