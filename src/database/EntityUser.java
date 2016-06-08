package database;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.*;
import com.googlecode.objectify.annotation.Index;

@Entity
public class EntityUser {
	
	@Index String username;
	@Index String password;
	@Id String emailid;
	@Index String[] favorites;
	
	public EntityUser(){}
	
	public EntityUser(String username, String password, String emailid,
			String[] favorites) {
		super();
		this.username = username;
		this.password = password;
		this.emailid = emailid;
		this.favorites = favorites;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String[] getFavorites() {
		return favorites;
	}
	public void setFavorites(String[] favorites) {
		this.favorites = favorites;
	}
	
}
