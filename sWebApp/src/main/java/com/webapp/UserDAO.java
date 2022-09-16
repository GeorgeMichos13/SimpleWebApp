package com.webapp;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.webapp.user.User;

public class UserDAO {
	
	public ArrayList<User> users = new ArrayList<>();
	
	public SessionFactory config()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = con.buildSessionFactory();
		
		return sf;
	}
	
	public String getUserData()
	{

		String result = "Data retrieved successfully";
		
		Session session = this.config().openSession();
		Transaction tx = session.beginTransaction();
		
		users = new ArrayList<User>(session.createQuery("from User",User.class).getResultList());
		
		
		tx.commit();
		session.close();
		
		return result;
	}
	
	
	public ArrayList<User> getUsers(){
		return users;
	}

}
