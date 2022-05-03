package com.simplilearn.phase2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private static String url = "jdbc:mysql://localhost:3306/learneracademy";
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String username = "root";
	private static String password = "root";
	private static Connection con;

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
				System.out.println("Failed to create the database connection." + ex.getMessage());
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}
		return con;
	}

}
