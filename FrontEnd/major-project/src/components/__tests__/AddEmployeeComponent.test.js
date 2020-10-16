import React from "react"
import Enzyme,{shallow,mount} from "enzyme"
import Adapter from 'enzyme-adapter-react-16'
import AddEmployeeComponent from '../AddEmployeeComponent.js'

Enzyme.configure({ adapter: new Adapter()})

describe("Admin adding employees", () => {

    // Rendering Test: Test if component loaded with given props
    const employee = {
        businessId: this.state.businessId,
        firstName: this.state.firstName,
        lastName: this.state.lastName,
        email: this.state.email,
        passwordHash: this.state.passwordHash,
        phoneNumber: this.state.phoneNumber,    
        services: this.state.services,

        mondayTime: this.state.mondayTime,
        tuesdayTime: this.state.tuesdayTime,
        wednesdayTime: this.state.wednesdayTime,
        thursdayTime: this.state.thursdayTime,
        fridayTime: this.state.fridayTime,
        saturdayTime: this.state.saturdayTime,
        sundayTime: this.state.sundayTime
    }


});