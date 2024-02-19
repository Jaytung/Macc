package macc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DiscountData")
public class DiscountData {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
    @Column(name = "PricingModel")
    private String PricingModel;
    
    @Column(name = "SubscriptionName")
    private String SubscriptionName;
    
    @Column(name = "Discount")
    private Double Discount;
    
    
   
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPricingModel() {
		return PricingModel;
	}
	public void setPricingModel(String pricingModel) {
		PricingModel = pricingModel;
	}
	public String getSubscriptionName() {
		return SubscriptionName;
	}
	public void setSubscriptionName(String subscriptionName) {
		SubscriptionName = subscriptionName;
	}
	public Double getDiscount() {
		return Discount;
	}
	public void setDiscount(Double discount) {
		Discount = discount;
	}
    
   

}