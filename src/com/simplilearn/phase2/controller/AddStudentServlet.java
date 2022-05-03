package com.simplilearn.phase2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.phase2.bean.Student;
import com.simplilearn.phase2.dao.StudentDao;

/**
 * Servlet implementation class addStudentServlet
 */
@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
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
		String mobileNo = request.getParameter("MobileNo");
		String address = request.getParameter("Address");
		String gender = request.getParameter("Gender_Type");
		String city = request.getParameter("City");
		String classId = request.getParameter("StudentClass");

		int queryResult = 0;
		String SuccessMessage = "";
		String ErrorMessage = null;

		if (firstName.equals("") || lastName.equals("") || mobileNo.equals("") || address.equals("")
				|| gender.equals("") || city.equals("") || classId == "") {
			
			ErrorMessage = "All fields are required.";
			request.setAttribute("ErrorMessage", ErrorMessage);
			
		} else {

			Student student = new Student();
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setMobileNo(mobileNo);
			student.setAddress(address);
			student.setGender(gender);
			student.setCity(city);
			student.setClassId(Integer.parseInt(classId));

			StudentDao studDao = new StudentDao();
			queryResult = studDao.addStudent(student);
		}
		
		if(queryResult > 0){
			SuccessMessage = firstName + " " + lastName + " added successfully.";
			request.setAttribute("SuccessMessage", SuccessMessage);
		}else if(ErrorMessage == null){
			ErrorMessage = "Something went wrong.";
			request.setAttribute("ErrorMessage", ErrorMessage);	
		}

		request.getRequestDispatcher("addStudent.jsp").forward(request, response);
	}

}
