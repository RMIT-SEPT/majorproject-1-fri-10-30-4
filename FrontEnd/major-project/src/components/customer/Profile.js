import React, { Component } from "react"

class Profile extends Component {
    constructor(props) {
        super(props)
        this.state = {
            customer: {
                phoneNumber: "0400 123 123",
                address: "1 Abc St, Abc VIC 3000"
            }
        }
    }
    
    render() {
        const customer = this.state.customer

        return (
            <div>
                <h1>Your Profile</h1>
                <p>Phone number: {customer.phoneNumber}</p>
                <p>Address: {customer.address}</p>
            </div>
        )
    }
}

export default Profile