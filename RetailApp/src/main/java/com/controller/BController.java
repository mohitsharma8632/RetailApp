package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.crude.AccountDao;
import com.crude.CustomerDao;
import com.crude.TransactionDao;
import com.crude.UserDao;
import com.pojo.Account;
import com.pojo.Customer;
import com.pojo.Transaction;
import com.pojo.UserEx;

public class BController {

	@RequestMapping("LoginAction")
public void LoginAction(UserEx u,HttpServletResponse r) throws IOException {
if(UserDao.ucheck(u)) {
	r.sendRedirect("Success");
}else {
	r.sendRedirect("Failed");
}
}
@RequestMapping("CreateCustomerAction")
public void CreateCustomer(Customer c,HttpServletResponse r) throws IOException {
	if(CustomerDao.create(c)) {
		r.sendRedirect("Success");
	}else {
		r.sendRedirect("Failed");
	}
}
@RequestMapping("UpdateCustomerAction")
public void UpdateCustomerAction(Customer c,HttpServletResponse r) throws IOException {
	if(CustomerDao.update(c)) {
		r.sendRedirect("Success");
	}else {
		r.sendRedirect("Failed");
	}
}
@RequestMapping("DeleteCustomerAction")
public void DeleteCustomerAction(Customer c,HttpServletResponse r) throws IOException {
	if(CustomerDao.delete(c)) {
		r.sendRedirect("Success");
	}else {
		r.sendRedirect("Failed");
	}
}
@RequestMapping("CustomerStatusAction")
public void CustomerStatusAction(Customer c,HttpServletResponse r) throws IOException {
	List<Customer> clist=CustomerDao.status(c);
		r.sendRedirect("Success");
}
@RequestMapping("CreateAccountAction")
public void CreateAccountAction(Account a,HttpServletResponse r) throws IOException {
	if(AccountDao.create(a)) {
		r.sendRedirect("Success");
	}else {
		r.sendRedirect("Failed");
	}
}
@RequestMapping("DeleteAccountAction")
public void DeleteAccountAction(Account a,HttpServletResponse r) throws IOException {
	if(AccountDao.delete(a)) {
		r.sendRedirect("Success");
	}else {
		r.sendRedirect("Failed");
	}
}
@RequestMapping("AccountStatusAction")
public void AccountStatusAction(Account a,HttpServletResponse r) throws IOException {
	List<Account> alist=AccountDao.status(a);
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
