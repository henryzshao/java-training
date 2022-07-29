import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
1) Write a program for statement for doing below operations
	insert
	select
	Update
 */

public class Prompt1{

	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 1: JDBC Statement");
		
		Connection c = null;
		ResultSet r = null;
		Statement s = null;
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/day8", "root", "");
			s = c.createStatement();
			
			//select
			Prompt1.select(r, s);
			
			//insert
			Prompt1.insert(s, "Lutecia");
			
			
			//update
			Prompt1.update(s, "Katyusha", 100);
			
			//select
			Prompt1.select(r, s);
			
			//delete 
			Prompt1.delete(s, 103);
			
			//update
			Prompt1.update(s, "Amelia", 100);
			
			//select
			Prompt1.select(r, s);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(r != null) {r.close();}
				if(s != null) {s.close();}
				if(c != null) {c.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void select(ResultSet r, Statement s) throws SQLException {
		System.out.println("\n[SELECT] Displaying employees");
		String sql = "SELECT * FROM employee";
		r = s.executeQuery(sql);
		while(r.next()) {
			System.out.printf("%d %s\n", r.getInt("id"), r.getString("name"));
		}
		System.out.println();
	}
	
	public static void update(Statement s, String name, int id) throws SQLException {
		System.out.println("[UPDATE] Renaming Amelia to Katyusha");
		String sql = "UPDATE employee SET name = '"+name+"' WHERE id IN ("+id+")";
		s.executeUpdate(sql);
	}
	
	public static void insert(Statement s, String name) throws SQLException {
		System.out.printf("[INSERT] Transferring %s in\n", name);
		String sql = "INSERT INTO employee (name) VALUES ('"+name+"')";
		s.executeUpdate(sql);
	}
	
	public static void delete(Statement s, int id) throws SQLException {
		System.out.println("[DELETE] Transferring employees out");
		String sql = "DELETE FROM employee WHERE id >= "+id+"";
		s.executeUpdate(sql);
	}

}