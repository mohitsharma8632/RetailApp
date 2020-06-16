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

import com.pojo.Customer;
import com.pojo.Transaction;

public class TransactionDao {
	static Connection connection = null;
	static ResultSet resultSet = null;
	static Statement statement = null;
	static PreparedStatement preparedStatement = null;
	

public static boolean transfer(Transaction t) {
	boolean flag = false;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date datenow = new Date();
    String[] s=dateFormat.format(datenow).split("/");
    String date=s[0]+s[1]+s[2];
	try {
		String sql = "INSERT INTO transaction VALUES(?,?,?,?,?,?,?,Null)";
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
		String sql = "INSERT INTO transaction VALUES(?,?,?,?,Null,Null,?,Null)";
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
		String sql = "INSERT INTO transaction VALUES(?,?,?,?,Null,Null,?,Null)";
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
	System.out.println(flag);
	return flag;

	}

public static List<Transaction> tlist (int accountid) {
	
	List<Transaction> list = null;
	Transaction transaction = null;
	
	try {
		
		list = new ArrayList<Transaction>();
		String sql = "SELECT * FROM transaction where sourceaccountid="+accountid;
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			transaction = new Transaction();
			transaction.setSourceaccountid(resultSet.getInt(1));
			transaction.setSourceaccounttype(resultSet.getString(2));
			transaction.setAmount(resultSet.getInt(3));
			String date=resultSet.getInt(4)+"";
			date=date.substring(0,4)+"/"+date.substring(4,6)+"/"+date.substring(6,8);
			transaction.setDate(date);
			transaction.setTargetaccountid(resultSet.getInt(5));
			transaction.setTargetaccounttype(resultSet.getString(6));
			transaction.setType(resultSet.getString(7));
			transaction.setTransactionid(resultSet.getInt(8));
			list.add(transaction);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return list;
	
	}


}
