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

	
	public List<Student> getStudentList() {

		List<Student> student = new ArrayList<>();
		
		try {

			// getting connection
			Connection con = DBConnector.getConnection();
			Statement stmt = con.createStatement();

			// executin query
			String sql = "select s.*, c.class_name from student_details s INNER JOIN classes c ON s.class_id = c.class_id";
			ResultSet rs = stmt.executeQuery(sql);

			// checking user entered correct login details
			while (rs.next()) {
				Student stud = new Student();
				stud.setStudentId(rs.getInt("student_id"));
				stud.setFirstName(rs.getString("first_name"));
				stud.setLastName(rs.getString("last_name"));
				stud.setGender(rs.getString("gender"));
				stud.setAddress(rs.getString("address"));
				stud.setCity(rs.getString("city"));
				stud.setMobileNo(rs.getString("mobile_no"));
				stud.setClassName(rs.getString("class_name"));
				
				student.add(stud);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;

	}
	
	public int deleteStudent(int student_id){
		
		int queryResult = 0;

		try {
			Connection con = DBConnector.getConnection();
			
			String query = "delete from student_details where student_id = ?";
			
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, student_id);

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
