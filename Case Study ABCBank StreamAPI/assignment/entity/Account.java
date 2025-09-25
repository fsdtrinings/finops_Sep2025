package assignment.entity;

import java.util.List;

public class Account {

	private String accountNumber;
	private String accountHolderName;
	private int balance;
	final private int LOW_BALANCE = 3000; 
	private List<Policy> policy;
	private List<Transactions> transactions;
	private String branchLocation; // eg: Delhi , Mumbai Chennai , Pune , Hydrabad etc
}
