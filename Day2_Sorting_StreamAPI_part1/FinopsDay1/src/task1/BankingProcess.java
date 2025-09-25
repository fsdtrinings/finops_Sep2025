package task1;

public class BankingProcess implements AutoCloseable
{

	private Account account;
	
	public BankingProcess(Account account)
	{
		this.account = account;
	}
	
	public void doWithdraw(int amountWithdaw)throws BankingException
	{
		// all code comes here 
		if(account.getPin() == 123)
		{
			int actualBalance = account.getBalance();
			if(amountWithdaw<actualBalance)
			{
				// some code
			}
			else
			{
				throw new InsufficientFundsException(actualBalance, amountWithdaw);
			}
		}
		else
		{
			throw new FraudDetectionException("Invalid Pin "+account.getPin());
		}
	}
	
	@Override
	public void close() throws BankingException {
		// just a kind of simulation
		System.out.println("Ending Banking process");
		
	}
	
}
