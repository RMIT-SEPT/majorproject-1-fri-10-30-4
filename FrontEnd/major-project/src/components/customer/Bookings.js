import React, {Component, useEffect, useState} from 'react';
import '../../css/Bookings.css'
import { connect } from "react-redux"
const axios = require('axios').default;

const data = [
    {
        'bookingId': 1,
        'service': {
            'serviceID': 8,
            'business': {
                'businessTitle': 'E Corp',
                'businessID': 10
            },
            'serviceLength': 10,
            'serviceDescription': 'Computer Repair'
        },
        'customer': null,
        'employee': {
            'employeeId': 11,
            'business': {
                'businessTitle': 'E Corp',
                'businessID': 10
            },
            'firstName': 'Elliot',
            'lastName': 'Alderson',
            'email': 'elliotAlderson@email.com',
            'passwordHash': 'greatPasswordHash',
            'phoneNumber': '0433444555',
            'mondayTime': '09:00-12:00',
            'tuesdayTime': '09:00-12:00',
            'wednesdayTime': '',
            'thursdayTime': '',
            'fridayTime': '',
            'saturdayTime': '',
            'sundayTime': '',
            'services': [
                {
                    'serviceID': 8,
                    'business': {
                        'businessTitle': 'E Corp',
                        'businessID': 10
                    },
                    'serviceLength': 10,
                    'serviceDescription': 'Computer Repair'
                }
            ]
        },
        'bookingDescription': '',
        'active': true,
        'bookingEnd': 1589523634000,
        'bookingStart': 1571856000401
    },
    {
        'bookingId': 2,
        'service': {
            'serviceID': 8,
            'business': {
                'businessTitle': 'E Corp',
                'businessID': 10
            },
            'serviceLength': 10,
            'serviceDescription': 'Computer Repair'
        },
        'customer': null,
        'employee': {
            'employeeId': 11,
            'business': {
                'businessTitle': 'E Corp',
                'businessID': 10
            },
            'firstName': 'Elliot',
            'lastName': 'Alderson',
            'email': 'elliotAlderson@email.com',
            'passwordHash': 'greatPasswordHash',
            'phoneNumber': '0433444555',
            'mondayTime': '09:00-12:00',
            'tuesdayTime': '09:00-12:00',
            'wednesdayTime': '',
            'thursdayTime': '',
            'fridayTime': '',
            'saturdayTime': '',
            'sundayTime': '',
            'services': [
                {
                    'serviceID': 8,
                    'business': {
                        'businessTitle': 'E Corp',
                        'businessID': 10
                    },
                    'serviceLength': 10,
                    'serviceDescription': 'Computer Repair'
                }
            ]
        },
        'bookingDescription': '',
        'active': true,
        'bookingEnd': 1601856600401,
        'bookingStart': 1601856000401
    },
    {
        'bookingId': 3,
        'service': {
            'serviceID': 8,
            'business': {
                'businessTitle': 'E Corp',
                'businessID': 10
            },
            'serviceLength': 10,
            'serviceDescription': 'Computer Repair'
        },
        'customer': null,
        'employee': {
            'employeeId': 11,
            'business': {
                'businessTitle': 'E Corp',
                'businessID': 10
            },
            'firstName': 'Elliot',
            'lastName': 'Alderson',
            'email': 'elliotAlderson@email.com',
            'passwordHash': 'greatPasswordHash',
            'phoneNumber': '0433444555',
            'mondayTime': '09:00-12:00',
            'tuesdayTime': '09:00-12:00',
            'wednesdayTime': '',
            'thursdayTime': '',
            'fridayTime': '',
            'saturdayTime': '',
            'sundayTime': '',
            'services': [
                {
                    'serviceID': 8,
                    'business': {
                        'businessTitle': 'E Corp',
                        'businessID': 10
                    },
                    'serviceLength': 10,
                    'serviceDescription': 'Computer Repair'
                }
            ]
        },
        'bookingDescription': '',
        'active': true,
        'bookingEnd': 1601856600401,
        'bookingStart': 1600856000401
    },
    {
        'bookingId': 4,
        'service': {
            'serviceID': 8,
            'business': {
                'businessTitle': 'E Corp',
                'businessID': 10
            },
            'serviceLength': 10,
            'serviceDescription': 'Computer Repair'
        },
        'customer': null,
        'employee': {
            'employeeId': 11,
            'business': {
                'businessTitle': 'E Corp',
                'businessID': 10
            },
            'firstName': 'Elliot',
            'lastName': 'Alderson',
            'email': 'elliotAlderson@email.com',
            'passwordHash': 'greatPasswordHash',
            'phoneNumber': '0433444555',
            'mondayTime': '09:00-12:00',
            'tuesdayTime': '09:00-12:00',
            'wednesdayTime': '',
            'thursdayTime': '',
            'fridayTime': '',
            'saturdayTime': '',
            'sundayTime': '',
            'services': [
                {
                    'serviceID': 8,
                    'business': {
                        'businessTitle': 'E Corp',
                        'businessID': 10
                    },
                    'serviceLength': 10,
                    'serviceDescription': 'Computer Repair'
                }
            ]
        },
        'bookingDescription': '',
        'active': true,
        'bookingEnd': 1608013234000,
        'bookingStart': 1601856000401
    }
]

