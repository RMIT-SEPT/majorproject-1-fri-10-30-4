import React from "react";
import { render, unmountComponentAtNode } from "react-dom";
import { act } from "react-dom/test-utils";
import Emplyee from '../admin/Employee.js';

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

it("renders data", async () => {
  const mockEmployee = {
    businessId: 10,
    firstName: "MyName'sJeff",
    lastName: "testing",
    email: "Test@test.com",
    passwordHash: "",
    phoneNumber: "+6123456789",    
    services: "",

    // mondayTime: "",
    // tuesdayTime: "",
    // wednesdayTime: "",
    // thursdayTime: "",
    // fridayTime: "",
    // saturdayTime: "",
    // sundayTime: ""
  };

  jest.spyOn(global, "fetch").mockImplementation(() =>
    Promise.resolve({
      json: () => Promise.resolve(mockEmployee)
    })
  );

  // Use the asynchronous version of act to apply resolved promises
  await act(async () => {
    render(<Employee id="123" />, container);
  });

  expect(container.querySelector("summary").textContent).toBe(fakeUser.name);
  expect(container.querySelector("strong").textContent).toBe(fakeUser.age);
  expect(container.textContent).toContain(fakeUser.address);

  // remove the mock to ensure tests are completely isolated
  global.fetch.mockRestore();
});