package com.sanjib.hcl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emp_tab")
public class EmployeeEntity implements Serializable {
	
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "emp_code_seq", initialValue = 1000, allocationSize =1 )
	@GeneratedValue(generator = "gen1", strategy = GenerationType.IDENTITY)
	@Column(length = 10)
	private Long empId;
	
	@Column(length = 50)
	@NotEmpty(message = "Name can Not Be Empty")
	private String name;
	
	@Column(length = 10)
	@NotEmpty(message = "Please select gender")
	private String  gender;
	
	@Column(length = 50)
	private String designation;
	
	@Column(length = 50)
	@Email
	@NotEmpty(message = "Please provide a Valid Mail Id")
	private String  emailId;
	
	@Column(length = 50)
	private String  experience;
	
	@Column(length = 15)
	private Long  phoneNumber;
	
	@Column(length = 50)
	private String  location;
	
	@Column(length = 50)
	private String status;
	

}//class
