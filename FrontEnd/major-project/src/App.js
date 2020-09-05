import React from 'react';
import NavigationBar from "./components/NavigationBar"
import {BrowserRouter as Router, Route} from "react-router-dom"
import Home from "./components/Home"
import Employees from "./components/admin/Employees"

function App() {
  return (
    <div>
      <Router>
        <NavigationBar/>
        <Route exact path="/" component={Home}/>
        <Route exact path="/employees" component={Employees}/>
      </Router>
    </div>
  )
}

export default App;
