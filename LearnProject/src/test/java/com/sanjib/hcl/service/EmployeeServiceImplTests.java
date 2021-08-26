package com.sanjib.hcl.service;

import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sanjib.hcl.entity.EmployeeEntity;
import com.sanjib.hcl.repository.EmployeeRepository;


//@SpringBootTest

public class EmployeeServiceImplTests {
	
	@Autowired
	private EmployeeService empService;
	
	@MockBean
	private EmployeeRepository empRepo;
	
	@Test
	public void getEmployeeByIdTest() throws Exception{
		Long id=1000L;
		//when(empRepo.getByEmpId(id)).thenReturn(Stream.of(new EmployeeEntity(1000, null,null,null,null)).collect(Collectors.toList()));
		
	}//

}//class