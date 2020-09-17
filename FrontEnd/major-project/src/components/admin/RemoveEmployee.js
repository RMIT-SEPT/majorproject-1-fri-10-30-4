import React, { Component } from "react";
import {Jumbotron} from "react-bootstrap";
const axios = require('axios').default;

class RemoveEmployee extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employeeId: this.props.match.params.employeeId,
      removed: false
    };
    this.onClick = this.onClick.bind(this);
  }

  onClick() {
    if(this.state.employeeId !== 0){
      // delete request
      axios.delete(
          `http://localhost:8080/employee/remove?employeeId=${this.state.employeeId}`
      ).then( this.setState({removed: true}))
    }
  }

  onChange(event){
    const {value} = event.target;
    this.setState({employeeId: value});
  }

  render() {
    const removedMessage = () => {
        return (
            <div>
                <Jumbotron>
                <h5 className="display-5">
                    Employee Removed
                </h5>
                </Jumbotron>
            </div>
        )
    }

    const removeEmployee = () => {
      return (
        <div>
          <Jumbotron>
            <h1>Remove an Employee</h1>
            <hr></hr>
            <form>
            <b>Are you sure you want to remove Employee #{this.state.employeeId} ?</b>
              <br></br>
              <br></br>
                <button onClick={this.onClick} className="btn btn-primary">
                  Remove Employee
                </button>
            </form>
          </Jumbotron>
       
        </div>
      )
    }

    let renderPage;
    if(this.state.removed){
        renderPage = removedMessage()
    } else {
        renderPage =  removeEmployee()
    }
    return (
      renderPage
    )

  }
}
export default RemoveEmployee;
