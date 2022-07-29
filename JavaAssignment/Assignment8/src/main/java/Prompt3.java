import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
3) Write a program for calling a procedure.
 */

public class Prompt3{

	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 3: JDBC Procedure");
		
		Connection c = null;
		PreparedStatement p = null;
		ResultSet r = null;
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/day8", "root", "");
			Prompt3.selectProc(c, r);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(r != null) {r.close();}
				if(p != null) {p.close();}
				if(c != null) {c.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void selectProc(Connection c, ResultSet r) throws SQLException {
		System.out.println("\n[SELECT] [Procedure] Displaying employees using 'retrieve()'");
		
		CallableStatement cs = c.prepareCall("{call retrieve()}");
		boolean getResult = cs.execute();
		while(getResult) {
			r = cs.getResultSet();
			while(r.next()) {
				System.out.printf("%d %s\n", r.getInt("id"), r.getString("name"));
			}
			getResult = cs.getMoreResults();
		}
		System.out.println();
	}

}