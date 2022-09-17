package com.webapp.UserDAO;


import java.sql.ResultSet;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.webapp.user.User;

public class UserDAO {
	
	public ArrayList<User> users = new ArrayList<>();
	public String retrResult = "not";
	
	
	public SessionFactory config()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = con.buildSessionFactory();
		
		return sf;
	}
	
	public ArrayList<User> getUserData()
	{

		
		Session session = this.config().openSession();
		Transaction tx = session.beginTransaction();
		
		users = new ArrayList<User>(session.createQuery("from User",User.class).getResultList());
		
		
		tx.commit();
		session.close();
		retrResult = "Data sucefully retrivied";
		return users;
	}
	
	public User getUser(int id) {
		
		Session session = this.config().openSession();
		Transaction tx = session.beginTransaction();
		
		
		users = new ArrayList<User>(session.createQuery("from User",User.class).getResultList());
		User user = users.get(id);
		
		tx.commit();
		session.close();
		
		return user;
	}
	
	
	
	
	public ArrayList<User> getUsers(){
		return users;
	}

}
