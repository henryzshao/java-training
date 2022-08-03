package com.hcl.henryshao.assignment11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String sex = request.getParameter("gender");
		String[] languages = request.getParameterValues("language");

		register(user, pass, sex, languages);

		RequestDispatcher rd;
		rd = request.getRequestDispatcher("./register");
		rd.forward(request, response);

	}

	private void register(String user, String pass, String sex, String[] languages) throws IOException {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/day11", "root", "");
			PreparedStatement s;
			ResultSet r;

			// Register User
			s = c.prepareStatement("INSERT INTO users (username, password, sex) VALUES (?,?,?)");
			s.setString(1, user);
			s.setString(2, pass);
			s.setString(3, sex);
			s.executeUpdate();

			// Get User ID
			int user_id = 0;
			s = c.prepareStatement("SELECT user_id FROM users WHERE username = (?)");
			s.setString(1, user);
			r = s.executeQuery();
			while (r.next()) {
				user_id = r.getInt("user_id");
			}

			// Get Courses
			ArrayList<Integer> langCodeArr = new ArrayList<>();
			for (String lang : languages) {
				s = c.prepareStatement("SELECT course_id FROM courses WHERE course_name = (?)");
				s.setString(1, lang);
				r = s.executeQuery();
				while (r.next()) {
					langCodeArr.add(r.getInt("course_id"));
				}
			}

			// Match UserID to Courses
			for (int langCode : langCodeArr) {
				s = c.prepareStatement("INSERT INTO user_course_junction (user_id, course_id) VALUES (?,?)");
				s.setInt(1, user_id);
				s.setInt(2, langCode);
				s.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
