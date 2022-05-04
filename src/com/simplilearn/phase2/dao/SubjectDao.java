package com.simplilearn.phase2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.phase2.bean.Subject;
import com.simplilearn.phase2.util.DBConnector;

public class SubjectDao {

	public int addSubject(Subject sub) {

		int queryResult = 0;

		try {

			String query = "insert into subject (subject_name) values (?)";

			Connection con = DBConnector.getConnection();

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, sub.getSubjectName().toString());

			// execute the preparedstatement
			queryResult = preparedStmt.executeUpdate();
			System.out.print("subject add query result = " + queryResult);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return queryResult;

	}
	
		public List<Subject> getSubjectList() {

		List<Subject> subject = new ArrayList<>();

		try {

			// getting connection
			Connection con = DBConnector.getConnection();
			Statement stmt = con.createStatement();

			// executing query
			String sql = "select * from subject";
			ResultSet rs = stmt.executeQuery(sql);

			// checking user entered correct login details
			while (rs.next()) {
				Subject sub = new Subject();
				sub.setSubjectId(rs.getInt("subject_id"));
				sub.setSubjectName(rs.getString("subject_name"));
				subject.add(sub);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return subject;

	}

	public int deleteSubject(int subject_id) {

		int queryResult = 0;

		try {
			Connection con = DBConnector.getConnection();

			String query = "delete from subject where subject_id = ?";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, subject_id);

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
