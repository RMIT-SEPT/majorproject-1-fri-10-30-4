import React, {Component} from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import HeaderComponent from './HeaderComponent.jsx'
import FooterComponent from './FooterComponent.jsx'
import ProfileComponent from './ProfileComponent.jsx'
import CalendarComponent from './CalendarComponent.jsx'
import EmployeeComponent from './EmployeeComponent.jsx'

class HomeComponent extends Component {
    render() {
        return (
            <div>
                <Router>
                    <>
                        <HeaderComponent/>
                        <Switch>
                            {/* <Route path="/Register" component={Register}/>
                            <Route path="/login" component={Login}/>
                            <AuthenticatedRoute path="/logout" component={Logout}/> */}
                            <Route path="/Workers" component={EmployeeComponent}/>
                            <Route path="/Profile" component={ProfileComponent}/>
                            <Route path="/Calendar" component={CalendarComponent}/>

                        </Switch>
                        {/*<FooterComponent/>*/}
                    </>
                </Router>
                
                {/*
                Some other potential components later
                <Route path="/Profile" component={ProfileComponent}/>
                <Route path="/Calendar" component={CalendarComponent}/>
                <LoginComponent/>
                <LogoutComponent/>
                <ErrorComponent/>
                <WelcomeComponent/>*/}
            </div>
        )
    }
}

export default HomeComponent