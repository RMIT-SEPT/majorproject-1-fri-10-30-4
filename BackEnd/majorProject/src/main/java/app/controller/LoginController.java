package app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.model.authorization.SessionToken;
import app.model.user.UserImpl;
import app.repository.UserRepository;

@RestController
public class LoginController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("app/login")
	public boolean login(HttpServletRequest request, String userEmail, String password_hash) {
		List<UserImpl> targetUsers = (List<UserImpl>) userRepository.getUsersByEmail(userEmail);
		if(targetUsers.isEmpty()) {
			this.badEmailResponse();
		} else if(targetUsers.get(0).getUserPasswordHash().equals(password_hash)) {
			this.goodLoginRequest();
		} else {
			this.badPasswordResponse();
		}
		return true;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="Email not associated with any account.")
	private static void badEmailResponse() {};
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="Incorrect Password")
	private static void badPasswordResponse() {};
	
	@ResponseStatus(code = HttpStatus.CONFLICT, reason="Error creating session token.")
	private static void unableToCreateToken() {};
	
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	private static void goodLoginRequest() {};
}
