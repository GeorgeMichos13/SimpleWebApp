package com.webapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.webapp.user.User;

public class AddData {
	
	public static void main( String[] args )
    {
		
		
		//Read metadata from the annotations associated with this class.
        Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
        //gathers the meta-data which is in the cfg Object. 
        SessionFactory sf = con.buildSessionFactory();		
        Session session = sf.openSession();
        //ACID protocols
        Transaction tx = session.beginTransaction();
        
        User user = new User();
        user.setName("George");
        user.setSurName("Michos");
        user.setDob("25/2/2022");
        user.setGender('M');
        session.save(user);
        
        user = new User();
        user.setName("Themos");
        user.setSurName("Raptis");
        user.setDob("17/12/1998");
        user.setGender('M');
        session.save(user);
        
        user = new User();
        user.setName("Pavlos");
        user.setSurName("Maniotis");
        user.setDob("15/7/1994");
        user.setGender('M');
        session.save(user);
        
	   //ACID Protocols
	    tx.commit();
	    sf.close();
	    
	    
        
    }
}
