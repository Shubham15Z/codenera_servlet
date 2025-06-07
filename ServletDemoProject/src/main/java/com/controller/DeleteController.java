package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.dao.StudentDao;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int rollNo =Integer.parseInt(request.getParameter("rollno"));
		int status = StudentDao.deleteStudent(rollNo);
		
		if(status > 0)
		{
			pw.print("<script> alert('Data Successfully deleted') </script>");
			RequestDispatcher rd = request.getRequestDispatcher("ViewDataController");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script> alert('Something went wrong...') </script>");
		}
	}

}
