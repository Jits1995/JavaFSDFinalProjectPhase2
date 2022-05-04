package com.simplilearn.phase2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.simplilearn.phase2.bean.ClassSubject;
import com.simplilearn.phase2.util.DBConnector;

public class ClassSubjectDao {

	public boolean linkClassToSubject(List<ClassSubject> class_subject) {

		int queryResult[] = null;

		try {

			String query = "insert into class_subject_teacher_link (class_id, subject_id) values (?,?)";

			// create the mysql insert preparedstatement
			Connection con = DBConnector.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			for(ClassSubject cs : class_subject){
				preparedStmt.setInt(1, cs.getClass_id());
				preparedStmt.setInt(2, cs.getSubject_id());
				
				preparedStmt.addBatch();
			}

			// execute the preparedstatement
			queryResult = preparedStmt.executeBatch();
			preparedStmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(queryResult.length>0)
			return true;
		else 
			return false;

	}

}
