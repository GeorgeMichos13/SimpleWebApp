package com.webapp;

import java.io.IOException;

import com.webapp.UserDAO.UserDAO;
import com.webapp.homeadd.HomeAddress;
import com.webapp.user.User;
import com.webapp.workadd.WorkAddress;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterUserSerlvet
 */
@WebServlet("/register")
public class RegisterUserSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterUserSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("RegisterUsers.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String name = (String)request.getParameter("name");
		String surname = (String)request.getParameter("surname");
		String gender = (String)request.getParameter("gender");
		String dob = (String)request.getParameter("dob");
		String workAdd= (String)request.getParameter("workAddress");
		String homeAdd= (String)request.getParameter("homeAddress");
	
		User regUser = new User();
		WorkAddress regWork = new WorkAddress();
		HomeAddress regHome = new HomeAddress();
		
		regUser.setName(name);
		regUser.setSurname(surname);
		regUser.setGender(gender);
		regUser.setDob(dob);
		
		if(workAdd.isEmpty())
			workAdd = null;
		regWork.setWorkAdd(workAdd);
		regWork.setUser(regUser);
		
		if(homeAdd.isEmpty())
			homeAdd = null;
		regHome.setHomeAdd(homeAdd);
		regHome.setUser(regUser);
		
		UserDAO ud = new UserDAO();
		String result = ud.registerUser(regUser,regWork,regHome);
		session.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("RegisterUsers.jsp");
	    rd.forward(request, response);
	}

}
