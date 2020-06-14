package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Acontroller {


	
	@RequestMapping("CreateCustomer")
	public ModelAndView CreateCustomer() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("CreateCustomer");
	return mv;
	}
	
	@RequestMapping("UpdateCustomer")
	public ModelAndView UpdateCustomerScreen() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("UpdateCustomer");
	return mv;
	}
	
	@RequestMapping("DeleteCustomer")
	public ModelAndView DeleteCustomerScreen() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("DeleteCustomer");
	return mv;
	}
	
	@RequestMapping("CustomerStatus")
	public ModelAndView CustomerStatusScreen() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("CustomerStatus");
		return mv;
	}
	
	@RequestMapping("CustomerSearch")
	public ModelAndView CustomerSearch() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("CustomerSearchForm");
		return mv;
	}
	
	@RequestMapping("MoneyDeposit")
	public ModelAndView MoneyDepositForm() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("MoneyDepositForm");
		return mv;
	}
	
	@RequestMapping("MoneyWithdraw")
	public ModelAndView MoneyWithdrawForm() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("WithdrawAmountForm");
		return mv;
	}
	
	@RequestMapping("CreateAccount")
	public ModelAndView CreateAccountScreen() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("CreateAccount");
	return mv;
	}
	
	
	@RequestMapping("DeleteAccount")
	public ModelAndView DeleteAccountScreen() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("DeleteAccount");
	return mv;
	}
	
	@RequestMapping("AccountStatus")
	public ModelAndView AccountStatusScreen() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("AccountStatus");
	return mv;
	}
	
	
	@RequestMapping("TransferMoney")
	public ModelAndView TransferMoneyScreen() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("TransferMoney");
	return mv;
	}
	
	

	@RequestMapping("Withdraw")
	public ModelAndView WithdrawScreen() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("Withdraw");
	return mv;
	}
	@RequestMapping("Deposit")
	public ModelAndView DepositScreen() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("Deposit");
	return mv;
	}
}
