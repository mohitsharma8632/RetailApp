package com.crude;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/retail";
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static final String USERNAME = "dbuser";
	
	private static final String PASSWORD = "user";
	
	private static Connection connection = null;
	
	public static Connection openConnection() {
		if (connection != null)
            return connection;
        else {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            return connection;
        }
	}		
}