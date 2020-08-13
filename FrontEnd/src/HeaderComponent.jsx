import React, { Component } from 'react'
import { Link } from 'react-router-dom'


class Header extends Component {
    render() {
        // Get whether a user is logged in or not. 
        // REMEMBER: Change da SomeAuthethicationFunction to its name later 
        //const isUserLoggedIn = SomeAuthenthicationFunction.isUserLoggedIn();
        return (    
            <header>
            
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"></link>
            
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

                <nav className="navbar navbar-expand-md navbar-dark bg-info">
                    <div className="navbar-brand">Online booking System</div>
                    <ul className="navbar-nav">
                        <li><Link className="nav-link" to="/welcome/">Home</Link></li>
                        <li><Link className="nav-link" to="/Calendar">Calendar</Link></li>
                        <li><Link className="nav-link" to="/Workers">Workers</Link></li>
                        <li><Link className="nav-link" to="/Profile">Profile</Link></li>
                    </ul>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        <li>Login</li>
                        <li>Logout</li>
                        {/* <li><Link className="nav-link" to="/login">Login</Link></li>
                        <li><Link className="nav-link" to="/logout" onClick={}>Logout</Link></li> */}
                    </ul>
                </nav>
            </header>
        )
    }
}

export default Header