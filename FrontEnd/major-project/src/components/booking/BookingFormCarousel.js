import React from 'react';
import { Jumbotron } from 'react-bootstrap';
import ReactDOM from 'react-dom'
// import {Button} from 'react-bootstrap/'
import "../../css/BookingForm.css"
window.$selectedSlide = 0;
window.numberOfSlides = 4;
window.businessID = 10;

class CarouselControls extends React.Component{
    render(){
        return (
        <div id="BookingFormCarouselControls">
            <div>
                <label>
                    <button onClick={window.bookingFormCarouselComponent.changePageBack.bind()}  className="BackButton btn btn-primary">
                        Back
                    </button>
                </label>
         
            </div>

            <div class="centrePadding"></div>
            
            <div>
                <label>
                <button onClick={window.bookingFormCarouselComponent.changePageForward.bind()} className="ForwardButton btn btn-success">
                    Forward
                </button>
                </label>
            </div>
           
        </div>
        )
    }
}

class ServicesList extends React.Component{
    state = {
        listItems: []
    }

    render(){
        var renderedList = [];
        for(const i in this.state.listItems){
            var service = this.state.listItems[i];
            renderedList.push(<ServicesListItem serviceName={service.serviceDescription} serviceId={service.serviceID}/>)
        }
        return <div id="ServicesListComponent" class="shownCarouselItem">
            <div className="service-btn-block">
                <Jumbotron className="carousel-items-block">
                    {renderedList}
                </Jumbotron>
            </div>
           
        </div>
    }

    componentDidMount(state){
        fetch('http://localhost:8080/services/all', {method:'GET'})
            .then((response)=>response.json())
            .then((responseJson)=>{
                this.state.listItems = []
                for(const i in responseJson){
                    var service = responseJson[i];
                    this.state.listItems.push(service);
                }
                this.forceUpdate();
            });
        
    }
}

class ServicesListItem extends React.Component{ 
    constructor(props){
        super(props);
        this.updateSelectedService = this.updateSelectedService.bind(this);
    }
    render(){
        return (
            <button class="ServicesListItem btn btn-info service-btn" onClick={this.updateSelectedService.bind()}>
                <a>{this.props.serviceName}</a>
            </button>
        )
            
          
       
    }
    updateSelectedService(){
        window.selectedService = this.props.serviceId;
        window.selectedServiceName = this.props.serviceName;
        window.WorkersList.updateWorkers();
        window.BookingSummaryWindow.forceUpdate();
    }
}

class WorkersList extends React.Component{
    state = {
        listItems: [],
        isLoading: false
    }
    constructor(props){
        super(props)
        window.WorkersList = this;
        this.updateWorkers =  this.updateWorkers.bind(this);
    }
    render(){
        if(window.selectedService==null){
            return <div id="WorkersListComponent" class="hiddenCarouselItem">
                    <div className="employee-btn-block">
                        <Jumbotron className="carousel-items-block">
                            <h4>Please select a service before continuing.</h4>
                        </Jumbotron>
                    </div>
                </div>
        } else if(this.state.isLoading){
            return <div id="WorkersListComponent" class="hiddenCarouselItem">
                 <div className="employee-btn-block">
                    <Jumbotron className="carousel-items-block">
                        <h4>Now loading employees...</h4>
                    </Jumbotron>
                    </div>
                </div>
        } else{  
            var renderedList = [];
            for(const i in this.state.listItems){
                var worker = this.state.listItems[i];
                renderedList.push(<WorkersListItem workerName={worker.firstName + " " + worker.lastName} workerId={worker.employeeId}/>)
            }
            return (
                <div id="WorkersListComponent" class="hiddenCarouselItem">
                    <div className="employee-btn-block">
                        <Jumbotron className="carousel-items-block">
                             {renderedList}
                        </Jumbotron>
                    </div>
                    
                </div>
            )         
        }
    }

