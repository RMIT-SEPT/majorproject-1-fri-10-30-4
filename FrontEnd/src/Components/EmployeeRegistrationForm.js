import React, {Component} from 'react';

class EmployeeRegistrationForm extends Component {
    // Like variables
    constructor(props){
        super(props)

        // Employee: change later when employee format in decided and connected to the backend
        this.state = {
            e_id :'',
            name : '',
            contact : ''
        }
    }

    handleUsernameChange = (event) => {
        this.setState({
            name: event.target.value
        })
    }

    handleSubmit = event =>{
        alert(`Sucessfully Registered: ${this.state.name} `)
    }
    
    render() {
        return (
            <form>
                <div>
                    <label>ID</label>
                    <input
                        type = "text"
                        value = {this.state.e_id}
                        onChange={this.handleUsernameChange}
                    />
                    <label>Name</label>
                    <input
                        type = "text"
                        value = {this.state.name}
                        onChange={this.handleUsernameChange}
                    />
                    <label>Contact</label>
                    <input
                        type = "text"
                        value = {this.state.contact}
                        onChange={this.handleUsernameChange}
                    />
                </div>
                <button type='submit'>Register</button>
            </form>
        );
    }

}

export default EmployeeRegistrationForm