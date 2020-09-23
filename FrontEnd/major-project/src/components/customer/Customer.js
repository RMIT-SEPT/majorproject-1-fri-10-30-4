import React, { Component } from "react"
import {BrowserRouter as Router, Route, Switch} from "react-router-dom"

import CustomerNavigationBar from "./CustomerNavigationBar"
import Home from "../Home"
import CustomerProfile from "./Profile"
import NewBooking from "../booking/NewBooking"
import BookingDashboard from "./BookingDashboard"

class Customer extends Component {
    render() {
        return (
            <div>
                <Router>
                    <CustomerNavigationBar />
                    <Switch>
                        <Route exact path="/" component={Home}/>
                        <Route exact path="/profile" component={CustomerProfile}/>
                        <Route exact path="/booking" component={BookingDashboard}/>
                        <Route exact path="/booking/new" component={NewBooking}/>
                    </Switch>
                </Router>
            </div>
        )
    }
}

export default Customer