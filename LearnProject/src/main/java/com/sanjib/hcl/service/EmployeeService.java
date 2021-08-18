package com.sanjib.hcl.service;

import java.util.List;

import com.sanjib.hcl.entity.EmployeeEntity;

public interface EmployeeService {

	//public String addAllEmployee(List<EmployeeEntity> empList);
	
	public List<EmployeeEntity> addAllEmployee(List<EmployeeEntity> empList);
	
	//public EmployeeEntity addEmployee(EmployeeEntity empList);

	public EmployeeEntity getEmployeeById(Long id) throws Exception;

	public EmployeeEntity getEmployeeByEmailId(String email) throws Exception;

	public EmployeeEntity getEmployeeByName(String name)throws Exception;

	public List<EmployeeEntity> getEmployeeByLocation(String location)throws Exception;

	public List<EmployeeEntity> getEmployeeByExprience(String exp)throws Exception;

	public Integer updateEmployeeByName(String name)throws Exception;

	public List<EmployeeEntity> getEmployeeByLocationAndExp(String loc, String exp)throws Exception;

}// interface
