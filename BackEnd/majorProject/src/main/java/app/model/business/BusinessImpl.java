package app.model.business;

import app.model.interfaces.business.Business;

import javax.persistence.*;

@Entity
@Table(name="BUSINESS")
public class BusinessImpl implements Business {
    @Id
    @Column(name="BUSINESS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int businessId;

    @Column(name = "BUSINESS_TITLE")
    private String businessTitle;

    @Override
    public int getBusinessID() { return businessId; }

    @Override
    public String getBusinessTitle() { return businessTitle; }


    public void setBusinessTitle(String businessTitle) { this.businessTitle = businessTitle; }
}
