package com.webapp.UserDAO;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.webapp.homeadd.HomeAddress;
import com.webapp.user.User;
import com.webapp.workadd.WorkAddress;

public class UserDAO {
	
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<HomeAddress> homeAdd = new ArrayList<>();
	private ArrayList<WorkAddress> workAdd = new ArrayList<>();
	private String result = "";
	
	
	
	public SessionFactory config()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class)
				.addAnnotatedClass(HomeAddress.class).addAnnotatedClass(WorkAddress.class);
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
	
public WorkAddress getWorkAddress(int id) {
		
		Session session = this.config().openSession();
		Transaction tx = session.beginTransaction();
		
		workAdd = new ArrayList<WorkAddress>(session.createQuery("from WorkAddress where iduserwork = : id",WorkAddress.class).setParameter("id", id).getResultList());
		WorkAddress work =workAdd.get(0);
		
		System.out.println(work.getWorkAdd());
		if(work.getWorkAdd() == null)
			work.setWorkAdd("N/A");
		
		
		tx.commit();
		session.close();
		
		return work;
	}


	public void deleteUser(int id) {
		
		Session session = this.config().openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		WorkAddress work = new WorkAddress();
		HomeAddress home = new HomeAddress();
		
		
		user.setId(id);
		work.setId(id);
		home.setId(id);
		
		session.delete(user);
		session.delete(home);
		session.delete(work);
		
		tx.commit();
		session.close();
		
		//return result="User deleted successfully";
		
	}
	
	public String registerUser(User user, WorkAddress work, HomeAddress home) {
		
		Session session = this.config().openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(user);
		session.save(work);
		session.save(home);
		
		
		
		tx.commit();
		session.close();
		
		return result = "User has been added";
	}
	
	
	

}
