package com.hcl.henryshao.assignment11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginfinal")
public class LoginFinalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		HttpSession session = request.getSession();	
		String user = (String) session.getAttribute("username");
		System.out.println("Login Final: " + user);
		
		String pass = request.getParameter("password");
		System.out.println(user);
		System.out.println(pass);

		boolean loginSuccess = false;

		loginSuccess = checkLogin(user, pass);

		if (loginSuccess) {
			response.sendRedirect("./welcome");
		} else {
			response.sendRedirect("./welcomeError");
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
