package com.hcl.henryshao.assignment11;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		String user = (String) session.getAttribute("username");
		String title = (String) session.getAttribute("Title");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<body>\r\n"
				+ "		<h1>Success!</h1>\r\n"
				+ "		<p>Your credentials are correct. Welcome, "+user+", "+title+".</p>\r\n"
				+ "	</body>");
		out.println("<form action = \"./html/login1.jsp\">\r\n"
				+ "			<table>\r\n"
				+ "				<tr>\r\n"
				+ "					<td>\r\n"
				+ "						<input type = \"submit\" value=\"Back to Login\"></td>\r\n"
				+ "				</tr>\r\n"
				+ "			</table>\r\n"
				+ "		</form>");
	}

}

