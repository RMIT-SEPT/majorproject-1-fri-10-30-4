import React from "react"
import {NavLink} from 'react-router-dom'
function BookingDashboard() {
    return (
        <div>
           <h1 className="dashboard-title">Let's Make A Booking!</h1>
            <hr/>
            <div className="container">
                <br></br>
                    <div className="comps">
                        <NavLink to="/booking/new">
                            <button>New Booking</button>
                        </NavLink>
                        <NavLink to="/bookings">
                            <button>View Bookings</button>
                        </NavLink>
                    </div>
            </div>
        </div>
    )
}

export default BookingDashboard