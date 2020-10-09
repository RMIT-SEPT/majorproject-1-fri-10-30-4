import React, { Component } from 'react';
import {NavLink} from 'react-router-dom'

class CustomerDashboard extends Component {
    render() {
        return (
            <div>
                 <h1 className="dashboard-title">Customer Dashboard</h1>
            <hr/>
            <div className="container block-glass">
                <br></br>
                    <div className="comps">
                        <NavLink to="/profile">
                                <button>Profile</button>
                        </NavLink>
                        <NavLink to="/booking">
                            <button>Bookings</button>
                        </NavLink>
                     
                    </div>
            </div>
            </div>
        );
    }
}

export default CustomerDashboard;