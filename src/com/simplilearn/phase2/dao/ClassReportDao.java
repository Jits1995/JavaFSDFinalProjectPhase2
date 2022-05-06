package com.simplilearn.phase2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.simplilearn.phase2.bean.ClassReport;
import com.simplilearn.phase2.bean.Classes;
import com.simplilearn.phase2.bean.Student;
import com.simplilearn.phase2.util.DBConnector;

public class ClassReportDao {

	public List<Classes> getClassList() {

		Connection con;
		List<Classes> classes = new ArrayList<>();
		
		try {
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement();

			// executing query
			String sql = "SELECT * FROM classes";
			ResultSet rs = stmt.executeQuery(sql);

			// getting classes name
			while (rs.next()) {
				Classes cls = new Classes();
				cls.setClass_id(rs.getInt("class_id"));
				cls.setClass_name(rs.getString("class_name"));
				classes.add(cls);
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classes;
	}

	public HashMap<String, List> getClassReport(int class_id) {
		
		HashMap<String, List> map = new HashMap<>();
		
		try {
			
			String query = "SELECT c.class_name, s.subject_name, t.first_name, t.last_name, t.gender, t.experience FROM SUBJECT s "
					+ "INNER JOIN classes c ON s.class_id = c.class_id "
					+ "INNER JOIN teacher_details t ON t.teacher_id = s.teacher_id WHERE c.class_id = ?";
			String query1 = "SELECT * FROM student_details WHERE class_id = ?";
			
			ResultSet rs = null;
			ResultSet rs1 = null;
			List<ClassReport> classreport = new ArrayList<>();
			List<Student> studentreport = new ArrayList<>();
			
			Connection con = DBConnector.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// execute the preparedstatement
			preparedStmt.setInt(1, class_id);
			rs = preparedStmt.executeQuery();

			// getting classes name
			while (rs.next()) {
				ClassReport cr = new ClassReport();
				cr.setClass_name(rs.getString("class_name"));
				cr.setSubject_name(rs.getString("subject_name"));
				cr.setFirst_name(rs.getString("first_name"));
				cr.setLast_name(rs.getString("last_name"));
				cr.setGender(rs.getString("gender"));
				cr.setExperience(rs.getString("experience"));
				classreport.add(cr);
			}
			map.put("classReport", classreport);
			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			// execute the preparedstatement
			preparedStmt1.setInt(1, class_id);
			rs1 = preparedStmt1.executeQuery();
			
			while(rs1.next()){
				Student student = new Student();
				student.setFirstName(rs1.getString("first_name"));
				student.setLastName(rs1.getString("last_name"));
				student.setMobileNo(rs1.getString("mobile_no"));
				student.setGender(rs1.getString("gender"));
				student.setAddress(rs1.getString("address"));
				student.setCity(rs1.getString("city"));		
				studentreport.add(student);
			}
			map.put("studentReport", studentreport);
			
			preparedStmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
		
	}

}
