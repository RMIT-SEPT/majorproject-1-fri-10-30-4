package app.controller;
import app.entity.BusinessServiceJob;
import app.service.BusinessServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/services")
public class BusinessServiceController {

    @Autowired
    private BusinessServiceService businessServiceService;

    @PostMapping("/create")
    public ResponseEntity<?> createService(@RequestBody BusinessServiceJob newbusinessService, BindingResult result) {
        if(result.hasErrors()){
            String message = "Error: Invalid Business Service object.";
            return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
        }
        BusinessServiceJob businessService = businessServiceService.createService(newbusinessService);
        return new ResponseEntity<>(businessService, HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeService(@RequestParam("serviceID") Integer serviceID){
        String message;
        if(serviceID == null){
            message = "Error: Failed to remove service. Enter a service ID.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        boolean serviceFoundAndRemoved = businessServiceService.removeService(serviceID);
        if(!serviceFoundAndRemoved){
            message = "Error: Failed to remove service #" + serviceID.toString() + "\n"
            + "Service not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        message = "Service #" + serviceID.toString() + " successfully removed.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /************************************For Testing*****************************************/
    @CrossOrigin(origins="*")
    @GetMapping("/all")
    public Iterable<BusinessServiceJob> getAllServices() {
        return businessServiceService.getAll();
    }
}
