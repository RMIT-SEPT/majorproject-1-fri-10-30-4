package app.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import app.model.authorization.LoginFormObject;
import app.model.authorization.SessionImpl;
import app.model.authorization.SessionToken;
import app.model.user.UserImpl;
import app.repository.SessionRepository;
import app.repository.UserRepository;

@RestController
public class AuthorisationController {
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	@PostMapping(value ="app/authorize/login/getToken")
	@ResponseBody
	public SessionToken getSessionToken(@RequestBody LoginFormObject formObject, HttpServletRequest sourceRequest) {
		SessionToken result;
		System.out.println(formObject.getUserEmail());
		System.out.println(sourceRequest.getRemoteAddr().toString());
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/app/login/validate_login", formObject, String.class);
		System.out.println(response.getBody());
		switch(response.getBody()) {
			case("true"):
				List<UserImpl> targetUsers = (List<UserImpl>) userRepository.getUsersByEmail(formObject.getUserEmail());
				int userId = targetUsers.get(0).getUserId();
				SessionImpl temp = new SessionImpl(userId,sourceRequest.getRemoteAddr().toString(), 1000);
				sessionRepository.save(temp);
				result = new SessionToken(temp);
				break;
			case("false"):
			default:
				//Returns HTTP code 400.
				throw new BadLoginException();
		}
		return result;
	}
	
	/**
	 * Automatic Spring code, returns a HTTP 400 response if thrown.
	 * Body can be added later to log details if required.
	 */
	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public class BadLoginException extends RuntimeException{};
	
}
