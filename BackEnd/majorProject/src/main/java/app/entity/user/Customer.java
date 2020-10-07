package app.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer extends User{

    @Column(name="ADDRESS")
    private String address;

    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
