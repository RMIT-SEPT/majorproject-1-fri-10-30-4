package app.controller;
import app.model.businessservice.BusinessServiceImpl;
import app.service.BusinessServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
public class BusinessServiceController {

    @Autowired
    private BusinessServiceService businessServiceService;

    @GetMapping("/all")
    public Iterable<BusinessServiceImpl> getAllServices() {
        return businessServiceService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<BusinessServiceImpl> createService(@RequestBody BusinessServiceImpl newbusinessService, BindingResult bindingResult) {
        BusinessServiceImpl businessService = businessServiceService.createService(newbusinessService);
        return new ResponseEntity<>(businessService, HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeService(@RequestParam("serviceID") Integer serviceID){
        String message;
        if(serviceID == null){
            message = "Failed to remove service. Enter a service ID.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        boolean serviceFoundAndRemoved = businessServiceService.removeService(serviceID);
        if(!serviceFoundAndRemoved){
            message = "Failed to remove service #" + serviceID.toString() + "\n"
            + "Service not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        message = "Service #" + serviceID.toString() + " successfully removed.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


}
