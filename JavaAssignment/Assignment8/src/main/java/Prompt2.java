import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
2) Write a program for preparedstatement for doing below operations with positional param
		insert
		select
		Update
 */

public class Prompt2{

	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 2: JDBC PreparedStatement");
		
		Connection c = null;
		PreparedStatement p = null;
		ResultSet r = null;
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/day8", "root", "");
			
			//select
			Prompt2.select(c, p, r);
			
			//insert
			Prompt2.insert(c, p, "Lutecia");
			
			
			//update
			Prompt2.update(c, p, "Katyusha", 100);
			
			//select
			Prompt2.select(c, p, r);
			
			//delete 
			Prompt2.delete(c, p, 103);
			
			//update
			Prompt2.update(c, p, "Amelia", 100);
			
			//select
			Prompt2.select(c, p, r);			
			
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
	
	public static void select(Connection c, PreparedStatement p, ResultSet r) throws SQLException {
		System.out.println("\n[SELECT] Displaying employees");
		p = c.prepareStatement("SELECT * FROM day8.employee");
		r = p.executeQuery();
		while(r.next()) {
			System.out.printf("%d %s\n", r.getInt("id"), r.getString("name"));
		}
		System.out.println();
	}
	
	public static void insert(Connection c, PreparedStatement p, String name) throws SQLException {
		System.out.printf("[INSERT] Transferring %s in\n", name);
		p = c.prepareStatement("INSERT INTO employee (name) VALUES (?)");
		p.setString(1, name);
		p.executeUpdate();
	}
	
	public static void update(Connection c, PreparedStatement p, String name, int id) throws SQLException {
		System.out.println("[UPDATE] Renaming Amelia to Katyusha");			
		p = c.prepareStatement("UPDATE employee SET name = ? WHERE id IN (?)");
		p.setString(1, name);
		p.setInt(2, id);
		p.executeUpdate();
	}
	
	public static void delete(Connection c, PreparedStatement p, int id) throws SQLException {
		System.out.println("[DELETE] Transferring employees out");
		p = c.prepareStatement("DELETE FROM employee WHERE id >= ?");
		p.setInt(1, id);
		p.executeUpdate();
	}

}