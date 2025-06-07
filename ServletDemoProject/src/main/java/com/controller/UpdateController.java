package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.bo.Student;
import com.dao.StudentDao;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int rollno = Integer.parseInt(request.getParameter("rollno"));
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		String contactno = request.getParameter("contactno");
		String email = request.getParameter("email");
		String birthdate = request.getParameter("birthdate");
		String city = request.getParameter("city");
		
		Student s = new Student(rollno, name, password, contactno, email, birthdate, city);
		
		int status = StudentDao.updateStudent(s);
		if(status > 0)
		{
			pw.print("<script> alert('Data Updated Successfully...') </script>");
			RequestDispatcher rd = request.getRequestDispatcher("ViewDataController");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script> alert('Something went wrong...') </script>");
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.html");
			rd.forward(request, response);
		}
		
	}

}
