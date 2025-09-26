package streamapi.flatmap.assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class MyDateSortLogic implements Comparator<Account>
{
	LocalDate queryDate; // 2024,April , 1
	
	

	public MyDateSortLogic(LocalDate queryDate) {
		super();
		this.queryDate = queryDate;
	}

	@Override
	public int compare(Account a1, Account a2) {
		
		LocalDate d1 = getnextdate(a1);
		LocalDate d2 = getnextdate(a2);
		
		return d1.compareTo(d2);
		
	}
	
	public LocalDate getnextdate(Account a)
	{
		for(Policy p : a.getAllPolicies())
		{
			if(p.getPremiumdate().isAfter(queryDate)) // 2025 , Sep 14
			{
				return p.getPremiumdate();
			}
		}
		//return null;
		return LocalDate.MAX; // max value of Date
		
	}
	
}


public class MainClass {

	List<Account> allAccounts;

	public MainClass() {

		// data creation

		Account a1 = new Account(101, 15000, null, "Banglore");
		Account a2 = new Account(102, 85000, null, "Pune");
		Account a3 = new Account(103, 17000, null, "Banglore");

		// create Some insurance

		Insurance carInsurance = new CarInsurance(0, "Car Insurance", 200, 8000);
		Insurance healthInsurance = new CarInsurance(0, "Health Insurance", 1200, 80000);

		// Policy for Account a1
		Policy p1a1 = new Policy(healthInsurance, LocalDate.of(2025, 3, 1), LocalDate.of(2026,5, 28));
		p1a1.getInsuranceType().setPolicyId(new Random().nextInt(10000, 10999));

		Policy p2a1 = new Policy(carInsurance, LocalDate.of(2025, 1, 10), LocalDate.of(2026, 1, 9));
		p2a1.getInsuranceType().setPolicyId(new Random().nextInt(10000, 10999));

		Policy p3a1 = new Policy(carInsurance, LocalDate.of(2025, 6, 10), LocalDate.of(2026, 6, 9));
		p3a1.getInsuranceType().setPolicyId(new Random().nextInt(10000, 10999));

		List<Policy> alAllPolicy = Arrays.asList(p1a1, p2a1, p3a1);
		a1.setAllPolicies(alAllPolicy);

		// Policy for Account a2
		Policy p1a2 = new Policy(healthInsurance, LocalDate.of(2025, 7, 15), LocalDate.of(2026, 7, 14));
		p1a2.getInsuranceType().setPolicyId(new Random().nextInt(10000, 10999));

		List<Policy> a2AllPolicy = Arrays.asList(p1a2);
		a2.setAllPolicies(a2AllPolicy);

		// Policy for Account a3
		Policy p1a3 = new Policy(healthInsurance, LocalDate.of(2025, 12, 15), LocalDate.of(2026, 12, 14));
		p1a3.getInsuranceType().setPolicyId(new Random().nextInt(10000, 10999));

		Policy p2a3 = new Policy(healthInsurance, LocalDate.of(2025, 4, 15), LocalDate.of(2026, 3, 14));
		p2a3.getInsuranceType().setPolicyId(new Random().nextInt(10000, 10999));

		List<Policy> a3AllPolicy = Arrays.asList(p1a3, p2a3);
		a3.setAllPolicies(a3AllPolicy);

		int t=701;
		Transaction t1a1 = new Transaction(t++,1200, "UPI");
		Transaction t2a1 = new Transaction(t++,60, "UPI");
		Transaction t3a1 = new Transaction(t++,10, "Cash");
		Transaction t4a1 = new Transaction(t++,12000, "UPI");
		List<Transaction> tListA1 = Arrays.asList(t1a1,t2a1,t3a1,t4a1);
		
		Transaction t1a2 = new Transaction(t++,800, "Cash");
		Transaction t2a2 = new Transaction(t++,12000, "UPI");
		List<Transaction> tListA2 = Arrays.asList(t1a2,t2a2);
		
		Transaction t1a3 = new Transaction(t++,1800, "Cash");
		List<Transaction> tListA3 = Arrays.asList(t1a3);
		

		
		a1.setAllTransactions(tListA1);
		a2.setAllTransactions(tListA2);
		a3.setAllTransactions(tListA3);
		
		
		
		allAccounts = Arrays.asList(a1, a2, a3);

	}

	
	public static void main(String[] args) {
		MainClass app = new MainClass();
		 app.showRecords();
		 System.out.println("\n\n\n");
		 // app.getAccountsByLocation("Banglore");
		// app.groupAccountsBasedOnLocation();
		//app.getInsuranceNameFromAccountsList();
		//app.groupAccountBasedOnInsuranceType();
		// app.getAccountPolicy();
		// app.getFilterBasedOnTransactionAndLocation();
		// app.upcoingPremiumOfPolicy();
		// app.getupcoingPremiumOfPolicyBasedOnAccounts();
		 app.doSortedUpcomingPolicy();
	}

	
	public void upcoingPremiumOfPolicy()
	{
		
		LocalDate queryDate = LocalDate.of(2025, 9, 1);
		/*List<Account> list = allAccounts.stream().filter(a -> a.getAllPolicies()!=null)
										.filter(a->a.getAllPolicies()
												.stream()
												.filter(p->p.getPremiumdate().isAfter(queryDate))
												).toList();
												*/
		List<Policy> list = allAccounts.stream().flatMap(a->a.getAllPolicies().stream()
				                     .filter(p->p.getPremiumdate().isAfter(queryDate)) ).toList();
	
		for (Policy policy : list) {
			System.out.println(policy);
		}
	}
	
