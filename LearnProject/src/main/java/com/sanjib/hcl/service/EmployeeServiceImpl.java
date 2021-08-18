package com.sanjib.hcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sanjib.hcl.entity.EmployeeEntity;
import com.sanjib.hcl.repository.EmployeeRepository;
import com.sanjib.hcl.restexception.EmployeeNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<EmployeeEntity> addAllEmployee(List<EmployeeEntity> empList) {
	//public EmployeeEntity addEmployee(EmployeeEntity empList) {
		
		return empRepo.saveAll(empList);
		 //return empRepo.save(empList);
		/*List<EmployeeEntity> empEntities=null;
		try {
			log.debug("Employee added succesfully in service class");
			empEntities= empRepo.saveAll(empList);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception ServiceImpl class");
			throw e;
		}
		return empEntities;
			*/
	}//addAllEmployee(-)

	@Override
	public EmployeeEntity getEmployeeById(Long id) throws Exception {
		EmployeeEntity employeeEntity=null;
		try {
			
			employeeEntity= empRepo.getByEmpId(id);
//			if(employeeEntity==null) {
//				System.out.println("Exce51964156 is identified in Service Layer");
				//throw new EmployeeNotFoundException("Emplyoee Is not found in DB", "Internal Server Error");
				
//			}else {
//				System.out.println("Else part for Exception exceuted");
//			}
			log.debug("Recod fetched succesfully in service class");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception ServiceImpl class");
			throw e;
			//throw new EmployeeNotFoundException("Emplyoee Is not found in DB", "Internal Server Error");
		}
		return employeeEntity;
	}//getEmployeeById(-)

	@Override
	public EmployeeEntity getEmployeeByEmailId(String email) throws Exception {
		EmployeeEntity employeeEntity=null;
		try {
			employeeEntity= empRepo.getByEmailId(email);
			log.debug("Recod fetched succesfully in service class");
			
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
			log.debug("Recod fetched succesfully in service class");
			
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
			log.debug("Recod fetched succesfully in service class");
			
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
			log.debug("Recod fetched succesfully in service class");
			
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
			log.debug("Employee updated succesfully in service class");
			
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
			log.debug("Recod fetched succesfully in service class");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception ServiceImpl class");
			throw e;
		}
		return empEntities;
	}

}//class
