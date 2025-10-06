package com.mkj.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empCode;
	
	private String empName;
	private String techName;
	private String designation;
	
	private int salary;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "docid")
	private KYCDocuments empDocs;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "profileId")
	private Profile profile;
	
	
	//private Project project;
}














