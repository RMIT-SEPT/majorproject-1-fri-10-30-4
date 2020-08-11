package sampleApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.user.UserRepository;
import model.user.UserImpl;

@RestController
public class SampleController {

	@Autowired
	UserRepository ur;
	
	@RequestMapping("/debug/allTestUsers")
	public String index() {
		ur.save(new UserImpl("test@test.com", "veryGoodPassword", "fname", "lname", 0));
		for(model.interfaces.user.User i:ur.getUsersByEmail("test@test.com")) {
			System.out.println(i.toString());
		}
		return "Check the console";
	}
}
