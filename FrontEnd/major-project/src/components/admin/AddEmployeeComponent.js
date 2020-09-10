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
                <div className="form-group row">
                    <label className="control-label col-sm-1" for="fname">Availability</label>
                    <div className="col-sm-4">
                        <select>
                            <option value ="9am">Morning: 9am - 12pm</option>
                            <option value ="12pm">Afternoon: 12pm - 3pm</option>
                            <option value ="3pm">Late Afternoon: 3pm - 6pm</option>
                        </select>
                    </div>
                </div>
                <hr></hr>
                <h4>Services</h4>
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
                <br></br>
                <span>
                    <button className="btn btn-secondary add-employee-btn-group">Cancel</button>
                    <button className="btn btn-success add-employee-btn-group">Add Employee</button>
                </span>
            </form>
            
        </div>
    )
}

export default AddEmployeeComponent