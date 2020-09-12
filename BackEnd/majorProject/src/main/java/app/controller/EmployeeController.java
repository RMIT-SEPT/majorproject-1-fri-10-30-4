package app.controller;


import app.entity.user.Employee;
import app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")

    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee, BindingResult result) {
        if(result.hasErrors()){
            String message = "Error: Invalid Employee object.";
            return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
        }
        Employee employeeResponseEntity = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeeResponseEntity, HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeEmployee(@RequestParam("employeeId") Integer employeeId){
        String message;
        if(employeeId == null){
            message = "Error: Failed to remove User. Enter a user ID.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        boolean foundAndRemoved = employeeService.removeEmployee(employeeId);
        if(!foundAndRemoved){
            message = "Error: Failed to remove service #" + employeeId.toString() + "\n"
                    + "User not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        message = "User #" + employeeId.toString() + " successfully removed.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/remove-all")
    public ResponseEntity<String> removeAllEmployees() {
        employeeService.removeAll();
        return new ResponseEntity<>("All employees removed.", HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployee(@PathVariable(value="employeeId") Integer employeeId) {
        String message = "";
        if(employeeId == null) {
            message = "Error: User ID required in path parameter.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        Optional<Employee> employee = employeeService.getEmployee(employeeId);
        if(employee == null){
            message = "Error: Employee #" + employeeId + " not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    /************************************For Testing*****************************************/



}
