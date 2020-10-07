import React, { Component } from 'react';
import { createBrowserHistory } from "history";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom"
import AdminNavigationBar from "./AdminNavigationBar"
import EmployeeList from "./EmployeeList"
import Employee from "./Employee"
import AdminProfile from "./Profile"
import Businesses from "./Businesses"
import AddEmployee from "./AddEmployee"
import RemoveEmployee from './RemoveEmployee';
import EditEmployee from './EditEmployee';
import AdminDashboard from './AdminDashboard';
import Bookings from './Bookings';


class Admin extends Component {
  render() {
    return (
      <div>
        <Router>
          <AdminNavigationBar/>
          <Switch>
            <Route exact path="/home" component={AdminDashboard}/>
            <Route exact path="/businesses" component={Businesses}/>
            <Route exact path="/profile" component={AdminProfile}/>
            <Route exact path="/employee/add" component={AddEmployee}/>
            <Route exact path="/employee/update/:employeeId" component={EditEmployee}/>
            <Route exact path="/employee/remove/:employeeId" component={RemoveEmployee}/>
            <Route exact path="/employee/:employeeId" component={Employee}/>
            <Route exact path="/employee-list" component={EmployeeList}/>
            <Route exact path="/bookings" component={Bookings}/>
          </Switch>
        </Router>
      </div>
    )
  }

}

export default Admin;
