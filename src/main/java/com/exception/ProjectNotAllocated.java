package com.exception;

public class ProjectNotAllocated extends Exception{
	public ProjectNotAllocated(){
		super("No project allocated to given employee");
	}

}
