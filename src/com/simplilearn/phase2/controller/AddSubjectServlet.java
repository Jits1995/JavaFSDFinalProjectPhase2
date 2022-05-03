package com.simplilearn.phase2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.phase2.bean.Subject;
import com.simplilearn.phase2.dao.ClassDao;
import com.simplilearn.phase2.dao.SubjectDao;

/**
 * Servlet implementation class addSubjectServlet
 */
@WebServlet("/add-subject")
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectServlet() {
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
		
		String subjectName = request.getParameter("SubjectName");
		int queryResult = 0;
		String ErrorMessage = null;
		
		if(subjectName == null || subjectName == ""){
			ErrorMessage = "Please enter class name.";
			request.setAttribute("ErrorMessage", ErrorMessage);	
		}else{
			
			SubjectDao subDao = new SubjectDao();
			Subject sub = new Subject();
			sub.setSubjectName(subjectName);
			queryResult = subDao.addSubject(sub);
		}
		
		if(queryResult > 0){
			String SuccessMessage = subjectName + " added successfully.";
			request.setAttribute("SuccessMessage", SuccessMessage);
		}else if(ErrorMessage == null){
			ErrorMessage = "Something went wrong.";
			request.setAttribute("ErrorMessage", ErrorMessage);	
		}
		
		request.getRequestDispatcher("addSubject.jsp").forward(request, response);
		
	}

}
