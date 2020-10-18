import React from "react"
import Enzyme,{shallow,mount} from "enzyme"
import Adapter from 'enzyme-adapter-react-16'
import Booking from '../customer/Booking.js'
import { act } from "react-dom/test-utils";
import { render, unmountComponentAtNode } from "react-dom";

Enzyme.configure({ adapter: new Adapter()})


    // Rendering Test: Test if component loaded with given props
    const bookingMock = {
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
    }

    beforeEach(() => {
        // setup a DOM element as a render target
        container = document.createElement("div");
        // container *must* be attached to document so events work correctly.
        document.body.appendChild(container);
      });
      
      afterEach(() => {
        // cleanup on exiting
        unmountComponentAtNode(container);
        container.remove();
        container = null;
      });

    test("Render successful", () => {
        const wrapper = shallow(<Booking />)
        expect(wrapper.exists()).toBe(true);
    });


    test("Successfully shows output in list when data renders",()=>{
        const wrapper = shallow(<Booking />)

        const divwrapper = shallow(
                <div className="employee-details">
                    <h3>Employee Details</h3>
                    <span><strong>Name: </strong>{bookingMock.employee?.firstName + ' ' + bookingMock.employee?.firstName}</span><br/>
                    <span><strong>Email: </strong>{bookingMock.employee?.email}</span><br/>
                    <span><strong>Service Description: </strong>
                        <ul>
                            {bookingMock?.employee?.services?.map((service, index) =>
                                <li className="service" key={index}>{service.serviceDescription}</li>
                            )}
                        </ul>
                    </span>
                </div>
        );

        expect(wrapper).toBe(divwrapper);
        expect(wrapper.find("h4")).toHaveLength(1);
    });

    test("When booking list is rendered, calls getBooking function", () => {
        const spy = jest.spyOn(Booking, 'getBookings');
        Booking.getBooking();
        expect(spy).toHaveBeenCalledTimes(1);
    });

    // Testing Remove Functionality
    test("Remove button changes value when clicked", () => {
        const onChange = jest.fn();
        act(() => {
          render(<Booking onChange={onChange} />, container);
        });

        // Retrieve remove booking button with query Selector : Retrive element by unique id. 
        const button = document.querySelector("[removeBooking]");
        expect(button.innerHTML).toBe("Remove");

        // Div wrapper with mock data loaded in
        const divwrapper = shallow(
            <div className="employee-details">
                <h3>Employee Details</h3>
                <span><strong>Name: </strong>{bookingMock.employee?.firstName + ' ' + bookingMock.employee?.firstName}</span><br/>
                <span><strong>Email: </strong>{bookingMock.employee?.email}</span><br/>
                <span><strong>Service Description: </strong>
                    <ul>
                        {bookingMock?.employee?.services?.map((service, index) =>
                            <li className="service" key={index}>{service.serviceDescription}</li>
                        )}
                    </ul>
                </span>
            </div>
        );

        // Action: Mouse Event Clicking on remove button
        //  Self-Note that { bubbles: true } must be passed in each event you create for it to reach the React listener because React automatically delegates events to the document.
        act(() => {
            button.dispatchEvent(new MouseEvent("click", { bubbles: true }));
          });

        expect(onChange).toHaveBeenCalledTimes(1);
        
        // Bookings with pre-rendered data should have an element removed
        expect(wrapper.find)
    });


    // Integration Testing: Booking and Customer

    