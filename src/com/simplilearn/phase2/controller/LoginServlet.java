package com.simplilearn.phase2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.phase2.bean.Login;
import com.simplilearn.phase2.dao.LoginDao;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String ErrorMessage = "";
		boolean login_flag = false;
		
		if(username == null && password == null){
			ErrorMessage = "Username and password can not be empty";
		}else if(username == null){
			ErrorMessage = "Username can not be empty";
		}else if(password == null){
			ErrorMessage = "Password can not be empty";
		}else{
			
			Login login = new Login();
			login.setUsername(username);
			login.setPassword(password);
			
			LoginDao login_dao = new LoginDao();
			login_flag = login_dao.loginCheck(login);
			
		}
		
		if(login_flag){
			response.sendRedirect("home.jsp");
			HttpSession httpSession = request.getSession();  
	        httpSession.setAttribute("username",username);
		}else{
			ErrorMessage = "username and password are incorrect.";
			request.setAttribute("ErrorMessage", ErrorMessage);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

}
