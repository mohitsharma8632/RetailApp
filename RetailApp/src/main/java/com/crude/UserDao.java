package com.crude;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pojo.UserEx;

public class UserDao {
	static Connection connection = null;
	static ResultSet resultSet = null;
	static Statement statement = null;
	static PreparedStatement preparedStatement = null;

	public static boolean ucheck(UserEx u) {
		boolean flag = false;
		try {
			String sql = "SELECT * FROM tbl_user where ws_uname="+u.getUname();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
				if(resultSet.getString("ws_upass").equals(u.getPassword()))
					return true;
				else
					return false;
				
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
			
		}
}
