import React from "react"
import Enzyme,{shallow,mount} from "enzyme"
import Adapter from 'enzyme-adapter-react-16'
import Profile from '../admin/Employee.js'


Enzyme.configure({ adapter: new Adapter()})

describe("Admin Profile", () => {
    it("Render successful", () => {
        const wrapper = shallow(<Profile />)
        expect(wrapper.exists()).toBe(true);
    });

});