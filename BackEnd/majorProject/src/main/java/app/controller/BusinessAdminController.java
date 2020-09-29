package app.controller;

import app.entity.user.BusinessAdmin;
import app.entity.user.Customer;
import app.service.BusinessAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class BusinessAdminController {
    @Autowired
    private BusinessAdminService businessAdminService;

    @GetMapping("/all")
    public Iterable<BusinessAdmin> getAll() {
        return businessAdminService.getAll();
    }
}
