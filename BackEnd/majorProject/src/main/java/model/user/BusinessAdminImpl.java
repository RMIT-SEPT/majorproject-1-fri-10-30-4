package model.user;

import model.interfaces.user.BusinessAdmin;

import javax.persistence.*;

@Entity
@Table(name="business_admin")
public class BusinessAdminImpl implements BusinessAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userID;
    private int businessID;

    public BusinessAdminImpl(int userID, int businessID){
        this.userID = userID;
        this.businessID = businessID;
    }

    @Override
    public int getUserID() {
        return 0;
    }

    @Override
    public int getBusinessID() {
        return 0;
    }
}
