package com.webapp.workadd;

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
@Table (name = "workAdd")
public class WorkAddress {
	
	@Id
	@Column(name = "idwork")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	@Column(name="work_address")
	String workAdd;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iduserwork")
	@MapsId
	User user;
	
	
	
	//noaddress
	public WorkAddress() {
		super();
		
	}
	
	//addres
	public WorkAddress(int id, String workAdd, User user) {
		super();
		this.id = id;
		this.workAdd = workAdd;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkAdd() {
		return workAdd;
	}
	public void setWorkAdd(String workAdd) {
		this.workAdd = workAdd;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
