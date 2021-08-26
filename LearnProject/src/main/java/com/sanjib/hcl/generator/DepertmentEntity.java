package com.sanjib.hcl.generator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "dept_tab")
public class DepertmentEntity {
	
	@Id
	@GenericGenerator(name = "cust_gen", strategy = "com.sanjib.hcl.generator.CustomSequenceGen")
	@GeneratedValue(generator = "cust_gen")
	private String deptId;
	
	private String deptName;

}//class
