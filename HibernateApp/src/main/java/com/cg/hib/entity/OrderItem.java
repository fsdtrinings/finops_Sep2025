package com.cg.hib.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int orderItemId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pid")
	private Product product;
	
	

	@ManyToOne
	@JoinColumn(name = "poid")
	private ProductOrder order;
	
	private int quantity;
	private int unitPrice;
	public OrderItem(Product product, int quantity, int unitPrice) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	
	
}
