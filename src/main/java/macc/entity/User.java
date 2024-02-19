package macc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "userid")
    private String userid;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private String role;
    @Column(name = "firstlogin")
    private int firstlogin;
    
    public User() {
    }
    
	

	public User(String userid, String password, String email, String role, int firstlogin) {
		super();
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.role = role;
		this.firstlogin = firstlogin;
	}



	public int getFirstlogin() {
		return firstlogin;
	}



	public void setFirstlogin(int firstlogin) {
		this.firstlogin = firstlogin;
	}



	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


    


}