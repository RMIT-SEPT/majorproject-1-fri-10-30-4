import React, { Component } from "react";
import logo from "./logo.svg";
import "./App.css";
import HomeComponent from './Components/HomeComponent'

class App extends Component {
  render() {
    return (
      <div className="App">
        <HomeComponent />
    </div>
    );
  }
}

export default App;
