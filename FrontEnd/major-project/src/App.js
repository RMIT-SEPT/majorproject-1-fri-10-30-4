import React from 'react';
import NavigationBar from "./components/NavigationBar"
import {BrowserRouter as Router, Route} from "react-router-dom"
import Home from "./components/Home"
import Employees from "./components/admin/Employees"
import AdminProfile from "./components/admin/Profile"
import Businesses from "./components/admin/Businesses"

function App() {
  return (
    <div>
      <Router>
        <NavigationBar/>
        <Route exact path="/" component={Home}/>
        <Route exact path="/employees" component={Employees}/>
        <Route exact path="/businesses" component={Businesses}/>
        <Route exact path="/profile" component={AdminProfile}/>
      </Router>
    </div>
  )
}

export default App;
