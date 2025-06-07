package com.controller;

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
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int rollno = Integer.parseInt(request.getParameter("rollno"));
		
		Student s1 = StudentDao.getStudentByRollNo(rollno);
		
		pw.print("<form action='UpdateController' method='post'>");
		pw.print("<table>");
		pw.print("<tr><td></td><td><input type='hidden' name='rollno' value="+s1.getRollNo()+"></td></tr>");
		pw.print("<tr><th>Name : </th><td><input type='text' name='name' value="+s1.getName()+"></td></tr>");
		pw.print("<tr><th>Password : </th><td><input type='password' name='pwd' value="+s1.getPassword()+"></td></tr>");
		pw.print("<tr><th>ContactNo : </th><td><input type='text' name='contactno' value="+s1.getContactno()+"></td></tr>");
		pw.print("<tr><th>Email : </th><td><input type='email' name='email' value="+s1.getEmail()+"></td></tr>");
		pw.print("<tr><th>Birthdate : </th><td><input type='text' name='birthdate' value="+s1.getBirthdate()+"></td></tr>");
		pw.print("<tr><th>City : </th><td><input type='text' name='city' value="+s1.getCity()+"></td></tr>");
		pw.print("<tr><td colspan=2><input type='submit' value='Update'></td></tr>");
		pw.print("</table>");
		pw.print("</form>");
	}

}
