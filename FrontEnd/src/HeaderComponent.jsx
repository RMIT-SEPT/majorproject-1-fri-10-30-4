import React, { Component } from 'react'
import { Link } from 'react-router-dom'


class Header extends Component {
    render() {
        // Get whether a user is logged in or not. 
        // REMEMBER: Change da SomeAuthethicationFunction to its name later 
        //const isUserLoggedIn = SomeAuthenthicationFunction.isUserLoggedIn();
        return (    
            <header>
                    <ul>
                        <li><Link to="/welcome/">Home</Link></li>
                        <li><Link to="/Calendar">Calendar</Link></li>
                        <li><Link to="/Workers">Workers</Link></li>
                        <li><Link to="/Profile">Profile</Link></li>
                        <li><Link to="/Login">Login</Link></li>
                        <li><Link to="/Logout">Logout</Link></li>
                        {/* <li><Link className="nav-link" to="/login">Login</Link></li>
                        <li><Link className="nav-link" to="/logout" onClick={}>Logout</Link></li> */}
                    </ul>
            </header>
        )
    }
}

export default Header