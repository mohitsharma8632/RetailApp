package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crude.AccountDao;
import com.pojo.Account;
@Controller
public class AccountPageController {


	@RequestMapping("CreateAccount")
	public ModelAndView CreateAccountScreen(String msg) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("msg", msg);
	mv.setViewName("CreateAccount");
	return mv;
	}
	
	
	@RequestMapping("DeleteAccount")
	public ModelAndView DeleteAccountScreen(String msg,Account acc,HttpServletResponse r) throws IOException {
		acc=AccountDao.getaccountbyid(acc);
		if(acc==null) {
		r.sendRedirect("Home?msg=Account with given id   was not found");
		}
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
	
	@RequestMapping("AccountSearch")
	public ModelAndView AccountSearch(String operation,String msg) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("operation", operation);
		mv.setViewName("AccountSearch");
		return mv;
	}
	
	
}
