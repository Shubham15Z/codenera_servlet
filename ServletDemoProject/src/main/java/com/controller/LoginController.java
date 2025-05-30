package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		
		
		if(username.equals("admin") && password.equals("admin"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.html");
			rd.forward(request, response);
		}
		else
		{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Wrong username or password!')");
			pw.println("</script>");
			
//			RequestDispatcher rd = request.getRequestDispatcher("login.html");
//			rd.forward(request, response);
		}
	}

}
