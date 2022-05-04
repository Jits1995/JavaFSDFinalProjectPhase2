package com.simplilearn.phase2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.phase2.bean.Subject;
import com.simplilearn.phase2.dao.SubjectDao;

/**
 * Servlet implementation class DeleteSubjectServlet
 */
@WebServlet("/delete-Subject")
public class DeleteSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int subject_id = Integer.parseInt(request.getParameter("subject_id"));

		SubjectDao subDao = new SubjectDao();

		int queryResult = subDao.deleteSubject(subject_id);

		if (queryResult > 0) {
			List<Subject> subject = new ArrayList<>();
			subject = subDao.getSubjectList();

			String SuccessMessage = "Selected subject deleted successfully.";
			request.setAttribute("SuccessMessage", SuccessMessage);
			request.setAttribute("subject", subject);
		} else {
			String ErrorMessage = "Something went wrong!! selected subject not deleted.";
			request.setAttribute("ErrorMessage", ErrorMessage);
		}
		request.getRequestDispatcher("viewSubject.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
