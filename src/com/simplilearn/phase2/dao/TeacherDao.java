package com.simplilearn.phase2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.phase2.bean.Teacher;
import com.simplilearn.phase2.util.DBConnector;

public class TeacherDao {

	public int addTeacher(Teacher teacher) {

		int queryResult = 0;

		try {

			String query = "insert into teacher_details (first_name, last_name, gender, address, mobile_no, experience)"
					+ " values (?,?,?,?,?,?)";

			Connection con = DBConnector.getConnection();

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, teacher.getFirstName());
			preparedStmt.setString(2, teacher.getLastName());
			preparedStmt.setString(3, teacher.getGender());
			preparedStmt.setString(4, teacher.getAddress());
			preparedStmt.setString(5, teacher.getMobileNo());
			preparedStmt.setString(6, teacher.getExperience());

			// execute the preparedstatement
			queryResult = preparedStmt.executeUpdate();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return queryResult;

	}

		public List<Teacher> getTeacherList() {

		List<Teacher> teacher = new ArrayList<>();

		try {

			// getting connection
			Connection con = DBConnector.getConnection();
			Statement stmt = con.createStatement();

			// executing query
			String sql = "select * from teacher_details";
			ResultSet rs = stmt.executeQuery(sql);

			// checking user entered correct login details
			while (rs.next()) {
				Teacher teach = new Teacher();
				teach.setTeacherId(rs.getInt("teacher_id"));
				teach.setFirstName(rs.getString("first_name"));
				teach.setLastName(rs.getString("last_name"));
				teach.setGender(rs.getString("gender"));
				teach.setAddress(rs.getString("address"));
				teach.setMobileNo(rs.getString("mobile_no"));
				teach.setExperience(rs.getString("experience"));

				teacher.add(teach);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teacher;

	}
	
	
	public int deleteTeacher(int teacher_id){
		
		int queryResult = 0;

		try {
			Connection con = DBConnector.getConnection();
			
			String query = "delete from teacher_details where teacher_id = ?";
			
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, teacher_id);

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