	public void getupcoingPremiumOfPolicyBasedOnAccounts()
	{
		List<Account> list = 
		allAccounts.stream().filter((a)->a.getAllPolicies().stream()
							.anyMatch(p->p.getPremiumdate().isAfter(LocalDate.of(2025, 9, 1)))).toList();
		
		for (Account a : list) {
			System.out.println(a);
		}
	}
	
	
	
	
	// Extract Accounts based on Transaction & brachLocation
	public void getFilterBasedOnTransactionAndLocation()
	{
		
		List<Account> list = allAccounts.stream()
										.filter(a -> a.getLocation().equalsIgnoreCase("banglore"))  
										.filter(a -> a.getAllTransactions()
													  .stream()
		                                              .anyMatch(tt -> tt.gettType().equalsIgnoreCase("upi"))) 
													  .toList();

		    list.forEach(acc -> System.out.println(acc.getAccountName()));
	}
	
	
	public void showRecords() {
		allAccounts.stream().forEach((a) -> {
			printAccount(a);
		});

	}

	public void getAccountsByLocation(String location) {
		allAccounts.stream().filter((a) -> a.getLocation().equalsIgnoreCase(location)).forEach((a) -> {
			printAccount(a);
		});
	}

	public void groupAccountsBasedOnLocation() {
		Map<String, List<Account>> map = allAccounts.stream().collect(Collectors.groupingBy((a) -> a.getLocation()));

		for (Map.Entry<String, List<Account>> entry : map.entrySet()) {

			System.out.println("Location " + entry.getKey());

			for (Account account : entry.getValue()) {
				System.out.println(account.getAccountName() + " " + account.getBalance());
			}

			System.out.println("\n");
		}
	}

