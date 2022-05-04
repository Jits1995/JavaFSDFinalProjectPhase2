package com.simplilearn.phase2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.phase2.bean.Student;
import com.simplilearn.phase2.dao.StudentDao;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/delete-Student")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int student_id = Integer.parseInt(request.getParameter("student_id"));

		StudentDao studDao = new StudentDao();

		int queryResult = studDao.deleteStudent(student_id);

		if (queryResult > 0) {
			List<Student> student = new ArrayList<>();
			student = studDao.getStudentList();

			String SuccessMessage = "Selected student deleted successfully.";
			request.setAttribute("SuccessMessage", SuccessMessage);
			request.setAttribute("student", student);
		} else {
			String ErrorMessage = "Something went wrong!! selected student not deleted.";
			request.setAttribute("ErrorMessage", ErrorMessage);
		}
		request.getRequestDispatcher("viewStudent.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
