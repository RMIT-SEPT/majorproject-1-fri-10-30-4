import React from "react"
import {NavLink} from "react-router-dom"
import "../../css/Login.css"
function Login() {
    return (
        <div className="App">
        <form id="form" class="form">
            <h1>Login </h1>
            <div class="comps">
            <label for="fname">Email</label>
            <input type="text" id="email" placeholder="Email" />
            </div>
            <div class="comps">
            <label for="password">Password</label>
            <input type="password" id="password" placeholder="Password" />
            </div>
            <button type="login">LOGIN</button>
            <br></br>
            <NavLink to="/registration">Click here to register</NavLink> 
        </form>
        </div>
    )
}

export default Login