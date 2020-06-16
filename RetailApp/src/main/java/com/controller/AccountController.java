package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crude.AccountDao;
import com.pojo.Account;

@Controller
public class AccountController {


@RequestMapping("CreateAccountAction")
public void CreateAccountAction(Account a,HttpServletResponse r) throws IOException {
	int aid=AccountDao.create(a);
	if(aid!=0){
		r.sendRedirect("Home?msg=Account created with id "+aid);
	}
	else {
			r.sendRedirect("CreateAccount?msg=Account creation failed");
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

	
}
