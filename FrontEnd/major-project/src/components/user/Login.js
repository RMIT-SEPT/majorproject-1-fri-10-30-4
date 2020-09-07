import React from "react"
import {NavLink} from "react-router-dom"
import "../../css/Login.css"
function Login() {
    return (
        <div>
            <div className="title">
                <h1>Login </h1>
            </div>
            <form id="form" className="form">
            <hr></hr>
            <div className="form-group">
                <label for="email">Email</label>
                <input type="text" className="form-control" name="email" id="email" placeholder="Email"/>
            </div>
            <div className="form-group">
                <label for="password">Password</label>
                <input type="password" className="form-control" name="password" id="password" placeholder="Password"  />
            </div>
            <button type="login" className="btn btn-primary">LOGIN</button><br></br>
            <br></br>
            <NavLink to="/registration">Click here to register</NavLink> 
            </form>
      </div>
    )
}

export default Login