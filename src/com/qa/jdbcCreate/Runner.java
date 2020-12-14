package com.qa.jdbcCreate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {

	// STEP 1
	// JDBC driver - This tell java what driver we need to use
	final String JDBC_DRIVER = "com.sql.jdbc.Driver";

	// Sql url that needs to be used for our CRUD statements
	final static String DB_URL = "jdbc:mysql://localhost/student";
	// jdbc:mysql://34.67.113.137:3306/<dbName>

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
			System.out.println("inserting record into db");
			stmt = conn.createStatement();

			String sql = "INSERT INTO students VALUES (2,'Jim','smith',10)";
			stmt.execute(sql);
			sql = "INSERT INTO students VALUES (3,'Sam','smith',10)";
			stmt.execute(sql);
			sql = "INSERT INTO students VALUES (4,'Tim','smith',10)";
			stmt.execute(sql);
			sql = "INSERT INTO students VALUES (5,'Mike','smith',10)";
			stmt.execute(sql);

			System.out.println("Record has been inserted now!");

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
