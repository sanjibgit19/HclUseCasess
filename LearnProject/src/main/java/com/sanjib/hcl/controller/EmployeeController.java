package com.sanjib.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sanjib.hcl.entity.EmployeeEntity;
import com.sanjib.hcl.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/api")
@Api
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping(value = "/employee/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "RestApi", response = String.class)
	public String addAllEmployee(@RequestBody List<EmployeeEntity> empList) {
		String statusMsg = null;
		try {
			statusMsg = empService.addAllEmployee(empList);
			log.debug("Controller api executed");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in Controller class");
		}
		return statusMsg;
	}// addAllEmployee(-)

	@GetMapping(value = "/getEmployeeById/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "RestApi" , response = EmployeeEntity.class)
	public EmployeeEntity getEmployeeById(@PathVariable("empId") Long id) {
		EmployeeEntity empEntity = null;

		try {
			empEntity = empService.getEmployeeById(id);
			log.debug("Controller api executed");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in Controller class");
		}

		return empEntity;
	}//
	
	@RequestMapping(value = "/getEmployeeByEmailId/{email}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ApiOperation(value = "RestApi", response = EmployeeEntity.class)
	public EmployeeEntity getEmployeeByEmailId(@PathVariable String email) {
		EmployeeEntity empEntity = null;

		try {
			empEntity = empService.getEmployeeByEmailId(email);
			log.debug("Controller api executed");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in Controller class");
		}

		return empEntity;
		
	}//
	
	@RequestMapping(value = "/getEmployeeByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ApiOperation(value = "RestApi", response = EmployeeEntity.class)
	public EmployeeEntity getEmployeeByName(@PathVariable("name") String name) {
		
		EmployeeEntity empEntity = null;

		try {
			empEntity = empService.getEmployeeByName(name);
			log.debug("Controller api executed");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in Controller class");
		}

		return empEntity;	
		
	}//

	@GetMapping(value = "/EmployeeByLocation/{loc}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "RestApi", response = EmployeeEntity.class)
	public List<EmployeeEntity> getEmployeeByLocation(@PathVariable("loc") String location) {
		List<EmployeeEntity> empEntity = null;

		try {
			empEntity = empService.getEmployeeByLocation(location);
			log.debug("Controller api executed");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in Controller class");
		}

		return empEntity;
	}//

	@RequestMapping(value = "/getEmployeeByExprience/{exp}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ApiOperation(value = "RestApi", response = EmployeeEntity.class)
	public List<EmployeeEntity> getEmployeeByExprience(@PathVariable("exp") String exp){
		List<EmployeeEntity> empEntity = null;

		try {
			empEntity = empService.getEmployeeByExprience(exp);
			log.debug("Controller api executed");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in Controller class");
		}

		return empEntity;
	}//
	
	
	@RequestMapping(value = "/getEmployeeByLocationAndExp/{loc}/{exp}", produces = MediaType.ALL_VALUE, method = RequestMethod.GET)
	@ApiOperation(value = "restapi", response = EmployeeEntity.class)
	public List<EmployeeEntity> getEmployeeByLocationAndExp(@PathVariable("loc") String loc, @PathVariable("exp") String exp) {
		List<EmployeeEntity> employeeEntities=null;

		try {
			employeeEntities = empService.getEmployeeByLocationAndExp(loc, exp);
			log.debug("Controller api executed");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in Controller class");
		}

		return employeeEntities;
		
	}//
	
}// class
