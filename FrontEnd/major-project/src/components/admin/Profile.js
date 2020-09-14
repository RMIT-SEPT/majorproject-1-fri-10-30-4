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
                            <h4>1234</h4>
                            <h4>MY NAME</h4>
                            <p>Administrator</p>
                            <p>Working as an administrator for E-booking.</p>
                        </div>
                    </div>
                    <div class="card-myinfo">
                        <h3>My Information</h3>
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