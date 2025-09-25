package task1;

import java.util.Comparator;

public class SortAccountsBasedOnName implements Comparator<Account>{

	@Override
	public int compare(Account o1, Account o2) {
		
		return o1.getAccountHolderName().compareTo(o2.getAccountHolderName());
	
	}
	
	

}
