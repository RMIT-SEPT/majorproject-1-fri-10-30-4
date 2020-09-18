import React, { Component } from "react";
import "../../css/Loading.css"
import {Jumbotron} from "react-bootstrap";
const axios = require('axios').default;

class RemoveEmployee extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employeeId: this.props.match.params.employeeId,
      removed: false,
      loading: false
    };
    this.onClick = this.onClick.bind(this);
  }

  componentDidMount() {
    this.setState({loading: false})
  }

  onClick() {
    this.setState({loading: true})
    const id = this.state.employeeId
    async function remove() {
      const response = await axios.delete(`http://localhost:8080/employee/remove?employeeId=${id}`)
      return response
    }
 
    if(this.state.employeeId !== 0){
      remove().then(
        this.setState({
              loading: false,
              removed: true
        }))
    }
  }

  render() {
    const loading = () => {
      return (
          <div className="loader"></div>
      )
    }
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
        renderPage = this.state.loading ? loading() : removedMessage()
    } else {
        renderPage =  removeEmployee()
    }

    return (
      renderPage
    )

  }
}
export default RemoveEmployee;
