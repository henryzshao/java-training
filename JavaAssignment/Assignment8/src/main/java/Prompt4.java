import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
4) Write a program for Resultset metadata and Database metadata
 */

public class Prompt4{

	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 4: Metadata");
		
		Connection c = null;
		PreparedStatement p = null;
		ResultSet r = null;
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/day8", "root", "");
			Prompt4.resultMeta(c, p, r);
			Prompt4.dbMeta(c, r);
			
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
	
	public static void resultMeta(Connection c, PreparedStatement p, ResultSet r) throws SQLException {
		System.out.println("\n[METADATA] ResultSet");
		p = c.prepareStatement("SELECT * FROM day8.employee");
		r = p.executeQuery();
		ResultSetMetaData rm = r.getMetaData();
		
		int columnCount = rm.getColumnCount();
		System.out.printf("Total Columns: %d\n", columnCount);
		
		for(int i = 1; i <= columnCount; i++) {
			System.out.printf("\nColumn Name %d: %s\n", i, rm.getColumnName(i));
			System.out.printf("Column Type %d: %s\n", i, rm.getColumnTypeName(i));
		}
		System.out.println();
	}
	
	public static void dbMeta(Connection c, ResultSet r) throws SQLException {
		System.out.println("\n[METADATA] Database");
		DatabaseMetaData dm = c.getMetaData();
		
		System.out.printf("Driver Name:           %s\n", dm.getDriverName());
		System.out.printf("Driver Ver:            %s\n", dm.getDriverVersion());
		System.out.printf("Database Username:     %s\n", dm.getUserName());
		System.out.printf("Database Product Name: %s\n", dm.getDatabaseProductName());
		System.out.printf("Database Product Ver:  %s\n", dm.getDatabaseProductVersion());
		System.out.printf("Database Tables:\n");
		r = dm.getTables("day8", null, "%", new String[] {"TABLE"});
		int count = 1;
		while (r.next()) {
		  System.out.printf("     Table %d: %s\n", count++, r.getString(3));
		}
		
		
		System.out.println();
	}

}