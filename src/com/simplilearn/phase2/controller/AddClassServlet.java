package com.simplilearn.phase2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.phase2.dao.ClassDao;

/**
 * Servlet implementation class AddClassServlet
 */
@WebServlet("/add-class")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassServlet() {
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
		
		String className = request.getParameter("ClassName");
		int queryResult = 0;
		String ErrorMessage = null;
		
		if(className == null || className == ""){
			ErrorMessage = "Please enter class name.";
			request.setAttribute("ErrorMessage", ErrorMessage);	
		}else{
			
			ClassDao clsDao = new ClassDao();
			queryResult = clsDao.addClass(className);
		}
		
		if(queryResult > 0){
			String SuccessMessage = className + " added successfully.";
			request.setAttribute("SuccessMessage", SuccessMessage);
		}else if(ErrorMessage == null){
			ErrorMessage = "Something went wrong.";
			request.setAttribute("ErrorMessage", ErrorMessage);	
		}
		
		request.getRequestDispatcher("addClass.jsp").forward(request, response);
		
	}
}
