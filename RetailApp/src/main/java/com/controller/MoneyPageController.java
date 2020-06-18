package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crude.AccountDao;
import com.crude.TransactionDao;
import com.pojo.Account;
import com.pojo.Transaction;

@Controller
public class MoneyPageController {

	@RequestMapping("Deposit")
	public ModelAndView DepositScreen(String msg,Account acc,HttpServletResponse r) throws IOException {
		acc=AccountDao.getaccountbyid(acc);
		if(acc==null) {
		r.sendRedirect("Home?msg=Account with given id  was not found");
		}
			ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("a", acc);
	mv.setViewName("Deposit");
	return mv;
	}
	
	@RequestMapping("Withdraw")
	public ModelAndView WithdrawScreen(String msg,Account acc,HttpServletResponse r) throws IOException {
	acc=AccountDao.getaccountbyid(acc);
	if(acc==null) {
		r.sendRedirect("Home?msg=Account with given id   was not found");
		}
		ModelAndView mv=new ModelAndView();
	mv.addObject("msg", msg);
	mv.addObject("a", acc);
	mv.setViewName("Withdraw");
	return mv;
	}


	@RequestMapping("Transfer")
	public ModelAndView TransferMoneyScreen(String msg) {
			ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
	mv.setViewName("Transfer");
	return mv;
	}
	

	@RequestMapping("Statement")
	public ModelAndView Statement(Account a,String msg) {
	int i=0;
List<Transaction> tlist=null;
if(a.getAccountid()!=0) {
		tlist=TransactionDao.tlist(a.getAccountid());
		i=tlist.size();
	}
		ModelAndView mv=new ModelAndView();
	mv.addObject("msg", msg);
	mv.addObject("i", i);
	mv.addObject("tlist", tlist);
	mv.addObject("a",a);
	mv.setViewName("Statement");
	return mv;
	}

	
	
}
