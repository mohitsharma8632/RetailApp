package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crude.AccountDao;
import com.crude.CustomerDao;
import com.crude.TransactionDao;
import com.crude.UserDao;
import com.pojo.Account;
import com.pojo.Customer;
import com.pojo.Transaction;
import com.pojo.UserEx;
@Controller
public class BController {

	@RequestMapping("LoginAction")
public void LoginAction(UserEx u,HttpSession r,HttpServletResponse res) throws IOException {
if(UserDao.ucheck(u)){
	r.setAttribute("uname", u.getUname());
	res.sendRedirect("Home?msg=welcome "+u.getUname());
}
else {
		res.sendRedirect("index?msg=wrong credentials");
}
	}

	
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




@RequestMapping("CustomerStatusAction")
public void CustomerStatusAction(Customer c,HttpServletResponse r) throws IOException {
	List<Customer> clist=CustomerDao.status();
		r.sendRedirect("Success");
}


@RequestMapping("CreateAccountAction")
public void CreateAccountAction(Account a,HttpServletResponse r) throws IOException {
	int aid=AccountDao.create(a);
	if(aid!=0){
		r.sendRedirect("Home?msg=Account created with id "+aid);
	}
	else {
			r.sendRedirect("CreateAcccount?msg=Account creation failed");
	}
}



@RequestMapping("DeleteAccountAction")
public void DeleteAccountAction(Account a,HttpServletResponse r) throws IOException {	
	if(AccountDao.delete(a)){
		r.sendRedirect("Home?msg=Account with Account id  "+a.getAccountid()+" was deleted");
	}
	else {
			r.sendRedirect("DeleteAccount?msg=Account deletion failed");
	}
}




@RequestMapping("AccountStatusAction")
public void AccountStatusAction(Account a,HttpServletResponse r) throws IOException {
	List<Account> alist=AccountDao.status();
		r.sendRedirect("Success");
}

@RequestMapping("DepositAction")
public void DepositAction(Transaction t,HttpServletResponse r) throws IOException {
	if(TransactionDao.deposit(t)) {
		r.sendRedirect("Success");
	}else {
		r.sendRedirect("Failed");
	}
}

@RequestMapping("WithdrawAction")
public void WithdrawAction(Transaction t,HttpServletResponse r) throws IOException {
	if(TransactionDao.withdraw(t)) {
		r.sendRedirect("Success");
	}else {
		r.sendRedirect("Failed");
	}
}

@RequestMapping("TransferMoneyAction")
public void TransferMoneyAction(Transaction t,HttpServletResponse r) throws IOException {
	if(TransactionDao.withdraw(t)) {
		r.sendRedirect("Success");
	}else {
		r.sendRedirect("Failed");
	}
}
	

}
