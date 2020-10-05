import React, { Component } from 'react';
import {BrowserRouter as Router, Route, BrowserRouter, Switch} from "react-router-dom"
import Admin from "./components/admin/Admin"
import Customer from "./components/customer/Customer"
import Login from "./components/user/Login"
import Registration from "./components/user/Registration"
import { login } from "./actions/securityActions"
import { connect } from "react-redux"


class LoginHandler extends Component {
    constructor(props) {
        super(props)
        this.state = {
            adminLoggedIn: false,
            customerLoggedIn: false,
        }
    }

    render() {
        const renderLogin = () => {
            if(this.state.adminLoggedIn){
            return (
                    <Router>
                        <Admin />
                    </Router>
                )
            } else if (this.state.customerLoggedIn) {
            return (
                <Router>
                    <Customer />
                </Router>
                )
            } else {
                return (
                <BrowserRouter> 
                    <Switch>
                        <Route exact path="/login" component={Login}/>
                        <Route exact path="/registration" component={Registration}/>
                    </Switch>
                </BrowserRouter>
                )
            }
        }

        return (
            renderLogin()
        );
    }
}
const mapStateToProps = state=>({
    security: state.security.items
})
export default connect(mapStateToProps, { login })(LoginHandler);