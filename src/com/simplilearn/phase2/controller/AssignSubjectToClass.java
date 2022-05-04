package com.simplilearn.phase2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.phase2.bean.ClassSubject;
import com.simplilearn.phase2.dao.ClassSubjectDao;

/**
 * Servlet implementation class AssignSubjectToClass
 */
@WebServlet("/assign-SubjectToClass")
public class AssignSubjectToClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignSubjectToClass() {
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
		
		String class_id = request.getParameter("class");
		String subject_id[] = request.getParameterValues("subject");
		
		boolean queryResult = false;
		String ErrorMessage = null;
		
		if(class_id == null || subject_id == null){
			ErrorMessage = "Please select class name and subject name to link.";
			request.setAttribute("ErrorMessage", ErrorMessage);	
		}else{
			
			List<ClassSubject> cls_sub = new ArrayList<ClassSubject>();
			
			for(String sub : subject_id){
				
				ClassSubject cs = new ClassSubject();
				cs.setClass_id(Integer.parseInt(class_id));
				cs.setSubject_id(Integer.parseInt(sub));
				
				cls_sub.add(cs);
			}
			
			ClassSubjectDao csd = new ClassSubjectDao();
			queryResult = csd.linkClassToSubject(cls_sub);
		}
		
		if(queryResult){
			String SuccessMessage = "Subject linked to class successfully.";
			request.setAttribute("SuccessMessage", SuccessMessage);
		}else if(ErrorMessage == null){
			ErrorMessage = "Something went wrong.";
			request.setAttribute("ErrorMessage", ErrorMessage);	
		}
		
		request.getRequestDispatcher("assignSubjectToClasses.jsp").forward(request, response);
	}

}
