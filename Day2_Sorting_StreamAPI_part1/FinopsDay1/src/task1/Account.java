package task1;

import java.time.LocalDate;
import java.util.Objects;

public class Account implements Comparable<Account> {

	private int accountNumber;
	private String accountHolderName;
	private int balance;
	private int dailyLimit;
	private boolean isBlocked;
	private int pin;
	private LocalDate aod;// account opening date
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(int accountNumber, String accountHolderName, int balance, int dailyLimit, boolean isBlocked,
			int pin , LocalDate aod) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.dailyLimit = dailyLimit;
		this.isBlocked = isBlocked;
		this.pin = pin;
		this.aod = aod;
	}

	public LocalDate getAod() {
		return aod;
	}


	public void setAod(LocalDate aod) {
		this.aod = aod;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public int getDailyLimit() {
		return dailyLimit;
	}


	public void setDailyLimit(int dailyLimit) {
		this.dailyLimit = dailyLimit;
	}


	public boolean isBlocked() {
		return isBlocked;
	}


	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public int hashCode()
	{
		return accountNumber;
	}


	@Override
	public boolean equals(Object obj) {
	
		if(obj instanceof Account)
		{
			Account a = (Account) obj;
			
			boolean b1 = a.getAccountHolderName().equals(this.accountHolderName);
			boolean b2 = a.getBalance() == this.getBalance();
			
			return b1&&b2;
		}
		else return false;
	}
	
	


	@Override
	public int compareTo(Account account) {
		return this.aod.compareTo(account.aod);
	}


	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", balance="
				+ balance + ", dailyLimit=" + dailyLimit + ", isBlocked=" + isBlocked + ", pin=" + pin + "]";
	}
	
	
}
