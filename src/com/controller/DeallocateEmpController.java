package com.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.service.EmployeeProjectService;



@Controller
public class DeallocateEmpController {
	
	@Autowired
	EmployeeProjectService service;
	
	
	@RequestMapping("/deallocateEmployeeForm.htm")
	public ModelAndView displayDeallocateEmployeeForm() throws Exception{	
		ModelAndView mView=new ModelAndView();
		mView.setViewName("deallocateEmployee");
		return mView;
	}
	
	@RequestMapping(value="/deAllocateEmployee.htm",method=RequestMethod.GET)
	public ModelAndView deallocateEmployee(HttpServletRequest request)throws Exception{ 
		ModelAndView mView=new ModelAndView();
		Integer employeeId=Integer.parseInt(request.getParameter("empId"));
		try{
			service.deAllocateEmployee(employeeId);
			mView.addObject("MESSAGE", "Employee Deallocated Successfully");
			mView.setViewName("/deallocateEmployee");
		}catch(Exception e){
			mView.addObject("MESSAGE","ERROR: "+ e.getMessage());
			mView.setViewName("/deallocateEmployee");
		}
		
		return mView;
	}

}
