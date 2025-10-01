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
//@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int orderItemId;
	
	private Product product;
	private int quantity;
	private int unitPrice;
	
}
