package macc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UserProjects")
public class UserProjects {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_project_id")
    private int user_project_id;
    @Column(name = "userId")
    private String userId;
    @Column(name = "SubscriptionId")
    private String SubscriptionId;
    
    
    
	public UserProjects(int user_project_id, String userId, String subscriptionId) {
		super();
		this.user_project_id = user_project_id;
		this.userId = userId;
		SubscriptionId = subscriptionId;
	}

	public UserProjects() {

	}

	public int getUser_project_id() {
		return user_project_id;
	}
	public void setUser_project_id(int user_project_id) {
		this.user_project_id = user_project_id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSubscriptionId() {
		return SubscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		SubscriptionId = subscriptionId;
	}
    
    
    
    
   

}