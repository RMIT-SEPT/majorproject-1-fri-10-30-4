import React, { Component } from "react"
import {BrowserRouter as Router, Route, Switch} from "react-router-dom"
import { Redirect } from "react-router-dom"
import CustomerNavigationBar from "./CustomerNavigationBar"
import CustomerDashboard from "./CustomerDashboard"
import CustomerProfile from "./Profile"
import NewBooking from "../booking/NewBooking"
import BookingDashboard from "./BookingDashboard"
import Bookings from './Bookings';


class Customer extends Component {
    render() {
        return (
            <div>
                <Router>
                <Redirect to='/home' />
                    <CustomerNavigationBar />
                    <Switch>
                        <Route exact path="/home" component={CustomerDashboard}/>
                        <Route exact path="/profile" component={CustomerProfile}/>
                        <Route exact path="/booking" component={BookingDashboard}/>
                        <Route exact path="/bookings" component={Bookings}/>
                        <Route exact path="/booking/new" component={NewBooking}/>
                    </Switch>
                </Router>
            </div>
        )
    }
}

export default Customer