package app.controller;


import app.model.user.EmployeeImpl;
import app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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



    /************************************For Testing*****************************************/

    @GetMapping("/all")
    public Iterable<EmployeeImpl> getAllServices() {
        return employeeService.getAll();
    }
}
