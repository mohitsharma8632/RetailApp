package com.crude;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pojo.Transaction;

public class TransactionDao {
	static Connection connection = null;
	static ResultSet resultSet = null;
	static Statement statement = null;
	static PreparedStatement preparedStatement = null;

public static boolean withdraw(Transaction t) {
	boolean flag = false;
	try {
		String sql = "INSERT INTO tbl_transaction(ws_ssn, ws_cust_id, ws_name, ws_age, ws_adrs)VALUES(?,?,?,?,?,?)";
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,t.getCustomerid() );
		preparedStatement.setString(2, t.getAccounttype());
		preparedStatement.setString(3, t.getAmount());
		preparedStatement.setString(4, t.getDate());
		preparedStatement.setString(5, t.getSourceaccounttype());
		preparedStatement.setString(6, t.getTargetaccounttype());
		preparedStatement.executeUpdate();
		flag = true;
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	return flag;

		}
public static boolean deposit(Transaction t) {
	
	boolean flag = false;
	try {
		String sql = "INSERT INTO tbl_transaction(ws_ssn, ws_cust_id, ws_name, ws_age, ws_adrs)VALUES(?,?,?,?,?,?)";
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,t.getCustomerid() );
		preparedStatement.setString(2, t.getAccounttype());
		preparedStatement.setString(3, t.getAmount());
		preparedStatement.setString(4, t.getDate());
		preparedStatement.setString(5, t.getSourceaccounttype());
		preparedStatement.setString(6, t.getTargetaccounttype());
		preparedStatement.executeUpdate();
			flag = true;
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	return flag;

	}
}
