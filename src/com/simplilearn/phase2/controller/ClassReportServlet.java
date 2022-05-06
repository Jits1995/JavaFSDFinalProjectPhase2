package com.simplilearn.phase2.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.phase2.bean.Classes;
import com.simplilearn.phase2.dao.ClassReportDao;

/**
 * Servlet implementation class ClassReport
 */
@WebServlet("/class-Report")
public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClassReportDao clsDao = new ClassReportDao();
		List<Classes> classes =  clsDao.getClassList();
		
		request.setAttribute("classes", classes);
		request.getRequestDispatcher("classReport.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String class_id = request.getParameter("class");	
		String ErrorMessage = null;
		HashMap<String, List> map = new HashMap<>();
		ClassReportDao crd = new ClassReportDao();
		
		if(class_id == null || class_id == ""){
			ErrorMessage = "Please select class name to generate the report.";
			request.setAttribute("ErrorMessage", ErrorMessage);	
		}else{
			
			map = crd.getClassReport(Integer.parseInt(class_id));	
			request.setAttribute("classReport", map.get("classReport"));
			request.setAttribute("studentReport", map.get("studentReport"));
		}
		
		if(map.size() > 0){
			String SuccessMessage = "class report generated successfully.";
			request.setAttribute("SuccessMessage", SuccessMessage);
		}else if(ErrorMessage == null){
			ErrorMessage = "Something went wrong.";
			request.setAttribute("ErrorMessage", ErrorMessage);	
		}
		
		List<Classes> classes =  crd.getClassList();
		
		request.setAttribute("classes", classes);
		request.getRequestDispatcher("classReport.jsp").forward(request, response);
		
	}

}