    updateWorkers(){
        this.state.isLoading = true;
        this.forceUpdate();
        var requestBody = [];
        requestBody.push("businessID" + "=" + window.businessID);
        requestBody.push("serviceID" + "=" + window.selectedService); 
        fetch("http://localhost:8080/employee/findForService?"+requestBody.join("&"), {method:"GET"})
        .then((response)=>response.json())
        .then((responseJson)=>{
            var listItems = []
            for(const i in responseJson){
                var employee = responseJson[i];
                listItems.push(employee);
            }
            this.state.listItems = listItems;
            this.state.isLoading = false;
            this.forceUpdate();
        });
    }
    
}

class WorkersListItem extends React.Component{
    constructor(props){
        super(props);
        this.updateSelectedWorker = this.updateSelectedWorker.bind(this);
    }
    render(){
        return( 
            <button class="ServicesListItem btn btn-dark employee-btn" onClick={this.updateSelectedWorker.bind()}>
                <a>{this.props.workerName}</a>
            </button>
        )
    }
    updateSelectedWorker(){
        window.selectedWorker = this.props.workerId;
        window.selectedWorkerName = this.props.workerName;
        window.DatesList.updateDates();
        window.BookingSummaryWindow.forceUpdate();
    }    
}

class DatesList extends React.Component{
    state = {
        listItems: [], 
        isLoading: false
    }
    constructor(props){
        super(props)
        window.DatesList = this;
        this.updateDates = this.updateDates.bind(this);
    }
    render(){
        if(window.selectedService==null){
            return <div id="DatesListComponent" class="hiddenCarouselItem">
                 <div className="date-btn-block">
                    <Jumbotron className="carousel-items-block">
                        <h4>Please select a service before continuing.</h4>
                    </Jumbotron>
                    </div>      
                </div>
        } else if(this.state.isLoading){
            return <div id="DatesListComponent" class="hiddenCarouselItem">
                    <div className="date-btn-block">
                    <Jumbotron className="carousel-items-block">
                        <h4>Now loading possible dates...</h4>
                    </Jumbotron>
                    </div>
                </div>
        } else{  
            var renderedList = [];
            for(const i in this.state.listItems){
                var dateOption = this.state.listItems[i];
                renderedList.push(<DatesListItem date={dateOption} />)
            }
            return (
            <div id="DatesListComponent" class="hiddenCarouselItem">
                <div className="date-btn-block">
                <Jumbotron className="carousel-items-block">
                    {renderedList}
                </Jumbotron>
                </div>
            </div>  
            )

        }
    }

    updateDates(){
        this.state.isLoading = true;
        this.forceUpdate();
        var requestBody = [];
        requestBody.push("businessID" + "=" + window.businessID);
        requestBody.push("serviceID" + "=" + window.selectedService);
        requestBody.push("employeeID" + "=" + window.selectedWorker);
        fetch("http://localhost:8080/employee/getAvailableDates?"+requestBody.join("&"), {method:"GET"})
        .then((response)=>response.json())
        .then((responseJson)=>{ 
            this.state.listItems = [];
            for(const i in responseJson){
                this.state.listItems.push(new Date(responseJson[i]));
            }
            this.state.listItems.sort(function(a, b){return a.getTime() - b.getTime()});
            this.state.isLoading = false;
            this.forceUpdate();
        });
    }
}

class DatesListItem extends React.Component{

    constructor(props){
        super(props);
        this.updateSelectedDate = this.updateSelectedDate.bind(this);
    }
    render(){
        var days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
        var year = this.props.date.getFullYear();
        var month = this.props.date.getMonth() + 1; //Months are indexed from 0
        var date = this.props.date.getDate();
        
        return (
            <button class="ServicesListItem btn btn-primary date-btn" onClick={this.updateSelectedDate.bind()}>
                <a>{days[this.props.date.getDay()]}, {date}/{month}/{year}</a>
            </button>
        )
    }
    updateSelectedDate(){
        window.selectedDate = this.props.date;
        window.TimesList.updateTimes();
        window.BookingSummaryWindow.forceUpdate();
    }    
}

