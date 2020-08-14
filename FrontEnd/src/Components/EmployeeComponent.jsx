import React, {Component} from 'react';
import EmployeeRegistrationForm from './EmployeeRegistrationForm'

class EmployeeComponent extends Component {
    // Like variables
    state = {showForm:false}
    // This is just a simple form without any backend connection
    // REMEMBER: Change later to allow form to add new employee to database
    showForm = () => {
        return (
          <div> 
              <EmployeeRegistrationForm></EmployeeRegistrationForm>
           </div>
          );
      }
    render() {
        return (
            <div className='manage-app'>
                <h1>Employee Managment</h1>
                <button  onClick={() => this.setState({showForm: true}) }>Add New Employee</button>
                <button>Edit Employee</button>
                <button>Remove Employee</button>
                {this.state.showForm ? this.showForm() : null}
            </div>
        );
    }

}

export default EmployeeComponent