package streamapi.flatmap.assignment;

import java.util.List;

public class Account {

	private int accountName;
	private int balance;
	private List<Policy> allPolicies;
	private String location;
	private List<Transaction> allTransactions;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountName, int balance, List<Policy> allPolicies,String location) {
		super();
		this.accountName = accountName;
		this.location = location;
		this.balance = balance;
		this.allPolicies = allPolicies;
	}
	
	
	public List<Transaction> getAllTransactions() {
		return allTransactions;
	}
	public void setAllTransactions(List<Transaction> allTransactions) {
		this.allTransactions = allTransactions;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAccountName() {
		return accountName;
	}
	public void setAccountName(int accountName) {
		this.accountName = accountName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public List<Policy> getAllPolicies() {
		return allPolicies;
	}
	public void setAllPolicies(List<Policy> allPolicies) {
		this.allPolicies = allPolicies;
	}
	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", balance=" + balance + "]";
	}
	
	
}
