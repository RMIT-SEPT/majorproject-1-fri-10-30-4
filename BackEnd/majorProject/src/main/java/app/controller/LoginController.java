//package app.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import app.model.authorization.LoginFormObject;
//import app.model.authorization.SessionToken;
//import app.model.user.UserImpl;
//import app.repository.UserRepository;
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//public class LoginController {
//
//	@Autowired
//	UserRepository userRepository;
//
//	@PostMapping(value = "app/login/validate_login")
//	@ResponseBody
//	public boolean login(@RequestBody LoginFormObject formObject, HttpServletRequest request) {
//		System.out.println(formObject.getPasswordHash());
//		boolean result;
//		List<UserImpl> targetUsers = (List<UserImpl>) userRepository.getUsersByEmail(formObject.getUserEmail());
//		if(targetUsers.isEmpty()) {
//			result = false;
//		} else if(targetUsers.get(0).getUserPasswordHash().equals(formObject.getPasswordHash())) {
//			result = true;
//		} else {
//			result = false;
//		}
//		System.out.println(targetUsers.get(0).getUserPasswordHash());
//		return result;
//	}
//}
