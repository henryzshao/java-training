package com.hcl.henryshao.assignment11;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class DatabaseInitialization implements ServletContextListener{
	
	Driver myDriver = null;
	
	public void contextInitialized (ServletContextEvent event) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Program Starting");
			//myDriver = StartDB.registerDriver();
			StartDB.createDatabase("day11");
			
			UserTable.createTable("day11");
			CourseTable.createTable("day11");
			UserCourseJunction.createTable("day11");
			
		} catch (ClassNotFoundException e) {
		}
	}
	
	public void contextDestroyed (ServletContextEvent event) {
		StartDB.deleteDatabase("day11");
		//StartDB.deregisterDriver(myDriver);
		System.out.println("Deregistering Driver");
		System.out.println("Program Ending");
	}
}

class StartDB {
	public static Driver registerDriver() throws SQLException {
		Driver myDriver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(myDriver);
		System.out.println("Registering Drivers");
		return myDriver;
	}
	
	public static void deregisterDriver(Driver myDriver) throws SQLException {
		//DriverManager.deregisterDriver(myDriver);
	}
	
	public static void createDatabase(String name) throws ClassNotFoundException {
		Connection c = null;
		ResultSet r = null;
		Statement s = null;
		
		try {
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
	
	
}

class UserTable {
	public static void createTable(String dbName) {
		Connection c = null;
		ResultSet r = null;
		Statement s = null;
		PreparedStatement p = null;
		
		try {
			String connectionName = "jdbc:mysql://localhost:3306/" + dbName;
			c = DriverManager.getConnection(connectionName, "root", "");
			
			s = initiateTable(c, r, s, dbName);
			p = populateTable(c, r, p, dbName);
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(p != null) {p.close();}
				if(r != null) {r.close();}
				if(s != null) {s.close();}
				if(c != null) {c.close();}
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}
	}
	
	private static Statement initiateTable(Connection c, ResultSet r, Statement s, String dbName) throws SQLException {
		String tableName = "users";
		System.out.printf("Creating table '%s'\n", tableName);
		if(!DatabaseHelperClass.tableExists(dbName, c, tableName, r)) {
			System.out.printf("Table '%s' does not exist\n", tableName);
			s = c.createStatement();
			String sql = 
					  "CREATE TABLE "+tableName+" "
					+ "(user_id INTEGER NOT NULL AUTO_INCREMENT, "
					+ "username VARCHAR(255) NOT NULL UNIQUE,"
					+ "password VARCHAR(255) NOT NULL,"
					+ "sex VARCHAR(255) NOT NULL,"
					+ "PRIMARY KEY (user_id))";
			s.executeUpdate(sql);
			System.out.printf("Created table: '%s'\n", tableName);
		} else {
			System.out.printf("Table '%s' already exists\n", tableName);
		}
		return s;
	}
	
	private static PreparedStatement populateTable(Connection c, ResultSet r, PreparedStatement s, String dbName) throws SQLException {
		String tableName = "users";
		System.out.printf("Populating table '%s'\n", tableName);
		if(DatabaseHelperClass.tableExists(dbName, c, tableName, r)) {
			s = c.prepareStatement("INSERT INTO users (username, password, sex) VALUES (?,?,?)");
			s.setString(1, "user");
			s.setString(2, "pass");	
			s.setString(3, "female");
			s.executeUpdate();
			
			s.setString(1, "user1");
			s.setString(2, "pass2");
			s.setString(3, "female");
			s.executeUpdate();
		} else {
			System.out.printf("Table '%s' does not exist, cannot populate\n", tableName);
		}
		return s;
	}
}

class CourseTable {
	public static void createTable(String dbName) {
		Connection c = null;
		ResultSet r = null;
		Statement s = null;
		PreparedStatement p = null;
		
		try {
			String connectionName = "jdbc:mysql://localhost:3306/" + dbName;
			c = DriverManager.getConnection(connectionName, "root", "");
			
			s = initiateTable(c, r, s, dbName);
			p = populateTable(c, r, p, dbName);
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(p != null) {p.close();}
				if(r != null) {r.close();}
				if(s != null) {s.close();}
				if(c != null) {c.close();}
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}
	}
	
	private static Statement initiateTable(Connection c, ResultSet r, Statement s, String dbName) throws SQLException {
		String tableName = "courses";
		System.out.printf("Creating table '%s'\n", tableName);
		if(!DatabaseHelperClass.tableExists(dbName, c, tableName, r)) {
			System.out.printf("Table '%s' does not exist\n", tableName);
			s = c.createStatement();
			String sql = 
					  "CREATE TABLE "+tableName+" "
					+ "(course_id INTEGER NOT NULL AUTO_INCREMENT, "
					+ "course_name VARCHAR(255) NOT NULL UNIQUE,"
					+ "PRIMARY KEY (course_id))";
			s.executeUpdate(sql);
			System.out.printf("Created table: '%s'\n", tableName);
		} else {
			System.out.printf("Table '%s' already exists\n", tableName);
		}
		return s;
	}
	
	private static PreparedStatement populateTable(Connection c, ResultSet r, PreparedStatement s, String dbName) throws SQLException {
		String tableName = "courses";
		System.out.printf("Populating table '%s'\n", tableName);
		if(DatabaseHelperClass.tableExists(dbName, c, tableName, r)) {
			s = c.prepareStatement("INSERT INTO courses (course_name) VALUES (?)");
			s.setString(1, "Java");	
			s.executeUpdate();
			
			s.setString(1, "Python");	
			s.executeUpdate();
			
			s.setString(1, "C++");	
			s.executeUpdate();
		} else {
			System.out.printf("Table '%s' does not exist, cannot populate\n", tableName);
		}
		return s;
	}
}

class UserCourseJunction{
	public static void createTable(String dbName) {
		Connection c = null;
		ResultSet r = null;
		Statement s = null;
		PreparedStatement p = null;
		
		try {
			String connectionName = "jdbc:mysql://localhost:3306/" + dbName;
			c = DriverManager.getConnection(connectionName, "root", "");
			
			s = initiateTable(c, r, s, dbName);
			p = populateTable(c, r, p, dbName);
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(p != null) {p.close();}
				if(r != null) {r.close();}
				if(s != null) {s.close();}
				if(c != null) {c.close();}
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}
	}
	
	private static Statement initiateTable(Connection c, ResultSet r, Statement s, String dbName) throws SQLException {
		String tableName = "user_course_junction";
		System.out.printf("Creating table '%s'\n", tableName);
		if(!DatabaseHelperClass.tableExists(dbName, c, tableName, r)) {
			System.out.printf("Table '%s' does not exist\n", tableName);
			s = c.createStatement();
			String sql = 
					  "CREATE TABLE "+tableName+" "
					+ "("
					+ "user_id INTEGER NOT NULL,"
					+ "course_id INTEGER NOT NULL," 
					+ "CONSTRAINT user_course_pk PRIMARY KEY (user_id, course_id)," 
					+ "CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(user_id),"
					+ "CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES courses(course_id)"
					+ ")";
			s.executeUpdate(sql);
			System.out.printf("Created table: '%s'\n", tableName);
		} else {
			System.out.printf("Table '%s' already exists\n", tableName);
		}
		return s;
	}
	
	private static PreparedStatement populateTable(Connection c, ResultSet r, PreparedStatement s, String dbName) throws SQLException {
		String tableName = "user_course_junction";
		System.out.printf("Populating table '%s'\n", tableName);
		if(DatabaseHelperClass.tableExists(dbName, c, tableName, r)) {
			s = c.prepareStatement("INSERT INTO user_course_junction (user_id, course_id) VALUES (?,?)");
			s.setInt(1, 1);
			s.setInt(2, 2);
			s.executeUpdate();
			
			s.setInt(1, 1);
			s.setInt(2, 3);
			s.executeUpdate();
			
			s.setInt(1, 2);
			s.setInt(2, 1);
			s.executeUpdate();
			
			s.setInt(1, 2);
			s.setInt(2, 2);
			s.executeUpdate();
		} else {
			System.out.printf("Table '%s' does not exist, cannot populate\n", tableName);
		}
		return s;
	}
}

class DatabaseHelperClass {
	public static boolean tableExists(String dbName, Connection connection, String tableName, ResultSet resultSet) throws SQLException {
	    DatabaseMetaData meta = connection.getMetaData();	    
	    resultSet = meta.getTables(dbName, null, tableName, new String[] {"TABLE"});
	    return resultSet.next();
	}
}