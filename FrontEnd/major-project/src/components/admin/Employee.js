import React, { Component } from "react"
const axios = require('axios').default;

class Employee extends Component {
    constructor(props){
        super(props)
        this.state = {
            employee: {},
            success: false
        }
    }

    componentDidMount() {
       // const { match: { params } } = this.props;
      
        axios.get(`http://localhost:8080/employee/${this.props.match.params.userId}`)
        .then(response => response.json())
          .then((data) => {
            this.setState(
                prevState => { 
                    return {
                        employee: data,
                        success: !prevState.success
                    }
                }
            );
        })
    }

    render() {
       const display = this.state.success ? "success" : "fail"
        return (
        <h1>{display}</h1>
        )
    }
}
export default Employee