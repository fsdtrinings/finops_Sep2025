package com.cg.hib.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {

	@Id
	private int accountNumber;
	private String bankName;
	private String ifscCode;
}
