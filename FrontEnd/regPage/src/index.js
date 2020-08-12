import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import helper from "./Helper.js";
import App from "./App";
import * as serviceWorker from "./serviceWorker";

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById("root")
);
const succs = 2;
const error = 1;
const other = 3;
const emailchk = 4;
const form = document.getElementById("form");
const fname = document.getElementById("first name");
const lname = document.getElementById("last name");
const address = document.getElementById("address");
const email = document.getElementById("email");
const username = document.getElementById("username");

const cpassword = document.getElementById("confirm password");
const password = document.getElementById("password");

function setName(input) {
  return input.id.charAt(0).toUpperCase() + input.id.slice(1);
}
function fieldsValidator(inputArr) {
  inputArr.forEach(function (input) {
    if (input.value.trim() === "") {
      helper(error, input, `${setName(input)} is required`);
    } else {
      helper(succs, input);
    }
  });
}

function lengthValidator(input, min, max) {
  if (input.value.length < min) {
    helper(1, input, `${setName(input)} must be at least ${min} characters`);
  } else if (input.value.length > max) {
    helper(1, input, `${setName(input)} must be less than ${max} characters`);
  } else {
    helper(succs, input);
  }
}

form.addEventListener("submit", function (e) {
  e.preventDefault();
  fieldsValidator([
    username,
    email,
    fname,
    lname,
    address,
    password,
    cpassword,
  ]);
  lengthValidator(username, 3, 15);
  lengthValidator(fname, 3, 15);
  lengthValidator(lname, 3, 15);
  lengthValidator(address, 3, 20);
  lengthValidator(password, 6, 25);
  helper(emailchk, email);
  helper(other, password, cpassword);
});

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
