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
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUpController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String birthdate = request.getParameter("birthdate");
		String city = request.getParameter("city");
		String contactno = request.getParameter("contactno");
		
		Student s1 = new Student(name, pwd, contactno, email, birthdate, city);
		
		int status = StudentDao.insertStudent(s1);
		System.out.println(status);
		if(status > 0)
		{
			pw.print("Data Inserted Successfully....");
		}
		else
		{
			pw.print("Something Went Wrong...");
		}
	}

}
