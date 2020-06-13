package com.crude;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Account;
import com.crude.DBConnectionUtil;

public class AccountDao {
	static Connection connection = null;
	static ResultSet resultSet = null;
	static Statement statement = null;
	static PreparedStatement preparedStatement = null;


public static boolean create(Account a) {
	boolean flag = false;
	try {
		String sql = "INSERT INTO tbl_account(ws_cust_id, ws_acct_type, ws_acct_balance)VALUES"
				+ "('"+a.getCustomerid()+"', '"+a.getAccountype()+"', '"+a.getBalance()+"')";
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		flag = true;
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	return flag;
		}

public static boolean delete (Account a) {
	boolean flag = false;
	try {
		String sql = "DELETE FROM tbl_account where ws_acct_id="+a.getAccountid();
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		flag = true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return flag;
	}

public static List<Account> status (Account a) {
	
	List<Account> list = null;
	Account account = null;
	
	try {
		
		list = new ArrayList<Account>();
		String sql = "SELECT * FROM tbl_account";
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			account = new Account();
			account.setAccountid(Integer.toString(resultSet.getInt("ws_acct_id")));
			account.setCustomerid(Integer.toString(resultSet.getInt("ws_cust_id")));
			account.setAccountype(resultSet.getString("ws_acct_type"));
			account.setBalance(Integer.toString(resultSet.getInt("ws_acct_balance")));
			list.add(account);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return list;
	
	}
}
