import React, { Component } from "react"
import {BrowserRouter as Router, Route, Switch} from "react-router-dom"

import CustomerNavigationBar from "./CustomerNavigationBar"
import Home from "../Home"
import CustomerProfile from "./Profile"

class Customer extends Component {
    render() {
        return (
            <div>
                <Router>
                    <CustomerNavigationBar />
                    <Switch>
                        <Route exact path="/" component={Home}/>
                        <Route exact path="/profile" component={CustomerProfile}/>
                    </Switch>
                </Router>
            </div>
        )
    }
}

export default Customer