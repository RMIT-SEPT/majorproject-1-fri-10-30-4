import React, { Component } from 'react';
import {BrowserRouter as Router, Route, BrowserRouter, Switch} from "react-router-dom"
import Admin from "./components/admin/Admin"
import Login from "./components/user/Login"
import Registration from "./components/user/Registration"

class App extends Component {
  constructor(){
    super()
    this.state = {
      adminLoggedIn: true
    };
  }

  
  render() {
    const renderLogin = () => {
    if(this.state.adminLoggedIn){
      return (
        <div>
          <Router>
          <Admin />
          </Router>
        </div>
      )
    } else {
        return (
          <div>
            <BrowserRouter> 
              <Switch>
                <Route exact path="/login" component={Login}/>
                <Route exact path="/registration" component={Registration}/>
              </Switch>
            </BrowserRouter>
          </div>
        )
      }
    }

    return (
      <div>
        {renderLogin()}
      </div>
      
    )
  }
}

export default App;
