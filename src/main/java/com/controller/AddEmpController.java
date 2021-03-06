package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.service.EmployeeProjectService;


@Controller
public class AddEmpController {
	
	@Autowired
	EmployeeProjectService service;
	
	
	@RequestMapping("/home.htm")
	public ModelAndView displayHomePage() throws Exception{	
		ModelAndView mView=new ModelAndView();
		mView.setViewName("home");
		return mView;
	}
	
	@RequestMapping("/addEmployeeForm.htm")
	public ModelAndView displayAddEmployeeForm(ModelMap map) throws Exception{	
		Employee employee=new Employee();
		map.addAttribute(employee);
		ModelAndView mView=new ModelAndView();
		mView.setViewName("addEmployee");
		return mView;
	}
	
	@ModelAttribute("projectList")
	public Map<String,String> populateProject()throws Exception {
		
		List<String> allProjects = service.getAllProjects();
		Map<String,String> projectMap=new HashMap<String,String>();
				
		for(String projectId:allProjects){
			projectMap.put(projectId,projectId);
		}
		
		return projectMap;
		
	}
	
	@RequestMapping(value="/addEmployee.htm",method=RequestMethod.GET)
	public ModelAndView AddEmployee(@ModelAttribute Employee employee)throws Exception{ 
		ModelAndView mView=new ModelAndView();
		
		try{	
			Integer employeeId= service.addEmployee(employee);
			mView.addObject("MESSAGE", "Employee Added Successfully, EmpID : "+employeeId);
			mView.setViewName("/addEmployee");
		}catch(Exception e){
			mView.addObject("MESSAGE","ERROR: "+ e.getMessage());
			mView.setViewName("/addEmployee");
		}
		
		return mView;
	}

}
