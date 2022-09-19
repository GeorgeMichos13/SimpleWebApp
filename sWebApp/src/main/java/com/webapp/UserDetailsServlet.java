package com.webapp;

import java.io.IOException;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.webapp.UserDAO.UserDAO;
import com.webapp.homeadd.HomeAddress;
import com.webapp.user.User;
import com.webapp.workadd.WorkAddress;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		UserDAO userdao = new UserDAO();
		
		String attr = req.getParameter("id");
		if(attr != null && !attr.isEmpty()) {
			int id = Integer.parseInt(attr);
			
			User user = userdao.getUserDetails(id);
			HomeAddress home = userdao.getHomeAddress(id);
			WorkAddress work = userdao.getWorkAddress(id);
			
			session.setAttribute("user", user);
			session.setAttribute("home", home);
			session.setAttribute("work", work);
			
		}
		
		
		
		String idDelete = req.getParameter("idToDelete");
		
		if(idDelete != null && !idDelete.isEmpty()) {
			int idtd = Integer.parseInt(idDelete);
			userdao.deleteUser(idtd);
			
		}
		
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("UserDetails.jsp");
    	rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		
	}

}
