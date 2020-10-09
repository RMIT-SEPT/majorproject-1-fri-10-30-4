import React, { Component } from 'react';
import {BrowserRouter as Router, Route, BrowserRouter, Switch} from "react-router-dom"
import { Redirect } from "react-router-dom"
import Admin from "./components/admin/Admin"
import Customer from "./components/customer/Customer"
import Login from "./components/user/Login"
import Registration from "./components/user/Registration"
import { connect } from "react-redux"


class LoginHandler extends Component {
    constructor(props) {
        super(props)
        this.state = {
            adminLoggedIn: false,
            customerLoggedIn: true,
        }
    }

    render() {
        const CUSTOMER = "CUSTOMER"
        const ADMIN = "ADMIN"
        const {accountType} = this.props.user
        const renderLogin = () => {
            if(accountType === ADMIN){
            return (
                <div>
                    <Admin />
                </div>
                  
                )
            } else if (accountType === CUSTOMER) {
            return (
                <div>
                    
                    <Customer />
                </div>
                )
            } else {
                return (
                <div>
                    <BrowserRouter> 
                    <Switch>
                        <Redirect exact from="/" to="/login" />
                        <Route exact path="/login" component={Login}/>
                        <Route exact path="/registration" component={Registration}/>
                    </Switch>
                    </BrowserRouter>
                </div>
                )
            }
        }
        return (
            renderLogin()
        );
    }
}


const mapStateToProps = state=>({
    user: state.security.user
})
export default connect(mapStateToProps)(LoginHandler);