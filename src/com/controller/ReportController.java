package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.service.EmployeeProjectService;

@Controller
public class ReportController {

	@Autowired
	EmployeeProjectService service;
	
	@RequestMapping(value="/reportForm.htm")
	public ModelAndView employeeReport()throws Exception{ 
		ModelAndView mView=new ModelAndView();
		
		try{
			List<Employee> employeeList=service.getEmployeeDetails();
			System.out.println(employeeList);
			mView.addObject("empList", employeeList);
			mView.setViewName("/report");
		}catch(Exception e){
			mView.addObject("MESSAGE","ERROR: "+ e.getMessage());
			mView.setViewName("/report");
		}
		return mView;
	}

}
