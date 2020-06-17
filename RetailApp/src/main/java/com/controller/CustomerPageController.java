package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crude.CustomerDao;
import com.pojo.Customer;
@Controller
public class CustomerPageController {

	@RequestMapping("CreateCustomer")
	public ModelAndView CreateCustomer(String msg) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("msg", msg);
	mv.setViewName("CreateCustomer");
	return mv;
	}
	
	@RequestMapping("UpdateCustomer")
	public ModelAndView UpdateCustomerScreen(String msg,Customer cus,HttpServletResponse r) throws IOException {
		cus =CustomerDao.getcustomerbycustomerid(cus);
		if(cus==null) {
			r.sendRedirect("Home?msg=Customer with given id   was not found");
			}
			ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("c", cus);
	mv.setViewName("UpdateCustomer");
	return mv;
	}
	
	@RequestMapping("DeleteCustomer")
	public ModelAndView DeleteCustomerScreen(String msg,Customer cus,HttpServletResponse r) throws IOException {
		cus =CustomerDao.getcustomerbycustomerid(cus);
		if(cus==null) {
			r.sendRedirect("Home?msg=Customer with given id   was not found");
			}
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
	@RequestMapping("viewcustomer")
	public ModelAndView view(String msg,Customer cus,HttpServletResponse r) throws IOException {
		cus =CustomerDao.getcustomerbycustomerid(cus);
		if(cus==null) {
			r.sendRedirect("Home?msg=Customer with given id   was not found");
			}
			ModelAndView mv=new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("c", cus);
	mv.setViewName("viewcustomer");
	return mv;
	}
	
	
}
