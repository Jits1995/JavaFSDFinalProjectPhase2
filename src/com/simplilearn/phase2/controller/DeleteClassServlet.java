package com.simplilearn.phase2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.phase2.bean.Classes;
import com.simplilearn.phase2.dao.ClassDao;

/**
 * Servlet implementation class DeleteClassServlet
 */
@WebServlet("/delete-Classes")
public class DeleteClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int class_id = Integer.parseInt(request.getParameter("class_id"));
		ClassDao classDao = new ClassDao();
		
		int queryResult = classDao.deleteClass(class_id);
		
		if(queryResult > 0){
			List<Classes> classes = new ArrayList<>();
			classes = classDao.getClassList();		
		
			String SuccessMessage = "Selected class deleted successfully.";
			request.setAttribute("SuccessMessage", SuccessMessage);			
			request.setAttribute("classes", classes);
		}else{
			String ErrorMessage = "Something went wrong!! selected class not deleted.";
			request.setAttribute("ErrorMessage", ErrorMessage);
		}
		request.getRequestDispatcher("viewClass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
