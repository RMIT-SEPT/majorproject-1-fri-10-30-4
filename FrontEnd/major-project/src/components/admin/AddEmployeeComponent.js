import React from "react"

function AddEmployeeComponent(props){
    return (
        <div>
            <h1 className="add-employee-title">Add Employee</h1>
           
            <form className="add-employee-form">
            <hr></hr>
            <h4>Employee Information</h4>
            <br></br>
                <div className="form-group row">
                    <label className="control-label col-sm-1" for="fname">First Name</label>
                    <div className="col-sm-4">
                        <input 
                            onChange={props.onChange}
                            value={props.data.firstNamw}
                            name="firstName"
                            type="text" 
                            className="form-control" 
                            required>
                        </input>
                    </div>
                </div>
                <div className="form-group row">
                    <label className="control-label col-sm-1" for="fname">Last Name</label>
                    <div className="col-sm-4">
                        <input 
                              onChange={props.onChange}
                              value={props.data.lastName}
                              name="lastName" 
                              type="text" 
                              className="form-control" 
                              required>
                        </input>
                    </div>
                </div>
                <div className="form-group row">
                    <label className="control-label col-sm-1" >Email</label>
                    <div className="col-sm-4">
                        <input 
                            onChange={props.onChange}
                            value={props.data.email}
                            name="email" 
                            type="email" 
                            className="form-control" 
                            required>
                        </input>
                    </div>
                </div>
                <div className="form-group row">
                    <label className="control-label col-sm-1">Phone Number</label>
                    <div className="col-sm-4">
                        <input 
                            onChange={props.onChange} 
                            value={props.data.phoneNumber}
                            name="phoneNumber"  
                            type="tel" 
                            className="form-control"  
                            required>
                        </input>
                    </div>
                </div>
                <div className="form-group row">
                    <label className="control-label col-sm-1">Password</label>
                    <div className="col-sm-4">
                        <input 
                            onChange={props.onChange} 
                            value={props.data.passwordHash}
                            name="passwordHash"
                            type="password" 
                            className="form-control" 
                            required>
                        </input>
                    </div>
                </div>
            
                <hr></hr>
                <h4>Service</h4>
                <br></br>
                <label>
                    <input
                        type="radio"
                        name="service"
                        value="service1"
                        checked={props.data.service === "service1"}
                        onChange={props.onChange}
                    /> Service 1
                </label>
                <br></br>
                <label>
                    <input
                        type="radio"
                        name="service"
                        value="service2"
                        checked={props.data.service === "service2"}
                        onChange={props.onChange}
                    /> Service 2
                </label>
                <br></br>
                <label>
                    <input
                        type="radio"
                        name="service"
                        value="service3"
                        checked={props.data.service === "service3"}
                        onChange={props.onChange}
                    /> Service 3
                </label>
                <br></br>
                <br></br>
                <hr></hr>
                <h4>Schedule</h4>
                <br></br>
                <table>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                    <tr>
                        <td><span className="form-control badge-info day-label">Monday</span></td>
                        <td>
                            <select 
                            value={props.data.mondayTime} 
                            onChange={props.onChange} 
                            name="mondayTime" 
                            className="form-control">
                                <option value=""> None</option>
                                <option value ="9:00-12:00">9am - 12pm</option>
                                <option value ="12:00-15:00">12pm - 3pm</option>
                                <option value ="15:00-18:00">3pm - 6pm</option>      
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span className="form-control badge-info day-label">Tuesday</span></td>
                        <td>
                            <select 
                            value={props.data.tuesdayTime} 
                            onChange={props.onChange} 
                            name="tuesdayTime" 
                            className="form-control">
                                <option value=""> None</option>
                                <option value ="9:00-12:00">9am - 12pm</option>
                                <option value ="12:00-15:00">12pm - 3pm</option>
                                <option value ="15:00-18:00">3pm - 6pm</option>        
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span className="form-control badge-info day-label">Wednesday</span></td>
                        <td>
                            <select 
                            value={props.data.wednesdayTime} 
                            onChange={props.onChange} 
                            name="wednesdayTime" 
                            className="form-control">
                                <option value=""> None</option>
                                <option value ="9:00-12:00">9am - 12pm</option>
                                <option value ="12:00-15:00">12pm - 3pm</option>
                                <option value ="15:00-18:00">3pm - 6pm</option>        
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span className="form-control badge-info day-label">Thurday</span></td>
                        <td>
                            <select 
                            value={props.data.thursdayTime} 
                            onChange={props.onChange} 
                            name="thursdayTime" 
                            className="form-control">
                                <option value=""> None</option>
                                <option value ="9:00-12:00">9am - 12pm</option>
                                <option value ="12:00-15:00">12pm - 3pm</option>
                                <option value ="15:00-18:00">3pm - 6pm</option>       
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span className="form-control badge-info day-label">Friday</span></td>
                        <td>
                            <select 
                            value={props.data.fridayTime} 
                            onChange={props.onChange} 
                            name="fridayTime" 
                            className="form-control">
                                <option value=""> None</option>
                                <option value ="9:00-12:00">9am - 12pm</option>
                                <option value ="12:00-15:00">12pm - 3pm</option>
                                <option value ="15:00-18:00">3pm - 6pm</option>   
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span className="form-control badge-info day-label">Saturday</span></td>
                        <td>
                            <select 
                                value={props.data.saturdayTime} 
                                onChange={props.onChange} 
                                name="saturdayTime" 
                                className="form-control">
                                <option value=""> None</option>
                                <option value ="9:00-12:00">9am - 12pm</option>
                                <option value ="12:00-15:00">12pm - 3pm</option>
                                <option value ="15:00-18:00">3pm - 6pm</option>       
                            </select>
                        </td> 
                    </tr>
                    <tr>
                        <td><span  className="form-control badge-info day-label">Sunday</span></td>
                        <td>
                            <select 
                            value={props.data.sundayTime} 
                            onChange={props.onChange} 
                            name="sundayTime"
                            className="form-control">
                                <option value=""> None</option>
                                <option value ="9:00-12:00">9am - 12pm</option>
                                <option value ="12:00-15:00">12pm - 3pm</option>
                                <option value ="15:00-18:00">3pm - 6pm</option>       
                            </select>
                        </td>
                    </tr>
                    
                </table>
              
                <br></br><br></br>
                <div className="container-sm">
                    <h4>Timetable</h4>
                    <table className="table table-bordered">
                        <tr className="schedule-table-col">
                            <th>Monday</th>
                            <th>Tuesday</th>
                            <th>Wednesday</th>
                            <th>Thursday</th>
                            <th>Friday</th>
                            <th>Saturday</th>
                            <th>Sunday</th>
                        </tr>
                        <tr className="schedule-table-col">
                            <td>{props.data.mondayTime}</td>
                            <td>{props.data.tuesdayTime}</td>
                            <td>{props.data.wednesdayTime}</td>
                            <td>{props.data.thursdayTime}</td>
                            <td>{props.data.fridayTime}</td>
                            <td>{props.data.sundayTime}</td>
                            <td>{props.data.saturdayTime}</td>
                        </tr>
                    </table>
                </div>

                <br></br>
                <br></br>
                <span>
                    <button type="button" className="btn btn-secondary add-employee-btn-group">Cancel</button>
                    <button type="submit" className="btn btn-success add-employee-btn-group">Add Employee</button>
                </span>
            </form>
            
        </div>
    )
}

export default AddEmployeeComponent