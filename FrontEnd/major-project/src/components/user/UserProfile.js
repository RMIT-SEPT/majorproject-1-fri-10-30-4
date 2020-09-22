import React, { Component } from "react"
import "../../css/UserProfile.css"

class Profile extends Component {
    constructor(props){
        super(props)
        this.state = {
            user: {},
            loading: true
        }
    }

    componentDidMount() {
        this.setState({loading: true})
        axios.get(`http://localhost:8080/user/${this.props.match.params.userId}`)
        .then(response =>{
            const userData = response.data
            this.setState(
                prevState => { 
                    return {
                        user: userData,
                        loading: !prevState.loading
                    }
                }
              )
        })
    }

    render() {
        const {user } = this.state;
        return(
            <div class="container">
                <div class="card">
                    <div class="card-bio">
                        <div class="img-wrapper">
                                <img src={require("../../img/default.png")} alt="person" class="imageProfile"></img>
                        </div>
                        <div class="person-info">
                            <h4>{user.userId}</h4>
                            <h4>{user.userFirstName}</h4>
                            <p>You can see your profile here !</p>
                            <p>This is your profile page yay</p>
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
                        <p>customer_email@gmail.com</p>

                        <h4>Phone:</h4>
                        <p>+61 012345678</p>
                        
                    </div>
                </div>
            </div>

        )
    }
}

export default Profile