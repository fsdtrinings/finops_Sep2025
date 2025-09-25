package task1;

import java.time.LocalDate;

public class MainApp {

	public static void main(String[] args) {
		
		Account a = new Account(1, "test", 5000,2000, false, 123, LocalDate.of(2025, 4, 10));
		
		try
		{
			System.out.println(a);
			BankingProcess process = new BankingProcess(a);
			process.doWithdraw(7000);
			
		} catch (BankingException e) {
			System.out.println(" Exception : "+e.getMessage());
		}
		
	}
}
