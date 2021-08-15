package com.sanjib.hcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjib.hcl.entity.EmployeeEntity;
import com.sanjib.hcl.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public String addAllEmployee(List<EmployeeEntity> empList)throws Exception {
		try {
			empRepo.saveAll(empList);
			log.debug("Employee added succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception ServiceImpl class");
			throw e;
		}
		return "Employee Added";	
	}//addAllEmployee(-)

	@Override
	public EmployeeEntity getEmployeeById(Long id) throws Exception {
		EmployeeEntity employeeEntity=null;
		Optional<EmployeeEntity> empOptional=null;
		try {
			employeeEntity= empRepo.getByEmpId(id);
			//empOptional= empRepo.findById(id);
			log.debug("Employee added succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception ServiceImpl class");
			throw e;
		}
		return employeeEntity;
	}

	@Override
	public EmployeeEntity getEmployeeByEmailId(String email) throws Exception {
		EmployeeEntity employeeEntity=null;
		try {
			employeeEntity= empRepo.getByEmailId(email);
			log.debug("Employee added succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception ServiceImpl class");
			throw e;
		}
		return employeeEntity;
	}

	@Override
	public EmployeeEntity getEmployeeByName(String name) throws Exception {
		EmployeeEntity employeeEntity=null;
		try {
			employeeEntity= empRepo.getByName(name);
			log.debug("Employee added succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception ServiceImpl class");
			throw e;
		}
		return employeeEntity;
	}

	@Override
	public List<EmployeeEntity> getEmployeeByLocation(String location) throws Exception {
		List<EmployeeEntity> employeeEntity=null;
		try {
			employeeEntity= empRepo.getByLocation(location);
			log.debug("Employee added succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception ServiceImpl class");
			throw e;
		}
		return employeeEntity;
	}

	@Override
	public List<EmployeeEntity> getEmployeeByExprience(String exp) throws Exception {
		List<EmployeeEntity> employeeEntity=null;
		try {
			employeeEntity= empRepo.getByExperience(exp);
			log.debug("Employee added succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception ServiceImpl class");
			throw e;
		}
		return employeeEntity;
	}

	@Override
	public Integer updateEmployeeByName(String name) throws Exception {
		Integer value=null;
		EmployeeEntity employeeEntity=null;
		try {
			employeeEntity=empRepo.getByName(name);
			employeeEntity.setStatus("Bench");
			//value=empRepo.updateByName(name);
			log.debug("Employee added succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception ServiceImpl class");
			throw e;
		}
		return value;
	}

	@Override
	public List<EmployeeEntity> getEmployeeByLocationAndExp(String loc, String exp) throws Exception {
		List<EmployeeEntity> empEntities=null;
		try {
			empEntities= empRepo.getByLocationAndExperience(loc, exp);
			log.debug("Employee added succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception ServiceImpl class");
			throw e;
		}
		return empEntities;
	}

}//class
