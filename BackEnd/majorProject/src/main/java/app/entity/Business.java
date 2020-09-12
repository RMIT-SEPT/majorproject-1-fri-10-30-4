package app.entity;

import javax.persistence.*;

@Entity
@Table(name="BUSINESS")
public class Business {
    @Id
    @Column(name="BUSINESS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int businessId;

    @Column(name = "BUSINESS_TITLE")
    private String businessTitle;

    public int getBusinessID() { return businessId; }

    public String getBusinessTitle() { return businessTitle; }

    public void setBusinessTitle(String businessTitle) { this.businessTitle = businessTitle; }
}
