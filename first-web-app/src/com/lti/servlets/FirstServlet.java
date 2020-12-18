package com.lti.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

//@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			/*String name = request.getParameter("fname");
			String password = request.getParameter("pass");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>First Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Welcome " + name + "</h1>");
			out.println("<h1>Password " + password + "</h1>");
			out.println("</body>");
			out.println("</html>");*/
			
			String uname = request.getParameter("uname");
			String password = request.getParameter("pass");
			
			if(uname.equals("isha") && password.equals("isha1234")) {
				
				RequestDispatcher rd = request.getRequestDispatcher("/welcome");
				rd.forward(request, response);
				HttpSession session = request.getSession();
				session.setAttribute("name", uname);
			}
			else {
				System.out.println("Request");
				out.println("Incorrect password and username....");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			}
		}
	}


