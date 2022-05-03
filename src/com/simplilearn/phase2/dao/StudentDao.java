package com.simplilearn.phase2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.phase2.bean.Student;
import com.simplilearn.phase2.util.DBConnector;

public class StudentDao {

	public int addStudent(Student student) {

		int queryResult = 0;

		try {

			String query = "insert into student_details (first_name, last_name, mobile_no, gender, address, city, class_id)"
					+ " values (?,?,?,?,?,?,?)";

			Connection con = DBConnector.getConnection();

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, student.getFirstName());
			preparedStmt.setString(2, student.getLastName());
			preparedStmt.setString(3, student.getMobileNo());
			preparedStmt.setString(4, student.getGender());
			preparedStmt.setString(5, student.getAddress());
			preparedStmt.setString(6, student.getCity());
			preparedStmt.setInt(7, student.getClassId());

			// execute the preparedstatement
			queryResult = preparedStmt.executeUpdate();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return queryResult;

	}


}
