import React, { Component } from "react"

class RemoveEmployee extends Component {
    constructor() {
        super()
        this.state = {}
        this.onClick = this.onClick.bind(this)
    }

    onClick() {
        // delete request
    }

    render() {
        return(
            <div>
                <h1>Remove an Employee</h1><hr></hr>
                <form>
                    <b>Enter an Employee ID: </b>
                    <input type="number"></input><br></br><br></br>
                    <button onClick={this.onClick} className="btn btn-primary">Remove Employee</button>
                </form>
            </div>
        )
    }
}
export default RemoveEmployee