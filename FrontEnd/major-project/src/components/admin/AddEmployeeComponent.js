import React from "react"

function AddEmployeeComponent(props){
    return (
        <div>
            <h1 className="add-employee-title">Add Employee</h1>
           
            <form className="add-employee-form">
            <hr></hr>
                <div className="form-group row">
                    <label className="control-label col-sm-1" for="fname">First Name</label>
                    <div className="col-sm-4">
                        <input type="text" className="form-control" id="fname" name="fname"  required></input>
                    </div>
                </div>
                <div className="form-group row">
                    <label className="control-label col-sm-1" for="fname">Last Name</label>
                    <div className="col-sm-4">
                        <input type="text" className="form-control" id="fname" name="fname"  required></input>
                    </div>
                </div>
                <div className="form-group row">
                    <label className="control-label col-sm-1" for="fname">Email</label>
                    <div className="col-sm-4">
                        <input type="email" className="form-control" id="fname" name="fname"  required></input>
                    </div>
                </div>
                <div className="form-group row">
                    <label className="control-label col-sm-1" for="fname">Phone Number</label>
                    <div className="col-sm-4">
                        <input type="text" className="form-control" id="fname" name="fname"  required></input>
                    </div>
                </div>
                <div className="form-group row">
                    <label className="control-label col-sm-1" for="fname">Password</label>
                    <div className="col-sm-4">
                        <input type="password" className="form-control" id="fname" name="fname"  required></input>
                    </div>
                </div>
            
                <hr></hr>
                <h4>Service</h4>
                <br></br>
                <label>
                    <input
                        type="checkbox"
                        name="="
                    /> Service 1
                </label>
                <br></br>
                <label>
                    <input
                        type="checkbox"
                        name=""
                    /> Service 2
                </label>
                <br></br>
                <label>
                    <input
                        type="checkbox"
                        name=""
                    /> Service 3
                </label>
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
                            <select className="form-control">
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
                            <select className="form-control">
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
                            <select className="form-control">
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
                            <select className="form-control">
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
                            <select className="form-control">
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
                            <select className="form-control">
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
                            <select className="form-control">
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
                        <tr>
                            <th className="schedule-table-col">Monday</th>
                            <th className="schedule-table-col">Tuesday</th>
                            <th className="schedule-table-col">Wednesday</th>
                            <th className="schedule-table-col">Thursday</th>
                            <th className="schedule-table-col">Friday</th>
                            <th className="schedule-table-col">Saturday</th>
                            <th className="schedule-table-col">Sunday</th>
                        </tr>
                        <tr>
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
                <span>
                    <button type="button" className="btn btn-secondary add-employee-btn-group">Cancel</button>
                    <button type="submit" className="btn btn-success add-employee-btn-group">Add Employee</button>
                </span>
            </form>
            
        </div>
    )
}

export default AddEmployeeComponent