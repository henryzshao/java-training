import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
5) Write a program for transaction management.
 */

public class Prompt5{

	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 5: Transaction Management");
		
		Connection c = null;
		PreparedStatement p = null;
		ResultSet r = null;
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/day8", "root", "");
			c.setAutoCommit(false);
			System.out.println("\nTurning off AutoCommit...");
			
			Prompt2.insert(c, p, "Lily");
			Prompt2.insert(c, p, "Galatea");
			
			Prompt2.select(c, p, r);
			
			System.out.println("Rolling Back...");
			c.rollback();
			
			Prompt2.select(c, p, r);
			
			Prompt2.insert(c, p, "Lily");
			System.out.println("Committing...");
			c.commit();
			
			Prompt2.select(c, p, r);
			
			Prompt2.delete(c, p, 103);
			c.commit();
			c.setAutoCommit(true);
			
			
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

}