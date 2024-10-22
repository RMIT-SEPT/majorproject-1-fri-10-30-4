package app.controller;

import app.entity.user.BusinessAdmin;
import app.service.BusinessAdminService;
import app.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class BusinessAdminController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private BusinessAdminService businessAdminService;


    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody BusinessAdmin businessAdmin, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;
        businessAdminService.save(businessAdmin);
        return new  ResponseEntity<BusinessAdmin>(businessAdmin, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<BusinessAdmin> getAll() {
        return businessAdminService.getAll();
    }
}
