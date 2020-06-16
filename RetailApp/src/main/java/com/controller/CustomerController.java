package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crude.CustomerDao;
import com.pojo.Customer;

@Controller
public class CustomerController {

	
	@RequestMapping("CreateCustomerAction")
public void CreateCustomer(Customer c,HttpServletResponse r) throws IOException {
		int a=CustomerDao.create(c);
		if(a!=0){
			r.sendRedirect("Home?msg=Customer created with id "+a);
		}
		else {
				r.sendRedirect("CreateCustomer?msg=Customer creation failed");
		}
}
	
	
	
@RequestMapping("UpdateCustomerAction")
public void UpdateCustomerAction(Customer c,HttpServletResponse r) throws IOException {
	if(CustomerDao.update(c)){
		r.sendRedirect("Home?msg=Customer with Customer id "+c.getCustomerid()+"was updated  with Name:"+c.getName()+",Age:"+c.getAge()+",Address:"+c.getAddress());
	}
	else {
			r.sendRedirect("UpdateCustomer?msg=Customer updation failed");
	}
}



@RequestMapping("DeleteCustomerAction")
public void DeleteCustomerAction(Customer c,HttpServletResponse r) throws IOException {
		if(CustomerDao.delete(c)){
		r.sendRedirect("Home?msg=Customer with Customer id  "+c.getCustomerid()+" was deleted");
	}
	else {
			r.sendRedirect("DeleteCustomer?msg=Customer deletion failed");
	}
	
}

	
	
}
