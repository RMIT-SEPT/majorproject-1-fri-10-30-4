package app.controller;


import app.service.BusinessService;
import app.entity.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//TODO:Fix origin mapping for deployment
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping("/create")
    public Business createBusiness(@RequestBody Business business) {
		return businessService.saveBusiness(business);
    }
    
    @GetMapping("/find/{businessID}")
    public ResponseEntity<?> getEmployee(@PathVariable(value="businessID") Integer businessID) {
        String message = "";
        if(businessID == null) {
            message = "Error: User ID required in path parameter.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        Optional<Business> business  = businessService.getById(businessID);
        if(business == null){
            message = "Error: Employee #" + businessID + " not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(business, HttpStatus.OK);
    }
    

    /************************************For Testing*****************************************/

    @CrossOrigin(origins="*")
    @GetMapping("/all")
    public Iterable<Business> getAllEmployees() {
        return businessService.getAll();
    }

    /************************************For Testing*****************************************/
}