// const [loading, setLoading] = useState(true)
// const [bookings, setBookings] = useState([])

// useEffect(() => {
//     getBookings()
//     // Remove these 2 after connecting with backend
//     // setBookings(data.sort((curr, next) => next.bookingStart - curr.bookingStart))
//     // setLoading(false)
// }, [])



class Bookings extends Component {
    constructor() {
        super();
        this.state = {
            bookings: [],
            loading: false
        }
        this.getBookings = this.getBookings.bind(this);
        this.cancelBooking = this.cancelBooking.bind(this);
        this.removeBooking = this.removeBooking.bind(this);
    }

    componentDidMount() {
        this.setState({loading: true})
        this.getBookings();
    }

    getBookings() {
        // Once you get backend working
        //axios.get(`http://localhost:8080/booking/1`).then(data => console.log(data))
        const {id} = this.props.user
        axios.get(`http://localhost:8080/booking/allbyid?${id}`).then(res => {
                console.log(id)
                this.setState({
                    bookings: res.data.sort((curr, next) => next.bookingStart - curr.bookingStart),
                    loading: false
                })
            }
        )
    }
    
    cancelBooking(bookingId) {
        // Cancel the booking {set active to false}
        //console.log('Cancel: ', id)
        async function sendRequest() {
            const res = await axios.put(`http://localhost:8080/booking/cancel?bookingId=${bookingId}`)
            return res
        }
        sendRequest()
      
    }
    
    removeBooking(bookingId) {
    
        // Remove the booking
        //console.log('Remove: ', id)
        async function sendRequest() {
            const res = await axios.delete(`http://localhost:8080/booking/remove?bookingId=${bookingId}`)
            return res
        }
        sendRequest();
        
    }
    render() {
        return (
            this.state.loading && this.state.bookings.length > 0 ?
                <div>
                    <h1>Loading...</h1>
                </div> :
                <div className="bookings">
                    <h1>List of all bookings</h1>
                    <ul className="list">
                        {this.state.bookings.map(booking =>
                            <li key={booking.bookingId} className="booking">
                                <div>
                                    <span><strong>ID: </strong>{booking.bookingId}</span>
                                    <span><strong>Start: </strong>{new Date(booking.bookingStart).toLocaleString()}</span>
                                    <span><strong>End: </strong>{new Date(booking.bookingEnd).toLocaleString()}</span>
                                </div>
                                <br/>
                                <div className="details">
                                    <div className="employee-details">
                                        <h3>Employee Details</h3>
                                        <span><strong>Name: </strong>{booking.employee?.firstName + ' ' + booking.employee?.firstName}</span><br/>
                                        <span><strong>Email: </strong>{booking.employee?.email}</span><br/>
                                        <span><strong>Service Description: </strong>
                                            <ul>
                                                {booking?.employee?.services?.map((service, index) =>
                                                    <li className="service" key={index}>{service.serviceDescription}</li>
                                                )}
                                            </ul>
                                    </span>
                                    </div>
                                </div>
                                <br/>
                                <button type="button" className="btn btn-secondary add-employee-btn-group"
                                        onClick={this.removeBooking(booking.bookingId)}>Remove
                                </button>
                                {
                                    Date.now().valueOf() < booking.bookingEnd && <button type="button" className="btn btn-danger add-employee-btn-group"
                                    onClick={this.cancelBooking(booking.bookingId)}>Cancel</button>
                                }
                            </li>
                        )}
                    </ul>
                </div>
        );
    }
   
};
const mapStateToProps = state=>({
    user: state.security.user
})
export default connect(mapStateToProps)(Bookings);
