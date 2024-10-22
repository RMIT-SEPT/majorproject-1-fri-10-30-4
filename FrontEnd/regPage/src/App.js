import React from "react";
import logo from "./logo.svg";
import "./App.css";

function App() {
  return (
    <div className="App">
      <div class="container">
        <form id="form" class="form">
          <h1>Register </h1>

          <div class="comps">
            <label for="fname">First Name</label>
            <input type="text" id="first name" placeholder="Enter First Name" />
            <small>Error </small>
          </div>
          <div class="comps">
            <label for="lname">Last Name</label>
            <input type="text" id="last name" placeholder="Enter Last Name" />
            <small>Error </small>
          </div>
          <div class="comps">
            <label for="username">Username</label>
            <input type="text" id="username" placeholder="Enter username" />
            <small>Error</small>
          </div>
          <div class="comps">
            <label for="email">Email</label>
            <input type="text" id="email" placeholder="Enter email" />
            <small>Error </small>
          </div>
          <div class="comps">
            <label for="address">Address</label>
            <input type="text" id="address" placeholder="Enter Address" />
            <small>Error </small>
          </div>
          <div class="comps">
            <label for="password">Password</label>
            <input type="password" id="password" placeholder="Enter password" />
            <small>Error </small>
          </div>
          <div class="comps">
            <label for="password2">Confirm Password</label>
            <input
              type="password"
              id="confirm password"
              placeholder="Confirm password"
            />
            <small>Error </small>
          </div>
          <button type="submit">SUBMIT</button>
        </form>
      </div>
    </div>
  );
}

export default App;
