import React, { Component } from 'react';

import {BrowserRouter as Router, Route, Switch} from "react-router-dom"
import Home from "../Home"
import AdminNavigationBar from "./AdminNavigationBar"
import EmployeeList from "./EmployeeList"
import Employee from "./Employee"
import AdminProfile from "./Profile"
import Businesses from "./Businesses"
import AddEmployee from "./AddEmployee"
import RemoveEmployee from './RemoveEmployee';


class Admin extends Component {
  render() {
    return (
      <div>
        <Router>
          <AdminNavigationBar/>
          <Switch>
            <Route exact path="/" component={Home}/>
            <Route exact path="/businesses" component={Businesses}/>
            <Route exact path="/profile" component={AdminProfile}/>
            <Route exact path="/employee/add" component={AddEmployee}/>
            <Route exact path="/employee/remove" component={RemoveEmployee}/>
            <Route exact path="/employee/:userId" component={Employee}/>
            <Route exact path="/employee-list" component={EmployeeList}/>
          </Switch>
         
        </Router>
      </div>
    )
  }

}

export default Admin;
