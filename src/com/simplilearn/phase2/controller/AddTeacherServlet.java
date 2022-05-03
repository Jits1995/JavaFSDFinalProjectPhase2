package com.simplilearn.phase2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.phase2.bean.Teacher;
import com.simplilearn.phase2.dao.TeacherDao;

/**
 * Servlet implementation class addTeacherServlet
 */
@WebServlet("/add-teacher")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTeacherServlet() {
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

		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String gender = request.getParameter("Gender_Type");
		String address = request.getParameter("Address");
		String mobileNo = request.getParameter("MobileNo");
		String experience = request.getParameter("Experience");

		int queryResult = 0;
		String ErrorMessage = null;
		
		if (firstName.equals("") || lastName.equals("") || gender.equals("") || address.equals("")
				|| experience.equals("")) {

			ErrorMessage = "All Fields are required.";

			request.setAttribute("ErrorMessage", ErrorMessage);
			request.getRequestDispatcher("addTeacher.jsp").forward(request, response);

		} else {

			Teacher teacher = new Teacher();
			teacher.setFirstName(firstName);
			teacher.setLastName(lastName);
			teacher.setGender(gender);
			teacher.setAddress(address);
			teacher.setExperience(experience);
			teacher.setMobileNo(mobileNo);
			
			TeacherDao teachDao = new TeacherDao();
			queryResult = teachDao.addTeacher(teacher);

		}

		if (queryResult > 0) {
			String SuccessMessage = firstName + " " + lastName + " teacher added successfully.";
			request.setAttribute("SuccessMessage", SuccessMessage);
		} else if(ErrorMessage == null){
			ErrorMessage = "Something went wrong.";
			request.setAttribute("ErrorMessage", ErrorMessage);
		}

		request.getRequestDispatcher("addTeacher.jsp").forward(request, response);

	}

}
