package app.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class BusinessAdmin extends User {

    @Column(name="BUSINESS_NAME")
    private String businessName;

    @Column(name="BUSINESS_DESC")
    private String businessDesc;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessDesc() {
        return businessDesc;
    }

    public void setBusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc;
    }
}
