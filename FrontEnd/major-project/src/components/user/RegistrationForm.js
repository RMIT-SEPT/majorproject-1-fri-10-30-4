import React from "react"
import "../../css/Registration.css"
import {NavLink} from "react-router-dom"

function RegistrationForm(props){
    return (
        <div className="register-container">
            <h5>{props.data.message}</h5>
            <div className="container">
              <form id="form" className="form" onSubmit={props.onSubmit}>
                <h1>Register </h1>
                <div className="comps">
                  <label>First Name</label>
                  <input
                      onChange={props.onChange}
                      value={props.data.firstName}
                      name="firstName"
                      type="text" 
                      placeholder="Enter First Name" />
                  <small>Error </small>
                  <h4>{props.data.firstName}</h4>
                </div>
                <div className="comps">
                  <label>Last Name</label>
                  <input
                      onChange={props.onChange}
                      value={props.data.lastName}
                      name="lastName"
                      type="text" 
                      placeholder="Enter Last Name" />
                  <small>Error </small>
                </div>
                <div className="comps">
                  <label>Username</label>
                  <input
                      onChange={props.onChange}
                      value={props.data.username}
                      name="username"
                      type="text" 
                      placeholder="Enter username" />
                  <small>Error</small>
                </div>
                <div className="comps">
                  <label>Email</label>
                  <input
                      onChange={props.onChange}
                      value={props.data.email}
                      name="email"
                      type="text" 
                      placeholder="Enter email" />
                  <small>Error </small>
                </div>
                <div className="comps">
                  <label>Address</label>
                  <input
                      onChange={props.onChange}
                      value={props.data.address}
                      name="address"
                      type="text" 
                      placeholder="Enter address" />
                  <small>Error </small>
                </div>
                <div className="comps">
                  <label>Phone Number</label>
                  <input
                      onChange={props.onChange}
                      value={props.data.phoneNumber}
                      name="phoneNumber"
                      type="tel" 
                      placeholder="Enter phone number" />
                  <small>Error </small>
                </div>
                <div className="comps">
                  <label>Password</label>
                  <input
                      onChange={props.onChange}
                      value={props.data.passwordHash}
                      name="passwordHash"
                      type="password" 
                      placeholder="Enter password" />
                  <small>Error </small>
                </div>
                <div className="comps">
                  <label>Confirm Password</label>
                  <input
                      onChange={props.onChange}
                      value={props.data.confirmPassword}
                      name="confirmPassword"
                      type="password"
                      placeholder="Confirm password"
                  />
                  <small>Error </small>
                </div>
                <button type="submit">SUBMIT</button>
                <br></br>
                <NavLink to="/login">Already have an account? Click here to login.</NavLink> 
              </form>
            </div>
      </div>
    )
}

export default RegistrationForm