class TimesList extends React.Component{
    state = {
        listItems: [], 
        isLoading: false
    }
    constructor(props){
        super(props)
        window.TimesList = this; 
        this.updateTimes= this.updateTimes.bind(this);
    }
    render(){
        if(window.selectedService==null){
            return <div id="TimesListComponent" class="hiddenCarouselItem">
                <div className="time-btn-block">
                    <Jumbotron className="carousel-items-block">
                    <h4> Please select a date before continuing.</h4>
                    </Jumbotron>
                </div>
            </div>
        } else if(this.state.isLoading){
            return <div id="TimesListComponent" class="hiddenCarouselItem">
                    <div className="time-btn-block">
                        <Jumbotron className="carousel-items-block">
                        <h4>Now loading appointment times...</h4>
                        </Jumbotron>
                    </div>
                </div>
        } else{  
            var renderedList = [];
            for(const i in this.state.listItems){
                var timeOption = this.state.listItems[i];
                renderedList.push(<TimesListItem startTime={timeOption.shiftStart} endTime={timeOption.shiftEnd} />)
            }
            return (
                <div id="TimesListComponent" class="hiddenCarouselItem">
                    <div className="time-btn-block">
                        <Jumbotron className="carousel-items-block">
                            {renderedList}
                        </Jumbotron>
                    </div>
                </div>
            )  
        }
    }

    updateTimes(){
        this.state.isLoading = true;
        this.forceUpdate();
        var requestBody = [];   
        requestBody.push("businessID" + "=" + window.businessID);
        requestBody.push("serviceID" + "=" + window.selectedService);
        requestBody.push("employeeID" + "=" + window.selectedWorker);
        requestBody.push("date" + "=" + window.selectedDate.getTime());
        fetch("http://localhost:8080/booking/getAvailbleTimes?"+requestBody.join("&"), {method:"GET"})
        .then((response)=>response.json())
        .then((responseJson)=>{ 
            this.state.listItems = [];
            for(const i in responseJson){
                this.state.listItems.push((responseJson[i]));
            }
            console.log(this.state.listItems);
            this.state.isLoading = false;
            this.forceUpdate();
        });
    }
}

class TimesListItem extends React.Component{
    constructor(props){
        super(props);
        this.updateSelectedTime = this.updateSelectedTime.bind(this);
    }
    render(){
        return (
            <button class="ServicesListItem btn btn-info time-btn" onClick={this.updateSelectedTime.bind()}>
                <a>{this.props.startTime} - {this.props.endTime}</a>
            </button>
        )
    }
    updateSelectedTime(){
        window.selectedTime = this.props.startTime;
        window.BookingSummaryWindow.forceUpdate();
    }    
}

class BookingFormCarousel extends React.Component{

    constructor(props){
        super(props);
        this.changePageBack = this.changePageBack.bind(this);
        this.changePageForward = this.changePageForward.bind(this);
        this.updateSelectedPage = this.updateSelectedPage.bind(this);
        this.pages = ["ServicesListComponent", "WorkersListComponent", "DatesListComponent", "TimesListComponent"];
        window.bookingFormCarouselComponent = this;
        window.selectedService = null;
        window.selectedWorker = null;
        window.selectedDate = null;
        window.selectedTime = null;
    }

    changePageBack() {
        window.$selectedSlide = (window.$selectedSlide+=(window.numberOfSlides-1)) % window.numberOfSlides;
        this.updateSelectedPage();
    }
    changePageForward() {
        window.$selectedSlide = (window.$selectedSlide+=1) % window.numberOfSlides;
        this.updateSelectedPage();
    }
    updateSelectedPage(){
        var i =0;
        for(i=0; i < window.numberOfSlides; i++){
            document.getElementById(this.pages[i]).setAttribute("class", "hiddenCarouselItem");
        }
        document.getElementById(this.pages[window.$selectedSlide]).setAttribute("class", "shownCarouselItem");
    }
    /*
    updateWorkers();
    selectWorker();

    updateDates();
    selectDate();

    updateTimes();
    selectTime();

    submitForm();
    */
    render(){
        return(
        <div id="BookingFormCarousel">
            <div id="CarouselItems">
                <ServicesList />
                <WorkersList />
                <DatesList />
                <TimesList />
            </div>       
            <CarouselControls />
        </div>
        );
    }
}

export default BookingFormCarousel