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
public class MoneyController {

@RequestMapping("TransferAction")
public void TransferMoneyAction(Transaction t,HttpServletResponse r) throws IOException {
	if(TransactionDao.transfer(t)) {
	r.sendRedirect("Home?msg=Transfer of amount"+t.getAmount()+" from account id  "+t.getSourceaccountid()+" to account id "+t.getTargetaccountid()+" was successfull");
	}else {
		r.sendRedirect("Transfer?msg=Transfer of amount"+t.getAmount()+" from account id  "+t.getSourceaccountid()+" to account id "+t.getTargetaccountid()+" was usuccessfull");
	}
	
}



@RequestMapping("DepositAction")
public void DepositAction(Transaction t,HttpServletResponse r) throws IOException {
	if(TransactionDao.deposit(t)) {
		r.sendRedirect("Home?msg=Deposit of amount"+t.getAmount()+" into account id  "+t.getSourceaccountid()+" was successfull");
	}else {
		r.sendRedirect("Deposit?msg=Deposit of amount"+t.getAmount()+" into account id  "+t.getSourceaccountid()+" was unsuccessfull");
	}
}



@RequestMapping("WithdrawAction")
public void WithdrawAction(Transaction t,HttpServletResponse r) throws IOException {
	if(TransactionDao.withdraw(t)) {
		Account acc=new Account();
		acc.setAccountid(t.getSourceaccountid());
		int balance=AccountDao.getaccountbyid(acc).getBalance();
		r.sendRedirect("Home?msg=Withdraw of amount"+t.getAmount()+" from account id  "+t.getSourceaccountid()+" was successfull new balance is"+balance);
	}else {
		r.sendRedirect("Withdraw?msg=Withdraw of amount"+t.getAmount()+" from account id  "+t.getSourceaccountid()+" was unsuccessfull");
	}
}

	
	}
