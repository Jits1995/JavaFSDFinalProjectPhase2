package com.simplilearn.phase2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.simplilearn.phase2.bean.TeacherClassSubject;
import com.simplilearn.phase2.util.DBConnector;

public class TeacherToSubjectClassDao {

	public boolean linkTeacherToClassSubject(TeacherClassSubject tcs) {

		int queryResult = 0;

		try {

			String query = "UPDATE subject SET teacher_id = ? WHERE subject_id = ?;";

			// create the mysql insert preparedstatement
			Connection con = DBConnector.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// execute the preparedstatement
			preparedStmt.setInt(1, tcs.getTeacher_id());
			preparedStmt.setInt(2, tcs.getSubject_id());
			queryResult = preparedStmt.executeUpdate();
			
			preparedStmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(queryResult>0)
			return true;
		else 
			return false;
	}

	
	
}
