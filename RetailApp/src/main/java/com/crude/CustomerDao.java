package com.crude;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Account;
import com.pojo.Customer;

import com.crude.DBConnectionUtil;

public class CustomerDao {
	static Connection connection = null;
	static ResultSet resultSet = null;
	static Statement statement = null;
	static PreparedStatement preparedStatement = null;

public static boolean create(Customer c) {
		

	boolean flag = false;
	try {
		String sql = "INSERT INTO tbl_customer(ws_ssn, ws_cust_id, ws_name, ws_age, ws_adrs)VALUES"
				+ "('"+c.getSsid()+"','"+c.getCustomerid()+"', '"+c.getName()+"', '"+c.getAge()+"','"+c.getAddress()+"')";
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		flag = true;
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	return flag;
		}
public static boolean update(Customer c) {
	
	boolean flag = false;
	try {
		String sql = "UPDATE tbl_customer SET ws_name = '"+c.getName()+"', "
				+ "ws_adrs = '"+c.getAddress()+"', ws_age = '"+c.getAge()+"' where id="+c.getCustomerid();
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		flag = true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return flag;
	}
public static boolean delete (Customer c) {
	
	boolean flag = false;
	try {
		String sql = "DELETE FROM tbl_customer where ws_cust_id="+c.getCustomerid();
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		flag = true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return flag;
	}

public static List<Customer> status (Customer c) {
	
	List<Customer> list = null;
	Customer customer = null;
	
	try {
		
		list = new ArrayList<Customer>();
		String sql = "SELECT * FROM tbl_customer";
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			customer = new Customer();
			customer.setSsid(Integer.toString(resultSet.getInt("ws_ssn")));
			customer.setCustomerid(Integer.toString(resultSet.getInt("ws_cust_id")));
			customer.setName(resultSet.getString("ws_name"));
			customer.setAddress(resultSet.getString("ws_adrs"));
			
			customer.setAge(Integer.toString(resultSet.getInt("ws_age")));
			list.add(customer);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return list;
	
	}
}
