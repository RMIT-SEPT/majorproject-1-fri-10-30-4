package app.controller;


import app.model.businessservice.BusinessServiceImpl;
import app.model.user.EmployeeImpl;
import app.repository.EmployeeRepository;
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
    public ResponseEntity<String> removeEmployee(@RequestParam("employeeID") Integer employeeID){
        String message;
        if(employeeID == null){
            message = "Error: Failed to remove service. Enter a service ID.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        boolean foundAndRemoved = employeeService.removeEmployee(employeeID);
        if(!foundAndRemoved){
            message = "Error: Failed to remove service #" + employeeID.toString() + "\n"
                    + "Service not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        message = "Service #" + employeeID.toString() + " successfully removed.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /************************************For Testing*****************************************/

    @GetMapping("/all")
    public Iterable<EmployeeImpl> getAllServices() {
        return employeeService.getAll();
    }
}
