package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public class BController {

	@RequestMapping("LoginAction")
public ModelAndView LoginAction(UserEx u,HttpSession r) throws IOException {
ModelAndView mv=new ModelAndView();
if(UserDao.ucheck(u)){
	r.setAttribute("uname", u.getUname());
	mv.addObject("msg", "Welcome "+u.getUname());
	mv.setViewName("Home");
}
else {
		mv.addObject("msg", "wrong credentials");
		mv.setViewName("");
}
return mv;
	}

	
	@RequestMapping("CreateCustomerAction")
public ModelAndView CreateCustomer(Customer c,HttpServletResponse r) throws IOException {
		ModelAndView mv=new ModelAndView();
		int a=CustomerDao.create(c);
		if(a!=0){
			mv.addObject("msg", "Customer created with id "+a);
			mv.setViewName("Home");
		}
		else {
				mv.addObject("msg", "Customer creation failed");
				mv.setViewName("CreateCustomer");
		}
		return mv;
}
	
	
	
@RequestMapping("UpdateCustomerAction")
public ModelAndView UpdateCustomerAction(Customer c,HttpServletResponse r) throws IOException {
	ModelAndView mv=new ModelAndView();
	if(CustomerDao.update(c)){
		mv.addObject("msg", "Customer with Customer id "+c.getCustomerid()+"was updated  with Name:"+c.getName()+",Age:"+c.getAge()+",Address:"+c.getAddress());
		mv.setViewName("Home");
	}
	else {
			mv.addObject("msg", "Customer updation failed");
			mv.setViewName("UpdateCustomer");
	}
	return mv;
}



@RequestMapping("DeleteCustomerAction")
public ModelAndView DeleteCustomerAction(Customer c,HttpServletResponse r) throws IOException {
	ModelAndView mv=new ModelAndView();
	if(CustomerDao.delete(c)){
		mv.addObject("msg", "Customer with Customer id  "+c.getCustomerid()+" was deleted");
		mv.setViewName("Home");
	}
	else {
			mv.addObject("msg", "Customer deletion failed");
			mv.setViewName("DeleteCustomer");
	}
	return mv;
}




@RequestMapping("CustomerStatusAction")
public void CustomerStatusAction(Customer c,HttpServletResponse r) throws IOException {
	List<Customer> clist=CustomerDao.status(c);
		r.sendRedirect("Success");
}


@RequestMapping("CreateAccountAction")
public ModelAndView CreateAccountAction(Account a,HttpServletResponse r) throws IOException {
	ModelAndView mv=new ModelAndView();
	int aid=AccountDao.create(a);
	if(aid!=0){
		mv.addObject("msg", "Account created with id "+aid);
		mv.setViewName("Home");
	}
	else {
			mv.addObject("msg", "Account creation failed");
			mv.setViewName("CreateAcccount");
	}
	return mv;
}



@RequestMapping("DeleteAccountAction")
public ModelAndView DeleteAccountAction(Account a,HttpServletResponse r) throws IOException {
	ModelAndView mv=new ModelAndView();
	if(AccountDao.delete(a)){
		mv.addObject("msg", "Account with Account id  "+a.getAccountid()+" was deleted");
		mv.setViewName("Home");
	}
	else {
			mv.addObject("msg", "Account deletion failed");
			mv.setViewName("DeleteAccount");
	}
	return mv;
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
