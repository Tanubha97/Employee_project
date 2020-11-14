package com.service;

import com.bean.Employee;
import com.bean.Project;
import com.dao.EmployeeProjectDAO;
import com.exception.NoResourceException;
import com.exception.SkillMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeProjectService{
	
	@Autowired
	EmployeeProjectDAO dao;
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see com.service.IEmployeeProjectService#addEmployee(com.bean.Employee)
	 */
	public Integer addEmployee(Employee employee)throws Exception{
		Project project=dao.getProjectDetails(employee.getProjectId());
		if( !(project.getTechnology().equalsIgnoreCase(employee.getSkill()))){
			throw new SkillMismatchException();
		}
		if(project.getResourceCount()==10){
			throw new NoResourceException();
		}
		Integer empId=dao.addEmployee(employee);
		return empId;
	}

	/*
	 * 
	 * (non-Javadoc)
	 * @see com.service.IEmployeeProjectService#getAllProjects()
	 */
	public List<String> getAllProjects() {
		return dao.getAllProjects();
		
	}
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see com.service.IEmployeeProjectService#deAllocateEmployee(int)
	 */
	public void deAllocateEmployee(int employeeId) throws Exception{
		int flag=dao.getEmployeeStatus(employeeId);
		if(flag==0){
			throw new Exception("Employee does not exists");
		}
		if(flag==1){
			throw new Exception("No project allocated to given employee");
		}
		dao.deallocateEmployee(employeeId);
	}
	
    /*
     * 
     * (non-Javadoc)
     * @see com.service.IEmployeeProjectService#getEmloyeeDetails()
     */
	public List<Employee> getEmployeeDetails()throws Exception{
		List<Employee> empList =dao.getEmployeeDetails();
		return empList;
	}


}
