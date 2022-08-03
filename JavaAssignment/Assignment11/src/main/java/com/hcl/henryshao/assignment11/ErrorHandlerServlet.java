package com.hcl.henryshao.assignment11;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ErrorHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("URL Error: Redirecting to login!");
		
		System.out.println("URL Error: Redirecting to login!");
		/*
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("./html/login1.jsp");
		rd.forward(request, response);
		*/
		response.sendRedirect("http://localhost:8080/Assignment11/html/login1.jsp");
	}

}
