import React from "react";
import logo from "./logo.svg";
import "./App.css";
import Carousel from 'react-bootstrap/Carousel'
import "bootstrap/dist/css/bootstrap.css";
import BookingFormCarousel from "./BookingFormCarousel.js"

class Header extends React.Component{
  render(){
    return <header><h2>This is the header.</h2></header>;
  }
}

class Footer extends React.Component{
  render(){
    return <footer><h2>This is the footer.</h2></footer>;
  }
}

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

function App() {
  return (
    <div className="App">
      <Header />
      <section class="pageContent">
        <BookingInputWindow />
        <BookingSummaryWindow />
      </section>
      <Footer />
    </div>
  );
}

export default App;