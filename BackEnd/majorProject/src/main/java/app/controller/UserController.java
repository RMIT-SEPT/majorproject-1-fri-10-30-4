package app.controller;

import app.payload.JwtLoginSuccessResponse;
import app.payload.LoginRequest;
import app.security.JwtTokenProvider;
import app.service.BusinessAdminService;
import app.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static app.security.SecurityContants.TOKEN_PREFIX;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private BusinessAdminService businessAdminService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        System.out.println("*************");
        System.out.println("Checking errors");
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if(errorMap != null) {
            System.out.println("Has error");
            return errorMap;
        }

        System.out.println("Create auth");
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            System.out.println("Setting auth");
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt;
            if(businessAdminService.exists(loginRequest.getUsername())){
                System.out.println("Admin exists");
                jwt = TOKEN_PREFIX +  tokenProvider.generateBusinessAdminToken(authentication);
            } else {
                System.out.println("Admin does not exist");
                jwt = TOKEN_PREFIX +  tokenProvider.generateCustomerToken(authentication);
            }
            return ResponseEntity.ok(new JwtLoginSuccessResponse(true, jwt));
        } catch(Exception e){
            System.out.println("You made a boo boo");
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Hello", HttpStatus.BAD_REQUEST);
    }

}
