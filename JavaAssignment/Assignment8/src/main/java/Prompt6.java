import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Prompt6{

	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 6: Batch");
		
		Connection c = null;
		PreparedStatement p = null;
		Statement s = null;
		ResultSet r = null;
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/day8", "root", "");
			p = c.prepareStatement("INSERT INTO employee (name) VALUES (?)");
			Prompt6.insertPreparedBatch(c, p, "Lily");
			Prompt6.insertPreparedBatch(c, p, "Galatea");
			Prompt6.insertPreparedBatch(c, p, "Irene");
			System.out.println("Executing Batch");
			p.executeBatch();
			Prompt2.select(c, p, r);
			Prompt2.delete(c, p, 103);
			
			s = c.createStatement();
			Prompt6.insertStatementBatch(p, "Sophia");
			Prompt6.insertStatementBatch(p, "Ophelia");
			Prompt6.insertStatementBatch(p, "Elizabeth");
			System.out.println("Executing Batch");
			s.executeBatch();
			Prompt2.select(c, p, r);
			Prompt2.delete(c, p, 103);
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(r != null) {r.close();}
				if(p != null) {p.close();}
				if(s != null) {s.close();}
				if(c != null) {c.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insertPreparedBatch(Connection c, PreparedStatement p, String name) throws SQLException {
		System.out.printf("[INSERT] Transferring %s in\n", name);
		p.setString(1, name);
		p.addBatch();
	}
	
	public static void insertStatementBatch(Statement s, String name) throws SQLException {
		System.out.println("[INSERT] Transferring Lutecia in");
		String sql = "INSERT INTO employee (name) VALUES ('"+name+"')";
		s.addBatch(sql);
	}

}