package com.simplilearn.phase2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.phase2.bean.Classes;
import com.simplilearn.phase2.util.DBConnector;

public class ClassDao {

	public int addClass(String className) {

		int queryResult = 0;

		try {

			String query = "insert into classes (class_name) values (?)";

			Connection con = DBConnector.getConnection();

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, className);

			// execute the preparedstatement
			queryResult = preparedStmt.executeUpdate();
			System.out.print("class add query result = " + queryResult);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return queryResult;
	}

}
