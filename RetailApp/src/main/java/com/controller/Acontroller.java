package com.controller;

import java.io.IOException;
import java.util.ArrayList;
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
public class Acontroller {

	@RequestMapping("LoginAction")
public void LoginAction(UserEx u,HttpSession r,HttpServletResponse res) throws IOException {
if(UserDao.ucheck(u)){
	r.setAttribute("uname", u.getUname());
	System.out.println("one");
	res.sendRedirect("Home?msg=welcome "+u.getUname());
	System.out.println("two");
}
else {
		res.sendRedirect("index?msg=wrong credentials");
}
	}

	@RequestMapping("Home")
	public ModelAndView HomeScreen(String msg) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("msg", msg);
	mv.setViewName("Home");
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
