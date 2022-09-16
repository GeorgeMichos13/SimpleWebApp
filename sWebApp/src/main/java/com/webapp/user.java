package com.webapp;

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
public class user {
	
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
		private String surName;
		
		@NotNull
		@Column(name = "gender")
		private char gender;
		
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
		
		public String getSurName() {
			return surName;
		}
		
		public void setSurName(String surName) {
			this.surName = surName;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public char getGender() {
			return gender;
		}
		
		public void setGender(char gender) {
			this.gender = gender;
		}
		
		public String getDob() {
			return dob;
		}
		
		public void setDob(String dob) {
			this.dob = dob;
		}
		
		
		public String toString() {
			return "Users [name=" + name + ", surName=" + surName + ", gender=" + gender + ", dob=" + dob + "]";
		}

}


