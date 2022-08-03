<html>

	<head><title>Login (Username) Page</title></head>
	
	<body>
		<form action = "../loginhelper">
			<table>
				<tr>
					<td>
						Username: <Input type = "text" name = "username"/> </td></tr> 
				<tr>
					<td>
						<input type = "submit" value="Next"></td>
				</tr>
			</table>
		</form>
	</body>
	
	<body>
		Example Username : user <br/>
	</body>
	
	<body>
		<form action = "../index.html">
			<table>
				<tr>
					<td>
						<input type = "submit" value="Go to Directory"></td>
				</tr>
			</table>
		</form>
	</body>
	<%=new java.util.Date()%>
	<%
		out.println("This is inside of a JSP");
		System.out.println("This is inside of a JSP");
		session.setAttribute("Title", "O Great One");
	%>
	
	
	
</html>