package com.crude;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pojo.Account;
import com.pojo.Customer;
import com.crude.DBConnectionUtil;

public class AccountDao {
	static Connection connection = null;
	static ResultSet resultSet = null;
	static Statement statement = null;
	static PreparedStatement preparedStatement = null;


public static int create(Account a) {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date datenow = new Date();
    String s=dateFormat.format(datenow);
	int f = 0;
	try {
		String sql = "INSERT INTO account VALUES(?,?,?,?,Null)";
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, a.getCustomerid());
		preparedStatement.setString(2, a.getAccountype());
		preparedStatement.setInt(3, a.getBalance());
		preparedStatement.setString(4, s);
		f =preparedStatement.executeUpdate();
		if(f==1) {
			return getaccountbycustomerid(a).getAccountid();
		}
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	return f;
		}

public static boolean delete (Account a) {
	boolean flag = false;
	try {
		String sql = "DELETE FROM account where accountid="+a.getAccountid();
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
	int i=	preparedStatement.executeUpdate();
	if(i>0)	
	flag = true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return flag;
	}


public static List<Account> status () {
	
	List<Account> list = null;
	Account account = null;
	
	try {
		
		list = new ArrayList<Account>();
		String sql = "SELECT * FROM account";
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			account = new Account();
			account.setCustomerid(resultSet.getInt(1));
			account.setAccountype(resultSet.getString(2));
			account.setBalance(resultSet.getInt(3));
			account.setDate(resultSet.getString(4));
			account.setAccountid(resultSet.getInt(5));
			list.add(account);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return list;
	
	}

public static Account getaccountbyid (Account a) {
	
	Account account = null;
	
	try {
		
		String sql = "SELECT * FROM account where accountid="+a.getAccountid();
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
if(resultSet.next()) {
			account = new Account();
			account.setCustomerid(resultSet.getInt(1));
			account.setAccountype(resultSet.getString(2));
			account.setBalance(resultSet.getInt(3));
			account.setDate(resultSet.getString(4));
			account.setAccountid(resultSet.getInt(5));
}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return account;
	
	}


public static Account getaccountbycustomerid (Account a) {
	
	Account account = null;
	
	try {
		
		String sql = "SELECT * FROM account where customerid="+a.getCustomerid();
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		if(resultSet.next()) {
			account = new Account();
			account.setCustomerid(resultSet.getInt(1));
			account.setAccountype(resultSet.getString(2));
			account.setBalance(resultSet.getInt(3));
			account.setDate(resultSet.getString(4));
			account.setAccountid(resultSet.getInt(5));
}

	}catch(SQLException e) {
		e.printStackTrace();
	}
	return account;
	
	}


public static boolean accountwithdraw(int accountid,int amount) {
	Account a=new Account();
	a.setAccountid(accountid);
	int balance=getaccountbyid(a).getBalance();
	
	boolean flag = false;
	if(balance>amount) {
	balance-=amount;
		try {
		String sql = "UPDATE account SET balance = "+balance+" where accountid="+accountid;
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		int i=preparedStatement.executeUpdate();
		System.out.println(i);
		if(i>0)
		flag = true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
	System.out.println(flag);
	return flag;
	}


public static boolean accountdeposit(int accountid,int amount) {
	Account a=new Account();
	a.setAccountid(accountid);
	int balance=getaccountbyid(a).getBalance();
	balance+=amount;
	boolean flag = false;
	try {
		String sql = "UPDATE account SET balance = "+balance+" where accountid="+accountid;
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		int i=preparedStatement.executeUpdate();
		if(i>0)
		flag = true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return flag;
	}

}
