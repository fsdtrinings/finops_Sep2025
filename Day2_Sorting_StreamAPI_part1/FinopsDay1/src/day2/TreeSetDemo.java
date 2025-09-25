package day2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import task1.Account;
import task1.SortAccountsBasedOnName;

public class TreeSetDemo {

	public static void main(String[] args) {

		TreeSet<Account> allAccounts = new TreeSet<>();
		
		Account a1 = new Account(1, "test", 7000,2000, false, 123,  LocalDate.of(2025, 4, 10));
		Account a2 = new Account(2, "abc", 5000,2000, false, 123,  LocalDate.of(2025, 12, 10));
		Account a3 = new Account(3, "hyhs", 2000,2000, false, 123,  LocalDate.of(2025, 7, 10));
		Account a4 = new Account(4, "bfdhs", 12000,2000, false, 123,  LocalDate.of(2025, 1, 10));
		Account a5 = new Account(5, "aabhs", 52000,2000, false, 123,  LocalDate.of(2025, 1, 24));
		Account a6 = new Account(6, "ba", 29000,2000, false, 123,  LocalDate.of(2025, 12, 18));
		
		
		allAccounts.add(a1);
		allAccounts.add(a2);
		allAccounts.add(a3);
		allAccounts.add(a4);
		allAccounts.add(a5);
		
		
		System.out.println(allAccounts);
		
		List<Account> tempList = new ArrayList<>(allAccounts);
		Collections.sort(tempList, new SortAccountsBasedOnName());
		
		System.out.println(tempList);
		
		
		
		
	}//end main

}//end class
