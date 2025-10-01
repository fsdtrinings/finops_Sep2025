package com.cg.hib.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

	private String houseDetails;
	private String city;
	private String state;
	private String country = "India";
	
	public Address(String houseDetails, String city, String state) {
		super();
		this.houseDetails = houseDetails;
		this.city = city;
		this.state = state;
	}
	
	

}//end class
