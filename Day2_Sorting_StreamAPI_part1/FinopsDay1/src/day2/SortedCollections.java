package day2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import task1.Account;
import task1.SortAccountsBasedOnName;

public class SortedCollections {

	public static void main(String[] args) {

		List<Account> allAccounts = new ArrayList();
		
		Account a1 = new Account(1, "test", 7000,2000, false, 123,  LocalDate.of(2025, 4, 10));
		Account a2 = new Account(2, "abc", 5000,2000, false, 123,  LocalDate.of(2025, 12, 10));
		Account a3 = new Account(3, "hyhs", 2000,2000, false, 123,  LocalDate.of(2025, 7, 10));
		Account a4 = new Account(4, "bfdhs", 12000,2000, false, 123,  LocalDate.of(2025, 5, 10));
		Account a5 = new Account(5, "aabhs", 52000,2000, false, 123,  LocalDate.of(2025,6, 24));
		Account a6 = new Account(6, "ba", 29000,2000, false, 123,  LocalDate.of(2025, 12, 18));
		
		
		allAccounts.add(a1);
		allAccounts.add(a2);
		allAccounts.add(a3);
		allAccounts.add(a4);
		allAccounts.add(a5);
		allAccounts.add(a6);
		
		
		
		// headSet , tailSet
		
		SortedSet<Account> sortedSet = new TreeSet<>(allAccounts);
		
		Account dummyAccount = new Account(0, null, 0,0, false, 0,  LocalDate.of(2025, 4, 1));
		SortedSet<Account> records = sortedSet.headSet(dummyAccount);
		
		for (Account account : records) {
			System.out.println(account);
		}
		
		
		System.out.println(" ----------------------------------");
		
		SortedSet<Account> sortedSet2 = new TreeSet<>(allAccounts);
		
		SortedSet<Account> records2 = sortedSet2.tailSet(dummyAccount);
		
		for (Account account : records2) {
			System.out.println(account);
		}
		
		
		System.out.println(" ----------------------------------");
		
		SortedSet<Account> sortedSet3 = new TreeSet<>(allAccounts);

		Account dummyAccount1 = new Account(0, null, 0,0, false, 0,  LocalDate.of(2025, 4, 1));
		Account dummyAccount2 = new Account(0, null, 0,0, false, 0,  LocalDate.of(2025, 8, 1));
		
		SortedSet<Account> records3 = sortedSet3.subSet(dummyAccount1, dummyAccount2);		
		for (Account account : records3) {
			System.out.println(account);
		}
		
		
		
		
	}//end main

}//end class
