package com.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crude.AccountDao;
import com.crude.C;
import com.crude.CustomerDao;
import com.crude.TransactionDao;
import com.crude.UserDao;
import com.pojo.Account;
import com.pojo.Customer;
import com.pojo.Transaction;
import com.pojo.UserEx;
import org.springframework.stereotype.Controller;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Acontroller {

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
	@RequestMapping(value = "pdfreport",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport(Account a) {


        ByteArrayInputStream bis = C.Report(a);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
