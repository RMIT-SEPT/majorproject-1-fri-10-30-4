import React, {useEffect, useState, Component} from 'react';
import '../../css/Bookings.css'
import {connect} from 'react-redux'

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
        'customer': {
            'userId': 17,
            'accountType': 'CUSTOMER',
            'firstName': 'William',
            'lastName': 'Butcher',
            'username': 'butcher@ecorp.com',
            'email': 'butcher@ecorp.com',
            'passwordHash': '$2a$10$ZLrR7GKXH/al/UhXeJ.7Tec9XyujJlvtLQILvq6oi9ak4d7VPUNgi',
            'confirmPassword': null,
            'address': '7 Soup Street',
            'phoneNumber': '12345678',
            'fullName': 'William Butcher',
            'password': '$2a$10$ZLrR7GKXH/al/UhXeJ.7Tec9XyujJlvtLQILvq6oi9ak4d7VPUNgi'
        },
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
        'customer': {
            'userId': 7,
            'accountType': 'CUSTOMER',
            'firstName': 'Buffy',
            'lastName': 'Summers',
            'username': 'buffy@sunnydale.com',
            'email': 'buffy@sunnydale.com',
            'passwordHash': '$2a$10$G0B/mIZU/nnk206HQCuyM.6/vL7vp1W8U.iRtCaXQo0q8BAAZiwzW',
            'confirmPassword': null,
            'address': '666 Dracula Street',
            'phoneNumber': '0123456789',
            'fullName': 'Buffy Summers',
            'password': '$2a$10$G0B/mIZU/nnk206HQCuyM.6/vL7vp1W8U.iRtCaXQo0q8BAAZiwzW'
        },
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
        'customer': {
            'userId': 17,
            'accountType': 'CUSTOMER',
            'firstName': 'William',
            'lastName': 'Butcher',
            'username': 'butcher@ecorp.com',
            'email': 'butcher@ecorp.com',
            'passwordHash': '$2a$10$ZLrR7GKXH/al/UhXeJ.7Tec9XyujJlvtLQILvq6oi9ak4d7VPUNgi',
            'confirmPassword': null,
            'address': '7 Soup Street',
            'phoneNumber': '12345678',
            'fullName': 'William Butcher',
            'password': '$2a$10$ZLrR7GKXH/al/UhXeJ.7Tec9XyujJlvtLQILvq6oi9ak4d7VPUNgi'
        },
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
        'customer': {
            'userId': 17,
            'accountType': 'CUSTOMER',
            'firstName': 'William',
            'lastName': 'Butcher',
            'username': 'butcher@ecorp.com',
            'email': 'butcher@ecorp.com',
            'passwordHash': '$2a$10$ZLrR7GKXH/al/UhXeJ.7Tec9XyujJlvtLQILvq6oi9ak4d7VPUNgi',
            'confirmPassword': null,
            'address': '7 Soup Street',
            'phoneNumber': '12345678',
            'fullName': 'William Butcher',
            'password': '$2a$10$ZLrR7GKXH/al/UhXeJ.7Tec9XyujJlvtLQILvq6oi9ak4d7VPUNgi'
        },
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
        // Uncomment these when bookings can be made
        this.setState({loading: true})
        this.getBookings();
    }

    getBookings() {
        // Once you get backend working
        //axios.get(`http://localhost:8080/booking/1`).then(data => console.log(data))
        //const {id} = this.props.user
        axios.get(`http://localhost:8080/booking/all`).then(res => {
                console.log('Getting bookings...')
                this.setState({
                    bookings: res.data.sort((curr, next) => next.bookingStart - curr.bookingStart),
                    loading: false
                })
            }
        )
    }

    cancelBooking(bookingId) {
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

        sendRequest()

    }

    render() {
        return (
            this.state.loading ?
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
                                    <div className="customer-details">
                                        <h3>Customer Details</h3>
                                        <span><strong>Name: </strong>{booking.customer?.firstName + ' ' + booking.customer?.lastName}</span><br/>
                                        <span><strong>Email: </strong>{booking.customer?.email}</span><br/>
                                        <span><strong>Service Description: </strong>
                                            <ul>
                                                {booking?.employee?.services?.map((service, index) =>
                                                    <li className="service"
                                                        key={index}>{service.serviceDescription}</li>
                                                )}
                                            </ul>
                                    </span>
                                    </div>
                                    <div className="employee-details">
                                        <h3>Employee Details</h3>
                                        <span><strong>Name: </strong>{booking.employee?.firstName + ' ' + booking.employee?.lastName}</span><br/>
                                        <span><strong>Email: </strong>{booking.employee?.email}</span><br/>
                                        <span><strong>Service Description: </strong>
                                            <ul>
                                                {booking?.employee?.services?.map((service, index) =>
                                                    <li className="service"
                                                        key={index}>{service.serviceDescription}</li>
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
                                    Date.now().valueOf() < booking.bookingStart &&
                                    <button type="button" className="btn btn-danger add-employee-btn-group"
                                            onClick={this.cancelBooking(booking.bookingId)}>Cancel</button>
                                }
                            </li>
                        )}
                    </ul>
                </div>
        );
    }

};


const mapStateToProps = state => ({
    user: state.security.user
})
export default connect(mapStateToProps)(Bookings);
