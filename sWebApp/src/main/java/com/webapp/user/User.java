package com.webapp.user;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
@Entity
//Declaring the table
@Table (name = "users")
public class User {
	
	//Primary key declaration
		@Id
		@Column(name = "id" )
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@NotNull
		@Column(name = "name")
		private String name;
		
		@NotNull
		@Column (name = "surname")
		private String surname;
		
		@NotNull
		@Column(name = "gender")
		private String gender;
		
		@NotNull
		@Column(name = "dob")
		private String dob;
		
		
		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getSurname() {
			return surname;
		}
		
		public void setSurname(String surName) {
			this.surname = surName;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getGender() {
			return gender;
		}
		
		public void setGender(String gender) {
			this.gender = gender;
		}
		
		public String getDob() {
			return dob;
		}
		
		public void setDob(String dob) {
			this.dob = dob;
		}
		
		
		public String toString() {
			return "Users [name=" + name + ", surName=" + surname + ", gender=" + gender + ", dob=" + dob + "]";
		}

}


