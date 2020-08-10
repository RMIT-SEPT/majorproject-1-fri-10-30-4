package dao.interfaces;

import model.interfaces.user.User;

public interface UserDAO {

    /**
     * @param username
     * @param password (Password is hashed or encrypted)
     * @return User if a user with the same username and hashed password is found in the database
     */
    public abstract User getUserByUsernameAndPassword(String username, String password);
}
