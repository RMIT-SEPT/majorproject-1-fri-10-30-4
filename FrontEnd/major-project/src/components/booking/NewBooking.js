import React from 'react';

import BookingFormCarousel from "./BookingFormCarousel"
import "../../css/BookingFormCarousel.css"
import "../../css/BookingForm.css"
import { Jumbotron } from 'react-bootstrap';
import { connect } from "react-redux"

class BookingInputWindow extends React.Component{
    render(){
      return <BookingFormCarousel />
    }
  }
  
class BookingSummaryWindow extends React.Component{
  constructor(props){
    super();
    this.state ={
      user: props.user
    }
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
      submitButton = <button onClick = {this.submitForm.bind()} className="btn btn-success">Submit</button>
    } else{
      submitButton = <button hidden="hidden">Submit</button>
    }
    return (
      <div class="BookingSummaryWindow booking-summary">
        <Jumbotron className="summary-contents">
          <h3>Booking Summary:</h3><hr></hr>
          <div className="row">
            <div className="col-3">
              <h5>Service: </h5>
            </div>
            <div className="col-6">
              <h5>{window.selectedServiceName}</h5>
            </div>
          </div><br></br>
          <div className="row">
            <div className="col-3">
              <h5>Worker: </h5>
            </div>
            <div className="col-6">
              <h5>{window.selectedWorkerName}</h5>
            </div>
          </div><br></br>
          <div className="row">
            <div className="col-3">
              <h5>Date: </h5>
            </div>
            <div className="col-6">
              <h5>{this.dateDisplay}</h5>
            </div>
          </div><br></br>
          <div className="row">
            <div className="col-3">
              <h5>Time: </h5>
            </div>
            <div className="col-6">
              <h5>{window.selectedTime}</h5>
            </div>
          </div><br></br>
          {submitButton}
        </Jumbotron>

      
      </div>
    );
  }

  submitForm(){
    var requestBody = []
    requestBody.push("businessID" + "=" + window.businessID);
    requestBody.push("serviceID" + "=" + window.selectedService);
    requestBody.push("employeeID" + "=" + window.selectedWorker);
    requestBody.push("customerID" + "=" + this.state.user.id);
    var requestDateTime = window.selectedDate;
    var timeSelection = window.selectedTime.split(":");
    requestDateTime.setHours(timeSelection[0]);
    requestDateTime.setMinutes(timeSelection[1]);
    requestDateTime.setSeconds(0);
    requestBody.push("date" + "=" + window.selectedDate.getTime());
    fetch("http://localhost:8080/booking/create?"+requestBody.join("&"), {method:"POST"})
    .then(x=>{
      alert("Booking request submitted.");
      //window.location.href = "http://localhost:3000/home"
    })
    console.log("http://localhost:8080/booking/create?"+requestBody.join("&"))
  }
}
  
class NewBooking extends React.Component{
    constructor(props){
      super();
      this.state = {}
    }
    render() {
        return (<div class="pageContent">
            <BookingInputWindow />
            <BookingSummaryWindow user={this.props.user}/>
            </div>
        );
    }
}

const mapStateToProps = state=>({
  user: state.security.user
})
export default connect(mapStateToProps)(NewBooking);
