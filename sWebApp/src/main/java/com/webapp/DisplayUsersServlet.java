package com.webapp;

import java.io.IOException;
import java.util.ArrayList;

import com.webapp.user.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DisplayUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DisplayUsersServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		UserDAO userdao = new UserDAO();
		String res = userdao.getUserData();
		
		ArrayList<User> users = userdao.getUsers();
		
		System.out.println(users.size());
		
		
		session.setAttribute("data", users);
		
		RequestDispatcher rd = req.getRequestDispatcher("DisplayUsers.jsp");
    	rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}


