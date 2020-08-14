import React, { Component } from 'react'
import { Link } from 'react-router-dom'


class ProfileComponent extends Component {
    render() {
        // Get whether a user is logged in or not. 
        // REMEMBER: Change da SomeAuthethicationFunction to its name later 
        //const isUserLoggedIn = SomeAuthenthicationFunction.isUserLoggedIn();
        return (    
            <h1>Profile</h1>
        )
    }
}

export default ProfileComponent