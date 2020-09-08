package app.controller;


import app.model.interfaces.user.Employee;
import app.model.user.EmployeeImpl;
import app.model.user.UserImpl;
import app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeImpl newEmployee, BindingResult result) {
        if(result.hasErrors()){
            String message = "Error: Invalid Business Service object.";
            return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
        }
        EmployeeImpl employee = employeeService.createEmployee(newEmployee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeEmployee(@RequestParam("userId") Integer userId){
        String message;
        if(userId == null){
            message = "Error: Failed to remove User. Enter a user ID.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        boolean foundAndRemoved = employeeService.removeEmployee(userId);
        if(!foundAndRemoved){
            message = "Error: Failed to remove service #" + userId.toString() + "\n"
                    + "User not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        message = "User #" + userId.toString() + " successfully removed.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/remove-all")
    public ResponseEntity<String> removeAllEmployees() {
        employeeService.removeAll();
        return new ResponseEntity<>("All employees removed.", HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getEmployee(@PathVariable(value="userId") Integer userId) {
        String message = "";
        if(userId == null) {
            message = "Error: User ID required in path parameter.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        Optional<EmployeeImpl> employee = employeeService.getEmployee(userId);
        if(employee == null){
            message = "Error: Employee #" + userId + " not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }



    /************************************For Testing*****************************************/

    @GetMapping("/all")
    public Iterable<EmployeeImpl> getAllEmployees() {
        return employeeService.getAll();
    }
}
