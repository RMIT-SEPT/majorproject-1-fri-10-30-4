import React from "react"
import Enzyme,{shallow,mount} from "enzyme"
import Adapter from 'enzyme-adapter-react-16'
import { render, unmountComponentAtNode } from "react-dom"
import { act } from "react-dom/test-utils"

import Employee from '../admin/Employee.js'


// Enzyme.configure({ adapter: new Adapter()})

let container = null;
beforeEach(() => {
    // setup a DOM element as a render target
    container = document.createElement("div");
    document.body.appendChild(container);
  });
  
  afterEach(() => {
    // cleanup on exiting
    unmountComponentAtNode(container);
    container.remove();
    container = null;
  });

  it("renders with props", () => {
      act(() => {
          render(<Employee />, container);
      });
      expect(container.textContent).toBe("")
  })

// describe("Admin Profile", () => {
//     it("Render successful", () => {
//         const wrapper = shallow(<Profile />)
//         expect(wrapper.exists()).toBe(true);
//     });

// });