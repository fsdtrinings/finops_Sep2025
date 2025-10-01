package com.cg.hib.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductOrder {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int orderId;
	
	private int totalAmount;
	private LocalDate orderDate;
	private String status;
	
	// -----
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")// Becoz FK must be maintained at Productorder Table Side
	private Customer customer;

	public ProductOrder(int totalAmount, LocalDate orderDate, String status) {
		super();
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.status = status;
	}
	
	
	
	//private List<OrderItem> orderItems;
	
	
	
	
}








