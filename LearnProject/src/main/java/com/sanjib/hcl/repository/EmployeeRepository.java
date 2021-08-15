package com.sanjib.hcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanjib.hcl.entity.EmployeeEntity;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	
	public EmployeeEntity getByEmpId(Long id);
	
	public EmployeeEntity getByEmailId(String email);
	
	public EmployeeEntity getByName(String name);
	
	public List<EmployeeEntity> getByLocation(String location);
	
	public List<EmployeeEntity> getByExperience(String exp);
	
	//public Integer updateByName(String name);
	
	public List<EmployeeEntity> getByLocationAndExperience(String loc, String exp);

}//interface
