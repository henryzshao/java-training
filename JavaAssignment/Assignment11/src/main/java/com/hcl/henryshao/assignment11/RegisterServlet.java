package com.hcl.henryshao.assignment11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ArrayList<RegisteredUser> userArr = getRecords();

		for (RegisteredUser user : userArr) {
			out.println("User ID: " + user.getID() + "<br/>");
			out.println("User Name: " + user.getName() + "<br/>");
			out.println("User Sex: " + user.getSex() + "<br/>");
			out.println("User Courses: <br/>");
			ArrayList<Course> courses = user.getCourse();
			for (Course course : courses) {
				out.println("------>" + course.getCourse() + "<br/>");
			}

		}

	}

	private ArrayList<RegisteredUser> getRecords() throws IOException {
		ArrayList<RegisteredUser> userArr = new ArrayList<RegisteredUser>();
		try {

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/day11", "root", "");
			PreparedStatement p;
			ResultSet r;

			p = c.prepareStatement("Select users.user_id, users.username, users.sex, courses.course_id "
					+ "FROM user_course_junction " + "JOIN users on user_course_junction.user_id = users.user_id "
					+ "JOIN courses on user_course_junction.course_id = courses.course_id "
					+ "ORDER BY users.user_id, courses.course_id;");
			r = p.executeQuery();
			while (r.next()) {
				int id = r.getInt("user_id");
				String name = r.getString("username");
				String sex = r.getString("sex");
				int course = r.getInt("course_id");
				RegisteredUser newUser = new RegisteredUser(id, name, sex);

				if (userArr.contains(newUser)) {
					newUser = userArr.get(userArr.indexOf(newUser));
					newUser.addCourse(course);
				} else {
					userArr.add(newUser);
					newUser.addCourse(course);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userArr;
	}

}