package sampleApp;

import app.model.interfaces.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import app.model.user.UserImpl;
import app.repository.UserRepository;

@RestController
public class SampleController {

	@Autowired
	UserRepository ur;
	
	@RequestMapping("/debug/allTestUsers")
	public String index() {
		ur.save(new UserImpl("test@test.com", "veryGoodPassword", "fname", "lname", 0));
		for(User i:ur.getUsersByEmail("test@test.com")) {
			System.out.println(i.toString());
		}
		return "Check the console";
	}
}
