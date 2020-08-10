package model.user;
import model.interfaces.user.User;;

public class UserImpl implements User{

	/**
	 * Create a new User object from scratch.
	 */
	UserImpl(){

	}
	
	/**
	 * @param userID ID for the user account you want to access.
	 * Creates a user object from 
	 */
	UserImpl(int userID) {

	}
	
	@Override
	public int getUserID() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public UserRole getUserRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserEmail(){
		return "";
	}

	@Override
	public String getUserPasswordHash() {
		return "";
	}

	@Override
	public String getUserFirstName() {
		return "";
	}

	@Override
	public String getUserLastName() {
		return "";
	}

	@Override
	public String getUserFullName() {
		return "";
	}
	
	

}