	public void groupAccountBasedOnInsuranceType() {
		/*
		 * allAccounts.stream().collect(Collectors. toMap( (a)-> cannot use flat map
		 * here and extract Insurance name, .collect(Collectors.groupingBy( e ->
		 * e.getKey(), // key = insuranceName Collectors.mapping(e -> e.getValue(), //
		 * value = Account Collectors.toList())));
		 */

		/*
		 * 
		 * Map<Integer, Integer> map = Stream.of(10,20,45,89,63,37)
		 * .collect(Collectors.toMap((k)->{ return new Random().nextInt(500); }, e->e));
		 */

		/*
		 * allAccounts.stream().collect(Collectors.toMap( (a)->{
		 * ((Account)a).getAllPolicies().stream().collect((p)->{
		 * ((Policy)p).getInsuranceType().getInsuranceName(); })
		 * 
		 * } , ))
		 */

		// 1) Map<Transaction,List<InsuranceAccountPair>>
		// 2) Map<Account,List<Policy>>
		// 3) Map<Account,List<Transaction>>
		
		
		class InsuranceAccountPair 
		{
			String insuranceName;
			Account account;

			InsuranceAccountPair(String name, Account acc) {
				this.insuranceName = name;
				this.account = acc;
			}
		}

		
		Map<String, List<InsuranceAccountPair>> result =
			    allAccounts.stream()
			        .flatMap(account -> account.getAllPolicies().stream()
			            .map(policy -> {
			            	return new InsuranceAccountPair(
			            
			                policy.getInsuranceType().getInsuranceName(),
			                account);
			            })
			        )
			        .collect(Collectors.groupingBy(pair -> pair.insuranceName));							
		
		

		for (Map.Entry<String,List<InsuranceAccountPair>> entry : result.entrySet()) {
			System.out.println("" + entry.getKey());

			for (InsuranceAccountPair pair : entry.getValue()) {
				System.out.println(pair.account.getAccountName()+" "+pair.account.getBalance());
			}

			System.out.println("\n");
		}

	}
	
	//Map<Account,List<Policy>>
	public void getAccountPolicy()
	{
		
		
		
		Map<Account, List<Policy>> map = allAccounts.stream()
				.collect(Collectors.toMap(a->a, a->a.getAllPolicies()));
		
		
		
		
		
		for (Map.Entry<Account, List<Policy>> entry: map.entrySet() ) {
			
			System.out.println(entry.getKey());
			System.out.print(" "+entry.getValue()+"\n\n");
		}
		
	}
	

	public void getInsuranceNameFromAccountsList() {

		allAccounts.stream().forEach(account -> {
			account.getAllPolicies().stream().map(p -> p.getInsuranceType().getInsuranceName())
					.forEach(in -> System.out.print(in + " "));
		});

	}

	public void printAccount(Account a) {
		System.out.println("\n_________________________________________________________\n");
		System.out.println("Acc. Number : " + a.getAccountName() + " Balance:  " + a.getBalance() + " Location :  "
				+ a.getLocation() + " \n");
		if (a.getAllPolicies() != null && a.getAllPolicies().isEmpty() == false) {
			a.getAllPolicies().stream().forEach((p) -> {
				System.out.println(
						p.getInsuranceType().getInsuranceName() + "\t[ " + p.getInsuranceType().getPolicyId() + "]");
				System.out.println(
						"Premium Date : " + p.getPolicyEndDate() + " End Date : " + p.getPolicyEndDate() + "\n");
			});
		}
		
		System.out.println("Transactions \n");
		for (Transaction t : a.getAllTransactions()) {
			System.out.println(t.gettId()+" "+t.gettAmount()+" "+t.gettType());
		}
	}
	
	
	// ---------------------- Sorting -----------------------
	
	// Sort them based on Upcoming Premium Date
	
	public void doSortedUpcomingPolicy()
	{
		MyDateSortLogic compareCode = new MyDateSortLogic(LocalDate.of(2025, 4, 1));
		
		List<Account> list = 
				allAccounts.stream().filter(a->a.getAllPolicies().stream()
						.anyMatch(p->p.getPremiumdate().isAfter(LocalDate.of(2025, 4, 1)))).
				sorted(compareCode)
				.toList();
					
		for (Account account : list) {
			System.out.println(account);
		}
		
	}
	

}// end class
