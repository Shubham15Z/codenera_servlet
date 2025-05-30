package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.bo.Student;
import com.dao.StudentDao;

/**
 * Servlet implementation class ViewDataController
 */
@WebServlet("/ViewDataController")
public class ViewDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<h1> Student Information </h>");
		
		List<Student> li = StudentDao.viewData();
		
		pw.print("<table border=2>");
		pw.print("<tr>"
					+"<th>RollNo</th>"
					+"<th>Name</th>"
					+"<th>Password</th>"
					+"<th>ContactNo</th>"
					+"<th>Email</th>"
					+"<th>Birthdate</th>"
					+"<th>City</th>"
				+ "</tr>");
		
		for(Student s : li)
		{
			pw.print("<tr>"
						+"<td>"+s.getRollNo()+"</td>"
						+"<td>"+s.getName()+"</td>"
						+"<td>"+s.getPassword()+"</td>"
						+"<td>"+s.getContactno()+"</td>"
						+"<td>"+s.getEmail()+"</td>"
						+"<td>"+s.getBirthdate()+"</td>"
						+"<td>"+s.getCity()+"</td>"
					+ "</tr>");
		}
		
		pw.print("</table>");
	}

}
