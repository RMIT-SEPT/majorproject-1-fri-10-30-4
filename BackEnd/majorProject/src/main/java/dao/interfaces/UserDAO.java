package dao.interfaces;

import model.interfaces.user.User;

import java.sql.SQLException;

public interface UserDAO {

    /**
     * @param email
     * @param hashedPassword (Password is hashed or encrypted)
     * @return User if a user with the same email and hashed password is found in the database
     */
    public abstract User getUserByEmailAndPassword(String email, String hashedPassword);
}
