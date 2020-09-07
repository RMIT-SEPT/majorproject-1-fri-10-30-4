import React from "react";
import "./App.css";

function App() {
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
      </form>
    </div>
  );
}

export default App;
