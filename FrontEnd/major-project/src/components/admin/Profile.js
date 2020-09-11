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
            <div>
                <div className="top-half">
                    <div>
                        <img src="../../img/default_profilepic.png"/>

                    </div>
                    <div>
                        <h4>Admin ID</h4>
                        <h4>Admin Name</h4>
                        <h4>Admin Email</h4>
                    </div>
                </div>
            </div>

        )
    }
}

export default Profile