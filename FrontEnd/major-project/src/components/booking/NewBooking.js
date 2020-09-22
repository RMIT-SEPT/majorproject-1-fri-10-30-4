import React from 'react';
import ReactDOM from 'react-dom'

import BookingFormCarousel from "./BookingFormCarousel"
import "../../css/BookingFormCarousel.css"


class BookingInputWindow extends React.Component{
    render(){
      return <BookingFormCarousel />
    }
  }
  
class BookingSummaryWindow extends React.Component{
  constructor(props){
    super(props);
    window.BookingSummaryWindow = this;
    this.dateDisplay = <a></a>
    this.submitForm = this.submitForm.bind(this);
  }
  render(){
    if(window.selectedDate!=null){
      this.dateDisplay = <a>{window.selectedDate.getDate()}/{window.selectedDate.getMonth()+1}/{window.selectedDate.getFullYear()}</a>
    } else{
      this.dateDisplay = <a></a>
    }
    var submitButton;
    if(window.selectedService!=null && window.selectedWorker!=null && window.selectedDate != null && window.selectedTime != null){
      submitButton = <button onClick = {this.submitForm.bind()}>Submit</button>
    } else{
      submitButton = <button hidden="hidden">Submit</button>
    }
    return <div class="BookingSummaryWindow">
      <h3>Booking Summary:</h3>
      <p>Service:{window.selectedServiceName}</p>
      <p>Worker:{window.selectedWorkerName}</p>
      <p>Date:{this.dateDisplay}</p>
      <p>Time:{window.selectedTime}</p>
      {submitButton}
    </div>;
  }

  submitForm(){
    var requestBody = []
    requestBody.push("businessID" + "=" + window.businessID);
    requestBody.push("serviceID" + "=" + window.selectedService);
    requestBody.push("employeeID" + "=" + window.selectedWorker);
    requestBody.push("customerID" + "=" + 0);
    var requestDateTime = window.selectedDate;
    var timeSelection = window.selectedTime.split(":");
    requestDateTime.setHours(timeSelection[0]);
    requestDateTime.setMinutes(timeSelection[1]);
    requestDateTime.setSeconds(0);
    requestBody.push("date" + "=" + window.selectedDate.getTime());
    fetch("http://localhost:8080/booking/create?"+requestBody.join("&"), {method:"POST"})
    .then(x=>{
      alert("Booking request submitted.");
      window.location.href = "http://localhost:3000/"
    })
  }
}
  
class NewBooking extends React.Component{
    render() {
        return (<div class="pageContent">
            <BookingInputWindow />
            <BookingSummaryWindow />
            </div>
        );
    }
}

export default NewBooking;
