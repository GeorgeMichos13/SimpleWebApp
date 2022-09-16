package com.webapp;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class displayUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public displayUsersServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		Configuration con = new Configuration().configure();
	      
        SessionFactory sf = con.buildSessionFactory();		
        Session s = sf.openSession();
		
        
        //ACID protocols
        Transaction tx = s.beginTransaction();
		 System.out.println("wtf");
      
		 user user = new user();
		 
		 
		 
	   
	   
		 
	    tx.commit();
		
	    sf.close();
		
		
		
		HttpSession session = req.getSession();
		
		
		
		
		req.setAttribute("label", "asdaS");
		
		RequestDispatcher rd = req.getRequestDispatcher("DisplayUsers.jsp");
    	rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}


