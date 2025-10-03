package com.cg.hib.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
// ----- anntation to anable the level2
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "myId")
	@SequenceGenerator(
			name = "myId",
			initialValue = 1000,
			allocationSize = 1
			)
	private int cid;
	@Column(name = "fullname")
	private String customerName;
	
	@Column(unique = true)
	private String email;
	
	@Column(updatable = false)
	private long phone;
	
	@Embedded
	private Address address;
	
	@OneToOne(cascade =  {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name = "accountlinked") // Map the FK
	private BankAccount bankAccount;
	
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	@ToString.Exclude
	private List<ProductOrder> orders = new ArrayList<>();
	
	// mappedBy
	
	
	
	
	public Customer(String customerName, String email, long phone) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.phone = phone;
	}
	
	

}










