import React from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  return (
      <div className="App">
        <div class="container">
          <form id="form" class="form">
            <h1>Admin Dashboard </h1>

            <div class="comps">
              <label>Employees</label>
              <button type="submit" name="selection">Add</button>
              <button type="submit" name="selection">Edit</button>
            </div>
          </form>
        </div>
      </div>
  );
}

export default App;