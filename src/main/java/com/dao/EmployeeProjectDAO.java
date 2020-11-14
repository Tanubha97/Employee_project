package com.dao;

import com.bean.Employee;
import com.bean.Project;
import com.entity.EmployeeEntity;
import com.entity.ProjectEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProjectDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional
	public Integer addEmployee(Employee employee)throws Exception{
		EmployeeEntity empEntity=new EmployeeEntity();
		empEntity.setEmployeeName(employee.getEmployeeName());
		empEntity.setGender(employee.getGender());
		empEntity.setSkill(employee.getSkill());
		ProjectEntity project=em.find(ProjectEntity.class, employee.getProjectId());
		empEntity.setProject(project);
		em.persist(empEntity);
		project.setResourceCount(project.getResourceCount()+1);
		Integer empId=empEntity.getEmployeeId();
		return empId;
	}
	
	public Project getProjectDetails(String projectId)throws Exception{
		ProjectEntity projectEntity=em.find(ProjectEntity.class, projectId);
		Project project=new Project();
		project.setTechnology(projectEntity.getTechnology());
		project.setResourceCount(projectEntity.getResourceCount());
		return project;
	}
	
	public List<String> getAllProjects() {
		Query q=em.createQuery("SELECT p.projectId FROM ProjectEntity p");
		List<String> projectIds=q.getResultList();
		return projectIds;
	
	}
	
	public int getEmployeeStatus(Integer empId)throws Exception{
		int flag=-1;
		EmployeeEntity empEntity=em.find(EmployeeEntity.class, empId);
		if(empEntity==null){
			flag=0;
		}else{
			if(empEntity.getProject()==null){
				flag=1;
			}
			
		}
		return flag;
	}
	
	@Transactional
	public void deallocateEmployee(Integer empId)throws Exception{
		EmployeeEntity empEntity=em.find(EmployeeEntity.class, empId);
		empEntity.getProject().setResourceCount(empEntity.getProject().getResourceCount()-1);
		empEntity.setProject(null);
	}
	
	public List<Employee> getEmployeeDetails()throws Exception{
		List<Employee> empList=new ArrayList<Employee>();
		Query q=em.createQuery("SELECT e FROM EmployeeEntity e");
		List<EmployeeEntity> recList=q.getResultList();
		for(EmployeeEntity emp: recList){
			Employee employee=new Employee();
			employee.setEmployeeId(emp.getEmployeeId());
			employee.setEmployeeName(emp.getEmployeeName());
			if(emp.getProject()==null){
				employee.setProjectId(null);
			}else{
				employee.setProjectId(emp.getProject().getProjectId());
			}
			employee.setSkill(emp.getSkill());
			empList.add(employee);
		}
		return empList;
	}
	
	
	

}
