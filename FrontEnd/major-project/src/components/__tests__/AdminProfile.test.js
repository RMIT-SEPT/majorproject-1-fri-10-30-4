import React from "react"
import Enzyme,{shallow,mount} from "enzyme"
import Adapter from 'enzyme-adapter-react-16'
import Profile from '../admin/Profile.js'

Enzyme.configure({ adapter: new Adapter()})


describe("Admin Profile", () => {
    //Check if Admin Component Renders
    test("Render successful", () => {
        const wrapper = shallow(<Profile />)
        expect(wrapper.exists()).toBe(true);
    });

    //Test with an existing profile whether it renders the correct information
    test("Render profile with correct data", () => {
        const profile = [
            {"userID" : 1234,
            "businessID" : 1124,
            }
        ]

        const wrapper = shallow(<Profile />)
        wrapper.setState({
            admin:profile,
            isLoading:false
        })

        expect(wrapper.exists()).toBe(true);
        expect(wrapper.state().user).toBe(profile);
    });

    test("Successfully shows output in list when data renders",()=>{
        const wrapper = shallow(<Profile />)
        const profile = [
            {"userID" : 1234,
            "businessID" : 1124,
            }
        ]

        const divwrapper = shallow(
                <div class="person-info">
                    <h4>1124</h4>
                    <h4>1234</h4>
                    <p>Administrator</p>
                    <p>Working as an administrator for E-booking.</p>
                </div>
            );

        wrapper.setState({
            isLoading:false,
            admin:profile
        });

        console.log(wrapper.debug());
        expect(wrapper.containsMatchingElement(divwrapper)).toEqual(true);
    });

    test("Successfully shows output in list when data renders",()=>{
        const wrapper = shallow(<Profile />)
        const profile = [
            {"userID" : 1234,
            "businessID" : 1124,
            }
        ]

        wrapper.setState({
            isLoading:false,
            admin:profile
        });
        
        expect(wrapper.find("h4")).toHaveLength(4);
    });

    test("Successfully shows output in list when data renders",()=>{
        const wrapper = shallow(<Profile />)
        const profile = [
            {"userID" : 1234,
            "businessID" : 1124,
            }
        ]

        wrapper.setState({
            isLoading:false,
            admin:profile
        });
        
        expect(wrapper.find("h4")).toHaveLength(4);
    });
});