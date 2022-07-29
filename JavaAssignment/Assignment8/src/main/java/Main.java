import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("Java Day 8 Assignment\n");
			StartDB.initializeDatabase("day8");
			StartDB.populateDB("day8");
			Prompt1.execute();
			Prompt2.execute();
			Prompt3.execute();
			Prompt4.execute();
			Prompt5.execute();
			Prompt6.execute();
			StartDB.deleteDatabase("day8");
		} catch (Exception e) {
			
		}
		
	}

}

class StartDB {
	public static void initializeDatabase(String name) throws ClassNotFoundException {
		Connection c = null;
		ResultSet r = null;
		Statement s = null;
		
		try {
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
			
			r = c.getMetaData().getCatalogs();
			
			boolean createDB = true;
			
			while(r.next()) {
				String dbName = r.getString(1);
				if (dbName.equals(name)) {
					createDB = false;
					
				}
			}
			
			System.out.printf("Creating database '%s'\n", name);
			if(createDB) {
				System.out.printf("Created database '%s'\n", name);
				s = c.createStatement();
				String sql = "CREATE DATABASE " + name;
				s.executeUpdate(sql);
			}
			else {
				System.out.println("Database already exists");
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(r != null) {r.close();}
				if(s != null) {s.close();}
				if(c != null) {c.close();}
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}
	}
	
	public static void deleteDatabase(String name) {
		Connection c = null;
		ResultSet r = null;
		Statement s = null;
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
			
			r = c.getMetaData().getCatalogs();
			
			boolean databaseExists = false;
			
			while(r.next()) {
				String dbName = r.getString(1);
				if (dbName.equals(name)) {
					databaseExists = true;
					break;
				}
			}
			
			System.out.printf("\n\nDeleting database '%s'\n", name);
			if(databaseExists) {
				System.out.printf("Deleted database '%s'\n", name);
				s = c.createStatement();
				String sql = "DROP DATABASE " + name;
				s.executeUpdate(sql);
			}
			else {
				System.out.println("Database does not exist");
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(r != null) {r.close();}
				if(s != null) {s.close();}
				if(c != null) {c.close();}
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}
	}
	
	public static void populateDB(String dbName) {
		Connection c = null;
		ResultSet r = null;
		Statement s = null;
		
		try {
			String connectionName = "jdbc:mysql://localhost:3306/" + dbName;
			c = DriverManager.getConnection(connectionName, "root", "");
			System.out.println("Creating table 'employee'");
			if(!tableExists("day8", c, "EMPLOYEE", r)) {
				System.out.println("Table 'employee' does not exist");
				s = c.createStatement();
				String sql = 
						  "CREATE TABLE employee "
						+ "(id INTEGER NOT NULL AUTO_INCREMENT, "
						+ "name VARCHAR(255) NOT NULL,"
						+ "PRIMARY KEY (id))";
				s.executeUpdate(sql);
				System.out.println("Created table: 'employee'");
				StartDB.createprocedure(c, s);
				
				sql = "INSERT INTO employee VALUES (100, 'Amelia')";
				s.executeUpdate(sql);
				sql = "INSERT INTO employee VALUES (101, 'Emily')";
				s.executeUpdate(sql);
				sql = "INSERT INTO employee VALUES (102, 'Rhea')";
				s.executeUpdate(sql);
			} else {
				System.out.println("Table 'employee' exists");
				System.out.println("Created table 'employee'");
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(r != null) {r.close();}
				if(s != null) {s.close();}
				if(c != null) {c.close();}
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}
	}
	
	public static boolean tableExists(String dbName, Connection connection, String tableName, ResultSet resultSet) throws SQLException {
	    DatabaseMetaData meta = connection.getMetaData();	    
	    resultSet = meta.getTables(dbName, null, tableName, new String[] {"TABLE"});
	    return resultSet.next();
	}
	
	public static void createprocedure(Connection c, Statement s) throws SQLException {
		String query = "CREATE PROCEDURE `retrieve`() " +
		         "BEGIN "+
		         " SELECT * FROM employee; "+
		         "END";
		s = c.createStatement();
		s.execute(query);
		System.out.println("Created procedure 'retrieve'");
		
	}
}