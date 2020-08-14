package app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.model.authorization.SessionImpl;
import app.model.authorization.SessionToken;
import app.repository.SessionRepository;

@RestController
public class AuthorisationController {
	
	@Autowired
	SessionRepository sessionRepository;
	
	@PostMapping("app/authorize/login/getToken")
	public SessionToken getSessionToken(@RequestBody String userId, HttpServletRequest sourceRequest) {
		System.out.println(userId);
		System.out.println(sourceRequest.getRemoteAddr().toString());
		SessionImpl temp = new SessionImpl(Integer.parseInt(userId),sourceRequest.getRemoteAddr().toString(), 1000);
		sessionRepository.save(temp);
		return new SessionToken(temp);
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="UserIdInvalid")
	public void badUserId() {};
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void goodRequest() {};
	
}
