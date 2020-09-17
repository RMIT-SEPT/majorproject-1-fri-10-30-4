import React, { Component } from "react";

class RemoveEmployee extends Component {
  constructor() {
    super();
    this.state = {
      employeeId: 0
    };
    this.onClick = this.onClick.bind(this);
  }

  onClick() {
    if(this.state.employeeId !== 0){
      // delete request
      axios.delete(
          `http://localhost:8080/employee/remove?employeeId=${this.state.employeeId}`
      );
    }
  }

  onChange(event){
    const {value} = event.target;
    this.setState({employeeId: value});
  }

  render() {
    return (
      <div>
        <h1>Remove an Employee</h1>
        <hr></hr>
        <form>
          <b>Enter an Employee ID: </b>
          <input type="number" name="employeeId" value={this.state.employeeId} onChange={this.onChange}></input>
          <br></br>
          <br></br>
          <button onClick={this.onClick} className="btn btn-primary">
            Remove Employee
          </button>
        </form>
      </div>
    );
  }
}
export default RemoveEmployee;
