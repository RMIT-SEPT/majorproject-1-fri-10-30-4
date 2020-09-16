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
    }
    render(){
      return <div class="BookingSummaryWindow">Bookings Summary</div>;
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
