import React from 'react'
import {NavLink} from 'react-router-dom'
import '../../css/AdminDashboard.css'

function AdminDashboard() {
    return (
        <div>
            <h1 className="dashboard-title">Admin Dashboard</h1>
            <hr/>
            <div className="container block-glass">
                    <div className="comps">
                        <label>Employees</label>
                        <NavLink to="/employee/add">
                            <button>Add</button>
                        </NavLink>
                        <NavLink to="/employee-list">
                            <button>View / Edit / Remove</button>
                        </NavLink>
                    </div>
                    <div className="comps">
                        <NavLink to="/profile">
                                <button>Profile</button>
                        </NavLink>
                    </div>

                    {/*
                    <div className="comps">
                        <label>Bookings</label>
                        <button>Add</button>
                        <button>View</button>
                    </div>
                    <div className="comps">
                        <label>Workers' Availabilities</label>
                        <button>View all</button>
                    </div>
                    */}
            </div>
        </div>
    )
}

export default AdminDashboard