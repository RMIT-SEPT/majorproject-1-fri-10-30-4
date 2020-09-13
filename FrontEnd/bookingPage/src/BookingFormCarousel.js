import React from 'react';
import ReactDOM from 'react-dom'

window.$selectedSlide = 0;
window.numberOfSlides = 4;
window.businessID = 101;

class CarouselControls extends React.Component{
    render(){
        return <div id="BookingFormCarouselControls">
            <div onClick={window.bookingFormCarouselComponent.changePageBack.bind()} class="BackButton">Back</div>
            <div>Controls</div>
            <div onClick={window.bookingFormCarouselComponent.changePageForward.bind()} class="ForwardButton">Forward</div>
        </div>
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
            {renderedList}
        </div>
    }

    componentDidMount(state){
        fetch('http://localhost:8080/services/all', {method:'GET'})
            .then((response)=>response.json())
            .then((responseJson)=>{
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
        return <button class="ServicesListItem" onClick={this.updateSelectedService.bind()}>
            <a>{this.props.serviceName}</a>
        </button>
    }
    updateSelectedService(){
        window.selectedService = this.props.serviceId;
        window.WorkersList.updateWorkers();
    }
}

class WorkersList extends React.Component{
    state = {
        listItems: []
    }
    constructor(props){
        super(props)
        window.WorkersList = this;
        this.updateWorkers = this.updateWorkers.bind(this);
    }
    render(){
        if(window.selectedService==null){
            return <div id="WorkersListComponent" class="hiddenCarouselItem">Please select a service before continuing.</div>
        } else{  
            var renderedList = [];
            for(const i in this.state.listItems){
                var worker = this.state.listItems[i];
                renderedList.push(<WorkersListItem workerName={worker.userFirstName + " " + worker.userLastName} workerId={worker.userId}/>)
            }
            return <div id="WorkersListComponent" class="hiddenCarouselItem">
                {renderedList}
            </div>         
        }
    }

    updateWorkers(){
        var requestBody = [];
        requestBody.push("businessID" + "=" + window.businessID);
        requestBody.push("serviceID" + "=" + window.selectedService); 
        fetch("http://localhost:8080/employee/findForService?"+requestBody.join("&"), {method:"GET"})
        .then((response)=>response.json())
        .then((responseJson)=>{
            for(const i in responseJson){
                var employee = responseJson[i];
                this.state.listItems.push(employee);
            }
            console.log(this.state.listItems);
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
        return <button class="ServicesListItem" onClick={this.updateSelectedWorker.bind()}>
            <a>{this.props.workerName}</a>
        </button>
    }
    updateSelectedWorker(){
        window.selectedWorker = this.props.workerId;
    }    
}

class DatesList extends React.Component{
    state = {
        listItems: []
    }
    constructor(props){
        super(props)
        window.DatesList = this;
        this.updateDates = this.updateDates.bind(this);
    }
    render(){
        if(window.selectedWorker==null){
            return <div id="DatesListComponent" class="hiddenCarouselItem">Please select a service before continuing.</div>
        } else{  
            var renderedList = [];
            for(const i in this.state.listItems){
                var dateOption = this.state.listItems[i];
                renderedList.push(<DatesListItem date={dateOption.date} workerId={worker.userId}/>)
            }
            return <div id="DatesListComponent" class="hiddenCarouselItem">
                {renderedList}
            </div>         
        }
    }

    updateDates(){
        var requestBody = [];
        requestBody.push("businessID" + "=" + window.businessID);
        requestBody.push("serviceID" + "=" + window.selectedService);
        requestBody.push("workerID" + "=" + window.selectedWorker) 
        fetch("http://localhost:8080/booking/findValidDates?"+requestBody.join("&"), {method:"GET"})
        .then((response)=>response.json())
        .then((responseJson)=>{
            for(const i in responseJson){
                var dateOption = responseJson[i];
                this.state.listItems.push(dateOption);
            }
            console.log(this.state.listItems);
            this.forceUpdate();
        });
    }

    render(){
        return <div id="DatesListComponent" class="hiddenCarouselItem">
            <ul>
                <li>date1</li>
                <li>Date2</li>
            </ul>
        </div>
    }
}

class DatesListItem extends React.Component{
    constructor(props){
        super(props);
        this.updateSelectedDate = this.updateSelectedDate.bind(this);
    }
    render(){
        return <button class="ServicesListItem" onClick={this.updateSelectedDate.bind()}>
            <a>{this.props.workerName}</a>
        </button>
    }
    updateSelectedDate(){
        window.selectedDate = this.props.date;
    }    
}

class TimesList extends React.Component{
    render(){
        return <div id="TimesListComponent" class="hiddenCarouselItem">
            <ul>
                <li>Time1</li>
                <li>Time2</li>
            </ul>
        </div>
    }
}

class TimesListItem extends React.Component{
    constructor(props){
        super(props);
        this.updateSelectedTime = this.updateSelectedTime.bind(this);
    }
    render(){
        return <button class="ServicesListItem" onClick={this.updateSelectedTime.bind()}>
            <a>{this.props.time}</a>
        </button>
    }
    updateSelectedTime(){
        window.selectedTime = this.props.time;
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
                <DateList />
                <TimesList />
            </div>       
            <CarouselControls />
        </div>
        );
    }
}


export default BookingFormCarousel