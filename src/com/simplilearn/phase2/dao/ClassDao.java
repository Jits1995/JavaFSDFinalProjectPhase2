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

	public List<Classes> getClassList() {

		List<Classes> classes = new ArrayList<>();

		try {

			// getting connection
			Connection con = DBConnector.getConnection();
			Statement stmt = con.createStatement();

			// executin query
			String sql = "select * from classes";
			ResultSet rs = stmt.executeQuery(sql);

			// checking user entered correct login details
			while (rs.next()) {
				Classes clas = new Classes();
				clas.setClass_id(rs.getInt("class_id"));
				clas.setClass_name(rs.getString("class_name"));

				classes.add(clas);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return classes;

	}

	public int deleteClass(int class_id) {

		int queryResult = 0;

		try {
			Connection con = DBConnector.getConnection();
			
			String query = "delete from classes where class_id = ?";
			
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, class_id);

			// execute the preparedstatement
			queryResult = preparedStmt.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return queryResult;

	}

}
