package com.sanjib.hcl.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepertmentController {
	
	@Autowired
	private DepertmentRepository deptRepo;
	
	@PostMapping(value = "/savDept")
	public DepertmentEntity addDept(@RequestBody DepertmentEntity deptEntity) {
		
		return deptRepo.save(deptEntity);
	}//
	
}
