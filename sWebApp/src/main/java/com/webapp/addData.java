package com.webapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class addData {
	
	public static void main( String[] args )
    {
        user user = new user();
        user.setName("George22");
        user.setSurName("Michos22");
        user.setDob("25/2/2022");
        user.setGender('M');
        
        System.out.println(user.toString());
        
        
        
        
        Configuration con = new Configuration().configure().addAnnotatedClass(user.class);
       
        SessionFactory sf = con.buildSessionFactory();		
        Session session = sf.openSession();
		
        
        //ACID protocols
        Transaction tx = session.beginTransaction();
		 System.out.println("wtf");
      
	   session.save(user);
	   
	   
		 
	    tx.commit();
		
	    sf.close();
	    
	    
        
    }
}
