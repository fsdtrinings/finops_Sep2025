package com.cg.hib.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String name;
	private int unitcost;
	private int sellingPrice;
	
	public Product(String name, int unitcost, int sellingPrice) {
		super();
		this.name = name;
		this.unitcost = unitcost;
		this.sellingPrice = sellingPrice;
	}
	
	
	

}
