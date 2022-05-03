package com.simplilearn.phase2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.phase2.bean.Login;
import com.simplilearn.phase2.util.DBConnector;

public class LoginDao {

	public boolean loginCheck(Login login) {

		boolean login_flag = true;
		
		String username = login.getUsername();
		String password = login.getPassword();
		
		try {
			
			//getting connection
			Connection con = DBConnector.getConnection();
			Statement stmt = con.createStatement();
			
			//executin query
			String sql = "SELECT * FROM login";
			ResultSet rs = stmt.executeQuery(sql);
			
			//checking user entered correct login details
			while(rs.next()){
				if(rs.getString("username").equals(username) && rs.getString("password").equals(password)){
					login_flag = true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return login_flag;
	}

}
