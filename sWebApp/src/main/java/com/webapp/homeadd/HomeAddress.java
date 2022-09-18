package com.webapp.homeadd;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.webapp.user.User;


@Entity
@Table (name = "homeAdd")
public class HomeAddress {
	
	@Id
	@Column(name = "idhome")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	@Column(name="home_address")
	String homeAdd;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iduserhome")
	@MapsId
	User user;
	
	
	
	//noaddress
	public HomeAddress() {
		super();
		
	}
	
	//addres
	public HomeAddress(int id, String homeAdd, User user) {
		super();
		this.id = id;
		this.homeAdd = homeAdd;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHomeAdd() {
		return homeAdd;
	}
	public void setHomeAdd(String homeAdd) {
		this.homeAdd = homeAdd;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
