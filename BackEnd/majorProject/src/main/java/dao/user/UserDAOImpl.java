package dao.user;
import dao.interfaces.UserDAO;
import dbtools.DBConnection;
import model.interfaces.user.User;
import model.user.UserImpl;
import model.user.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    public User getUserByEmailAndPassword(String email, String hashedPassword){
        List<User> users = new ArrayList();
        Connection con = DBConnection.getNewDBConnection();
        String sql = "SELECT * FROM user WHERE EMAIL=? AND PASSWORD_HASH=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, hashedPassword);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                String strUserRole = result.getString("role");
                UserRole userRole = UserRole.valueOf(strUserRole);
                User retrievedUser = new UserImpl(
                                    result.getInt("user_id"),
                                    userRole,
                                    result.getString("email"),
                                    result.getString("password_hash"),
                                    result.getString(("first_name")),
                                    result.getString(("last_name")));
                users.add(retrievedUser);
            }
        } catch (SQLException e){
            // Error
        }
        DBConnection.closeDBConnection(con);
        User user = users.get(0);
        if(user == null) {
            return null;
        } else {
            return user;
        }
    }


}