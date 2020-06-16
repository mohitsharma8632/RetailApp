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

public static int create(Customer c) {
		

	int f = 0;
	try {
		String sql = "INSERT INTO customer VALUES(?,?,?,?,Null)";
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, c.getSsnid());
		preparedStatement.setString(2, c.getName());
		preparedStatement.setInt(3, c.getAge());
		preparedStatement.setString(4, c.getAddress()+","+c.getCity()+","+c.getState());
		Customer ca=new Customer();
		ca.setSsnid(c.getSsnid());
ca=getcustomerbyssnid(ca);
if(ca!=null)
{	return 0;
}else{
		f = preparedStatement.executeUpdate();
}if(f==1) {
			return getcustomerbyssnid(c).getCustomerid();
		}
		
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	return f;
		}






public static boolean update(Customer c) {
	
	boolean flag = false;
	try {
		String sql = "UPDATE customer SET name = '"+c.getName()+"', "
				+ "address = '"+c.getAddress()+"', age = '"+c.getAge()+"' where customerid="+c.getCustomerid();
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
		String sql = "DELETE FROM customer where customerid="+c.getCustomerid();
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		flag = true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return flag;
	}

public static List<Customer> status () {
	
	List<Customer> list = null;
	Customer customer = null;
	
	try {
		
		list = new ArrayList<Customer>();
		String sql = "SELECT * FROM customer";
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			customer = new Customer();
			customer.setSsnid(resultSet.getInt(1));
			customer.setName(resultSet.getString(2));
			customer.setAge(resultSet.getInt(3));
			customer.setAddress(resultSet.getString(4));
			customer.setCustomerid(resultSet.getInt(5));
			list.add(customer);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return list;
	
	}

public static Customer getcustomerbyssnid (Customer c) {
	
	Customer customer = null;
	
	try {
		
		String sql = "SELECT * FROM customer  where ssnid="+c.getSsnid();
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
if(resultSet.next()) {
			customer = new Customer();
			customer.setSsnid(resultSet.getInt(1));
			customer.setName(resultSet.getString(2));
			customer.setAge(resultSet.getInt(3));
			customer.setAddress(resultSet.getString(4));
			customer.setCustomerid(resultSet.getInt(5));
}	}catch(SQLException e) {
		e.printStackTrace();
	}
	return customer;
	
	}

public static Customer getcustomerbycustomerid (Customer c) {
	
	Customer customer = null;
	
	try {
		
		String sql = "SELECT * FROM customer  where customerid="+c.getCustomerid();
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		if(resultSet.next()) {
			customer = new Customer();
			customer.setSsnid(resultSet.getInt(1));
			customer.setName(resultSet.getString(2));
			customer.setAge(resultSet.getInt(3));
			customer.setAddress(resultSet.getString(4));
			customer.setCustomerid(resultSet.getInt(5));
		}	}catch(SQLException e) {
		e.printStackTrace();
	}
	return customer;
	
	}

}
