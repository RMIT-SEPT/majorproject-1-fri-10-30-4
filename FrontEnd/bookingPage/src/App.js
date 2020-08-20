import React from "react";
import logo from "./logo.svg";
import "./App.css";

function App() {
  return (
    <div className="App">
      <form id="form" class="form">
        <h1>BOOK APOINTMENT </h1>
        <div class="comps" align="center">
          <label for="stuff">Select stuff member:</label>
          <select name="member" id="member" class="member">
            <option value="1">Mike</option>
            <option value="2">Nikita</option>
            <option value="3">Harrison</option>
            <option value="4">Joel</option>
            <option value="5">Jasper</option>
          </select>
        </div>
        <div class="comps" align="center">
          <label for="service">Select the service you want : </label>
          <select name="member" id="member" class="member">
            <option value="1">Service1</option>
            <option value="2">Service2</option>
            <option value="3">Service3</option>
          </select>
        </div>
        <div class="comps" align="center">
          <label for="start_date">Select a date:</label>
          <select name="member" id="date" class="member"></select>
        </div>

        <div class="comps" align="center">
          <label for="start_time">Select starting time:</label>
          <select name="startHours" id="startHours" class="member"></select>
        </div>

        <div class="comps" align="center">
          <label for="hours">Select duration:</label>
          <input type="radio" id="hours" name="hours" value="1"></input>
          <label for="hour">0-1</label>
          <input type="radio" id="hours" name="hours" value="2"></input>
          <label for="hour">1-2</label>
          <input type="radio" id="hours" name="hours" value="3"></input>
          <label for="hour">2-3</label>
          <input type="radio" id="hours" name="hours" value="4"></input>
          <label for="hour">3-4</label>
        </div>

        <button type="book"> BOOK</button>
      </form>
    </div>
  );
}

export default App;
