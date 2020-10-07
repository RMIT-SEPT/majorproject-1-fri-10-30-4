import React, {Component} from 'react'
import '../../css/CustomerProfile.css'

class Profile extends Component {
    constructor(props) {
        super(props)
        this.state = {
            customer: {
                phoneNumber: '0400 123 123',
                address: '1 Abc St, Abc VIC 3000'
            }
        }
    }

    render() {
        const customer = this.state.customer

        return (
            <div className="customer-profile">
                <div className="details">
                    <div>
                        <img src={require('../../img/default.png')} alt="person"/>
                    </div>
                    <div className="person-info">
                        <p>Customer</p>
                    </div>
                </div>
                <div className="information">
                    <h3>My Information</h3>
                    <div className="person-socialInfo">
                        <p>Phone number: {customer.phoneNumber}</p>
                        <p>Address: {customer.address}</p>
                    </div>
                </div>
            </div>

        )
    }
}

export default Profile