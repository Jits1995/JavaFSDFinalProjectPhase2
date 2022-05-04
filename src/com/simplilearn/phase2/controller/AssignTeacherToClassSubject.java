package com.simplilearn.phase2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.phase2.bean.TeacherClassSubject;
import com.simplilearn.phase2.dao.TeacherToSubjectClassDao;

/**
 * Servlet implementation class AssignTeacherToClassSubject
 */
@WebServlet("/assign-TeacherToClassSubject")
public class AssignTeacherToClassSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignTeacherToClassSubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String teacher = request.getParameter("teacher");
		String classSubject = request.getParameter("classSubject");
		String ErrorMessage = null;
		String SuccessMessage = null;
		boolean queryResult = false;

		if (teacher == "" || classSubject == "") {
			ErrorMessage = "Please select teacher and class subject to link.";
			request.setAttribute("ErrorMessage", ErrorMessage);
		} else {
			
			TeacherClassSubject tcs = new TeacherClassSubject();
			tcs.setTeacher_id(Integer.parseInt(teacher));
			tcs.setClass_subject_id(Integer.parseInt(classSubject));
			
			TeacherToSubjectClassDao tcsd = new TeacherToSubjectClassDao();
			queryResult = tcsd.linkTeacherToClassSubject(tcs);
		}

		if (queryResult) {
			SuccessMessage = "Teacher linked to subject successfully.";
			request.setAttribute("SuccessMessage", SuccessMessage);
		} else if (ErrorMessage == null) {
			ErrorMessage = "Something went wrong.";
			request.setAttribute("ErrorMessage", ErrorMessage);
		}

		request.getRequestDispatcher("assignTeacherToClassForSubject.jsp").forward(request, response);

	}

}
