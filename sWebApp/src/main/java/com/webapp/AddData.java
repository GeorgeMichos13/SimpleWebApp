package com.webapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.webapp.homeadd.HomeAddress;
import com.webapp.user.User;

public class AddData {
	
	public static void main( String[] args )
    {
		
		
		//Read metadata from the annotations associated with this class.
        Configuration con = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(HomeAddress.class);
        //gathers the meta-data which is in the cfg Object. 
        SessionFactory sf = con.buildSessionFactory();		
        Session session = sf.openSession();
        //ACID protocols
        Transaction tx = session.beginTransaction();
      
        User user = new User();
        HomeAddress home = new HomeAddress();
        
        user.setName("George");
        user.setSurname("Michos");
        user.setDob("25/2/2022");
        user.setGender("M");
        home.setHomeAdd("abc");
        home.setUser(user);
        session.save(user);
        session.save(home);
        
        user = new User();
        home = new HomeAddress();
        user.setName("Themos");
        user.setSurname("Raptis");
        user.setDob("17/12/1998");
        user.setGender("M");
        home.setHomeAdd(null);
        home.setUser(user);
        session.save(user);
        session.save(home);
        
        user = new User();
        home = new HomeAddress();
        user.setName("Pavlos");
        user.setSurname("Maniotis");
        user.setDob("15/7/1994");
        user.setGender("M");
        home.setHomeAdd("cba");
        home.setUser(user);
        session.save(user);
        session.save(home);
        
	   //ACID Protocols
	    tx.commit();
	    sf.close();
	    
	    
        
    }
}
