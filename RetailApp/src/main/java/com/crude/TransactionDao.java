package com.crude;

import java.lang.annotation.Target;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pojo.Transaction;

public class TransactionDao {
	static Connection connection = null;
	static ResultSet resultSet = null;
	static Statement statement = null;
	static PreparedStatement preparedStatement = null;
	
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date datenow = new Date();
    String[] s=dateFormat.format(datenow).split("/");
    String date=s[0]+s[1]+s[2];
   

public static boolean transfer(Transaction t) {
	boolean flag = false;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date datenow = new Date();
    String[] s=dateFormat.format(datenow).split("/");
    String date=s[0]+s[1]+s[2];
	try {
		String sql = "INSERT INTO tbl_transaction VALUES(?,?,?,?,?,?,?,Null)";
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, t.getSourceaccountid());
		preparedStatement.setString(2, t.getSourceaccounttype());
		preparedStatement.setInt(3, t.getAmount());
		preparedStatement.setInt(4,Integer.parseInt(date) );
		preparedStatement.setInt(5, t.getTargetaccountid());
		preparedStatement.setString(6, t.getTargetaccounttype());
		preparedStatement.setString(7, "transfer");
if(AccountDao.accountwithdraw(t.getSourceaccountid(), t.getAmount())) {
		if(AccountDao.accountdeposit(t.getTargetaccountid(), t.getAmount())) {
	preparedStatement.executeUpdate();
	flag = true;
		}
		else {
			AccountDao.accountdeposit(t.getSourceaccountid(), t.getAmount());
		}
		}
		
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	return flag;

		}
public static boolean deposit(Transaction t) {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date datenow = new Date();
    String[] s=dateFormat.format(datenow).split("/");
    String date=s[0]+s[1]+s[2];
	boolean flag = false;
	try {
		String sql = "INSERT INTO tbl_transaction VALUES(?,?,?,?,Null,Null,?,Null)";
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, t.getSourceaccountid());
		preparedStatement.setString(2, t.getSourceaccounttype());
		preparedStatement.setInt(3, t.getAmount());
		preparedStatement.setInt(4,Integer.parseInt(date) );
		preparedStatement.setString(5, "deposit");
		if(AccountDao.accountdeposit(t.getSourceaccountid(), t.getAmount()))
		{	preparedStatement.executeUpdate();
			flag = true;}
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	return flag;

	}


public static boolean withdraw(Transaction t) {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date datenow = new Date();
    String[] s=dateFormat.format(datenow).split("/");
    String date=s[0]+s[1]+s[2];
	boolean flag = false;
	try {
		String sql = "INSERT INTO tbl_transaction VALUES(?,?,?,?,Null,Null,?,Null)";
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, t.getSourceaccountid());
		preparedStatement.setString(2, t.getSourceaccounttype());
		preparedStatement.setInt(3, t.getAmount());
		preparedStatement.setInt(4,Integer.parseInt(date) );
		preparedStatement.setString(5, "withdraw");
		if(AccountDao.accountwithdraw(t.getSourceaccountid(), t.getAmount()))
		{	preparedStatement.executeUpdate();
			flag = true;}
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	return flag;

	}

}
