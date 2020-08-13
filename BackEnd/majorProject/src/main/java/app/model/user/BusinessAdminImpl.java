package app.model.user;

import app.model.interfaces.user.BusinessAdmin;

import javax.persistence.*;

@Entity
@Table(name="business_admin")
public class BusinessAdminImpl implements BusinessAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userID;
    @Column(name="businessID", nullable = false, length=100, unique=true)
    private int businessID;

    
    /**
     * Default constructor needed for Hibernate.
     * Do not use.
     */
    public BusinessAdminImpl() {}
    
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
