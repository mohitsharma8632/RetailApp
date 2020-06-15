package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crude.AccountDao;
import com.crude.CustomerDao;
import com.pojo.Account;
import com.pojo.Customer;

@Controller
public class Acontroller {

	@RequestMapping("Home")
	public ModelAndView HomeScreen(String msg) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("msg", msg);
	mv.setViewName("Home");
	return mv;
	}
	
	@RequestMapping("CreateCustomer")
	public ModelAndView CreateCustomer(String msg) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("msg", msg);
	mv.setViewName("CreateCustomer");
	return mv;
	}
	
	@RequestMapping("UpdateCustomer")
	public ModelAndView UpdateCustomerScreen(String msg,int customerid) {
		Customer cus=new Customer();
		cus.setCustomerid(customerid);
		cus =CustomerDao.getcustomerbycustomerid(cus);
			ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("c", cus);
	mv.setViewName("UpdateCustomer");
	return mv;
	}
	
	@RequestMapping("DeleteCustomer")
	public ModelAndView DeleteCustomerScreen(String msg,int customerid) {
		Customer cus=new Customer();
		cus.setCustomerid(customerid);
		cus =CustomerDao.getcustomerbycustomerid(cus);
			ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("c", cus);
	mv.setViewName("DeleteCustomer");
	return mv;
	}
	
	@RequestMapping("CustomerStatus")
	public ModelAndView CustomerStatusScreen(String msg) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("clist",CustomerDao.status());
		mv.setViewName("CustomerStatus");
		return mv;
	}
	
	@RequestMapping("CustomerSearch")
	public ModelAndView CustomerSearch(String operation,String msg) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("operation", operation);
		mv.setViewName("CustomerSearch");
		return mv;
	}
	
	@RequestMapping("AccountSearch")
	public ModelAndView AccountSearch(String operation,String msg) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("operation", operation);
		mv.setViewName("AccountSearch");
		return mv;
	}
	
	
	@RequestMapping("CreateAccount")
	public ModelAndView CreateAccountScreen(String msg) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("msg", msg);
	mv.setViewName("CreateAccount");
	return mv;
	}
	
	
	@RequestMapping("DeleteAccount")
	public ModelAndView DeleteAccountScreen(String msg,int accountid) {
		Account acc=new Account();
		acc.setAccountid(accountid);
		acc=AccountDao.getaccountbyid(acc);
			ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("a", acc);
	mv.setViewName("DeleteAccount");
	return mv;
	}
	
	@RequestMapping("AccountStatus")
	public ModelAndView AccountStatusScreen(String msg) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("msg", msg);
	mv.addObject("alist", AccountDao.status());
	mv.setViewName("AccountStatus");
	return mv;
	}
	
	
	@RequestMapping("Transfer")
	public ModelAndView TransferMoneyScreen(String msg) {
			ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
	mv.setViewName("Transfer");
	return mv;
	}
	
	

	@RequestMapping("Withdraw")
	public ModelAndView WithdrawScreen(String msg,int accountid) {
	Account acc=new Account();
	acc.setAccountid(accountid);
	acc=AccountDao.getaccountbyid(acc);
		ModelAndView mv=new ModelAndView();
	mv.addObject("msg", msg);
	mv.addObject("a", acc);
	mv.setViewName("Withdraw");
	return mv;
	}
	@RequestMapping("Deposit")
	public ModelAndView DepositScreen(String msg,int accountid) {
		Account acc=new Account();
		acc.setAccountid(accountid);
		acc=AccountDao.getaccountbyid(acc);
			ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("a", acc);
	mv.setViewName("Deposit");
	return mv;
	}
	@RequestMapping("Logout")
	public ModelAndView LogouttScreen() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("Logout");
	return mv;
	}
	@RequestMapping("index")
	public ModelAndView index(String msg) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("msg", msg);
	mv.setViewName("index");
	return mv;
	}	
}
