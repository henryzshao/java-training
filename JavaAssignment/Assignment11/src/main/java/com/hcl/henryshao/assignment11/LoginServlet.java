package com.hcl.henryshao.assignment11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		String user = request.getParameter("username");
		String pass = request.getParameter("password");

		boolean loginSuccess = false;

		loginSuccess = checkLogin(user, pass);
		//RequestDispatcher rd;

		if (loginSuccess) {
			//rd = request.getRequestDispatcher("./welcome");
			//rd.forward(request, response);
			response.sendRedirect("./html/welcome.html");
		} else {
			//rd = request.getRequestDispatcher("./welcomeError");
			//rd.forward(request, response);
			response.sendRedirect("./html/welcomefailed.html");
		}
	}

	private boolean checkLogin(String user, String pass) throws IOException {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day11", "root", "");
			PreparedStatement ps = conn.prepareStatement("Select * from users where username = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
		}
		return false;
	}

}
