import React, { Component } from "react"
import "../../css/AdminProfile.css"

class Profile extends Component {
    constructor() {
        super()
        this.state = {
            
        }
    }

    render() {
        
        return(
            <div class="container">
                <div class="card">
                    <div class="card-bio">
                        <div class="img-wrapper">
                                <img src={require("../../img/default.png")} alt="person" class="imageProfile"></img>
                        </div>
                        <div class="person-info">
                            <h4>ID:</h4>
                            <h4>Name:</h4>
                            <p>Working as an administrator for E-booking.</p>
                            <p>Please contact me via email</p>
                        </div>
                    </div>
                    <div class="person-socialInfo">
                        <div class ="icon-wrapper">
                            <i class="envelope"></i>
                        </div>
                        <h4>Email:</h4>
                        <p>admin_email@gmail.com</p>
                        <span>></span>
                    </div>
                </div>
            </div>

        )
    }
}

export default Profile