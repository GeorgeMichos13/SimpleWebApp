package com.webapp.UserDAO;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.webapp.homeadd.HomeAddress;
import com.webapp.user.User;

public class UserDAO {
	
	public ArrayList<User> users = new ArrayList<>();
	public ArrayList<HomeAddress> homeAdd = new ArrayList<>();
	public String retrResult = "not";
	
	
	public SessionFactory config()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(HomeAddress.class);
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
	
	public User getUserDetails(int id) {
		
		Session session = this.config().openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(id);
		
		users = new ArrayList<User>(session.createQuery("from User where id=:id",User.class).setParameter("id", id).getResultList());
		
		
		User user = users.get(0);
		
		
		tx.commit();
		session.close();
		
		return user;
	}
	
	
	
	public HomeAddress getHomeAddress(int id) {
		
		Session session = this.config().openSession();
		Transaction tx = session.beginTransaction();
		
		homeAdd = new ArrayList<HomeAddress>(session.createQuery("from HomeAddress where iduserhome = : id",HomeAddress.class).setParameter("id", id).getResultList());
		HomeAddress home =homeAdd.get(0);
		
		System.out.println(home.getHomeAdd());
		if(home.getHomeAdd() == null)
			home.setHomeAdd("N/A");
		
		
		tx.commit();
		session.close();
		
		return home;
	}
	
	
	
	public ArrayList<HomeAddress> getHomeAddress(){
		return homeAdd;
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}

}
