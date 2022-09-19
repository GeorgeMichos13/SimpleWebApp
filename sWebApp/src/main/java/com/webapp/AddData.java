package com.webapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.webapp.homeadd.HomeAddress;
import com.webapp.user.User;
import com.webapp.workadd.WorkAddress;

public class AddData {
	
	public static void main( String[] args )
    {
		
		
		//Read metadata from the annotations associated with this class.
        Configuration con = new Configuration().configure().addAnnotatedClass(User.class)
        		.addAnnotatedClass(HomeAddress.class).addAnnotatedClass(WorkAddress.class);
        //gathers the meta-data which is in the cfg Object. 
        SessionFactory sf = con.buildSessionFactory();		
        Session session = sf.openSession();
        //ACID protocols
        Transaction tx = session.beginTransaction();
      
        User user = new User();
        HomeAddress home = new HomeAddress();
        WorkAddress work = new WorkAddress();
        
        user.setName("George");
        user.setSurname("Michos");
        user.setDob("2022-02-25");
        user.setGender("M");
        home.setHomeAdd("abc");
        home.setUser(user);
        work.setWorkAdd(null);
        work.setUser(user);
        session.save(user);
        session.save(home);
        session.save(work);
        
        user = new User();
        home = new HomeAddress();
        work = new WorkAddress();
        user.setName("Themos");
        user.setSurname("Raptis");
        user.setDob("1998-12-17");
        user.setGender("M");
        home.setHomeAdd(null);
        home.setUser(user);
        work.setWorkAdd("qwe");
        work.setUser(user);
        session.save(user);
        session.save(home);
        session.save(work);
        
        user = new User();
        home = new HomeAddress();
        work = new WorkAddress();
        user.setName("Pavlos");
        user.setSurname("Maniotis");
        user.setDob("1994-4-4");
        user.setGender("M");
        home.setHomeAdd("cba");
        home.setUser(user);
        work.setWorkAdd("asdf");
        work.setUser(user);
        session.save(user);
        session.save(home);
        session.save(work);
        
	   //ACID Protocols
	    tx.commit();
	    sf.close();
	    
	    
        
    }
}
