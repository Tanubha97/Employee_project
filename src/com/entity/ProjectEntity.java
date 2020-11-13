package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Project")
public class ProjectEntity {
	@Id
	private String projectId;
	private String technology;
	private int resourceCount;
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public int getResourceCount() {
		return resourceCount;
	}
	public void setResourceCount(int resourceCount) {
		this.resourceCount = resourceCount;
	}
	
	
	

}
