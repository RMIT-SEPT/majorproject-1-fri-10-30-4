package model.user;
import model.interfaces.user.User;;

public class UserImpl implements User{

	/**
	 * Create a new User object from scratch.
	 */
	UserImpl();
	
	/**
	 * @param userID ID for the user account you want to access.
	 * Creates a user object from 
	 */
	UserImpl(int userID);
	
	@Override
	public int getUserID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCustomerEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomerPasswordHash() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomerFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomerLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomerFullName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomerAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole getUserRole() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
