package com.qa.jdbcRead;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {

	// STEP 1
	// JDBC driver - This tell java what driver we need to use
	final String JDBC_DRIVER = "com.sql.jdbc.Driver";

	// Sql url that needs to be used for our CRUD statements
	final static String DB_URL = "jdbc:mysql://localhost/student";

	// username and password
	final static String USER = "root";
	final static String PASS = "root";

	public static void main(String[] args) {

		// STEP 2
		Connection conn = null;
		Statement stmt = null;

		try {
			// register for the JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 3 - open some connection
			System.out.println("Connecting to the selected database");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("db connection success");

			// STEP 4 - execute our query
			System.out.println("reading a record from the db");
			stmt = conn.createStatement();

			String sql = "SELECT id, fName,sName,age FROM students";
//				String sql = "SELECT id, fName,sName,age FROM students where fName ='Sam'";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5 - we need to extract the data we want
			while (rs.next()) {
				int id = rs.getInt("id");
				String fistName = rs.getString("fName");
				String secondName = rs.getString("sName");
				int age = rs.getInt("age");

				System.out.println("ID: " + id);
				System.out.println("First Name: " + fistName);
				System.out.println("Second Name: " + secondName);
				System.out.println("Age: " + age);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					// we are closing the connection - this is done to stop leakage
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
		System.out.println("SQl has now finished");

	}

}
