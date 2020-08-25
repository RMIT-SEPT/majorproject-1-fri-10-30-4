import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import * as serviceWorker from "./serviceWorker";

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById("root")
);
var y = 0;
var m = 0;
var d = 0;
var md = 31;
for (y = 2020; y <= 2023; y++) {
  for (m = 1; m <= 12; m++) {
    if (m % 2 == 0) {
      md = 30;
    }
    if (m == 2) {
      md = 28;
    }
    for (d = 1; d <= md; d++) {
      var date = document.createElement("OPTION");
      date.text = d + "/" + m + "/" + y;
      date.value = d + "/" + m + "/" + y;
      document.getElementById("date").options.add(date);
    }
  }
}

for (m = 9; m <= 17; m++) {
  for (d = 1; d <= 2; d++) {
    var half = 0;
    if (d % 2 == 0) {
      half = 3;
    }
    var srtHour = document.createElement("OPTION");
    srtHour.text = m + ":" + half + "0";
    srtHour.value = m + ":" + half + "0";
    document.getElementById("startHours").options.add(srtHour);
  }
}

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
