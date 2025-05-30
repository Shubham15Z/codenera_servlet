package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class signupcontroller
 */
@WebServlet("/signupcontroller")
public class signupcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public signupcontroller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		pw.print(user+"<br>");
		pw.print(pwd+"<br>");
		
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dec_2024_db", "root", "Shubham@15");
			
			PreparedStatement ps = con.prepareStatement("insert into signup values(?,?)");
			
			ps.setString(1, user);
			ps.setString(2, pwd);
			
			int status = ps.executeUpdate();
			if(status > 0)
			{
				pw.print("Data Successfully inserted");
			}
			else
			{
				pw.print("Something went wrong..");
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
