import React, { Component } from 'react';

import {BrowserRouter as Router, Route} from "react-router-dom"
import Home from "../Home"
import AdminNavigationBar from "./AdminNavigationBar"
import EmployeeList from "./EmployeeList"
import Employee from "./Employee"
import AdminProfile from "./Profile"
import Businesses from "./Businesses"


class Admin extends Component {
  render() {
    return (
      <div>
        <Router>
          <AdminNavigationBar/>
          <Route exact path="/" component={Home}/>
          <Route exact path="/employee-list" component={EmployeeList}/>
          <Route exact path="/employee/:userId" component={Employee}/>
          <Route exact path="/businesses" component={Businesses}/>
          <Route exact path="/profile" component={AdminProfile}/>
        </Router>
      </div>
    )
  }

}

export default Admin;
