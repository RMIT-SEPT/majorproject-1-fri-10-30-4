import React, { Component } from "react"
import "../../css/AdminProfile.css"

class Profile extends Component {
    constructor(props){
        super(props)
        this.state = {
            admin: {},
            loading: true
        }
    }

    componentDidMount() {
        // this.setState({loading: true})
        // axios.get(`http://localhost:8080/user/${this.props.match.params.userId}`)
        // .then(response =>{
        //     const adminData = response.data
        //     this.setState(
        //         prevState => { 
        //             return {
        //                 admin: adminData,
        //                 loading: !prevState.loading
        //             }
        //         }
        //       )
        // })
    }

    render() {
        const {admin } = this.state;
        return(
            <div class="profile-container">
                <div class="card">
                    <div class="card-bio">
                        <div class="img-wrapper">
                                <img src={require("../../img/default.png")} alt="person" class="imageProfile"></img>
                        </div>
                        <div class="person-info">
                            <h4>{admin.businessID}</h4>
                            <h4>{admin.name}</h4>
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

                        <h4>Phone:</h4>
                        <p>+61 012345678</p>
                        
                    </div>
                </div>
            </div>

        )
    }
}

export default Profile