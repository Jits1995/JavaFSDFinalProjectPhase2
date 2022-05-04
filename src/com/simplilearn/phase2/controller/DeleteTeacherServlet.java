package com.simplilearn.phase2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.phase2.bean.Teacher;
import com.simplilearn.phase2.dao.TeacherDao;

/**
 * Servlet implementation class DeleteTeacherServlet
 */
@WebServlet("/delete-Teacher")
public class DeleteTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));

		TeacherDao teachDao = new TeacherDao();

		int queryResult = teachDao.deleteTeacher(teacher_id);

		if (queryResult > 0) {
			List<Teacher> teacher = new ArrayList<>();
			teacher = teachDao.getTeacherList();

			String SuccessMessage = "Selected teacher deleted successfully.";
			request.setAttribute("SuccessMessage", SuccessMessage);
			request.setAttribute("teacher", teacher);
		} else {
			String ErrorMessage = "Something went wrong!! selected teacher not deleted.";
			request.setAttribute("ErrorMessage", ErrorMessage);
		}
		request.getRequestDispatcher("viewTeacher.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
