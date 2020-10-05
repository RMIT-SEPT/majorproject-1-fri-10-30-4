import React from "react"
import {NavLink} from "react-router-dom"
import "../../css/Login.css"
function LoginForm(props) {
    return (
        <div className="">
        <form id="form" className="form" onSubmit={props.onSubmit}>
            <h1>Login </h1>
            <div className="comps">
            <label>Email</label>
            <input    
                onChange={props.onChange}
                value={props.data.username}
                type="text" 
                name="username" 
                placeholder="Email" />
            </div>
            <div className="comps">
            <label>Password</label>
            <input 
                onChange={props.onChange}
                value={props.data.password}
                type="password" 
                name="password" 
                placeholder="Password" />
            </div>
            <h5>{props.data.message}</h5>
            <button type="login">LOGIN</button>
            <br></br>
            <NavLink to="/registration">Click here to register</NavLink> 
        </form>
        </div>
    )
}

export default LoginForm