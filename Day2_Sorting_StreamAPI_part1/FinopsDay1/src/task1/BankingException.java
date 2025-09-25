package task1;

public class BankingException extends Exception{
	
	String message;

	public BankingException(String message) {
		this.message = message;
		System.out.println("inside banking Exception "+message);
	}
	


}

class InsufficientFundsException extends BankingException
{
	public InsufficientFundsException(int balance,int amount)
	{
		super("InsufficientFunds Actual Balance "+balance+" Fund Withdaw "+amount);
	}
}

class DailyLimitExceededException  extends BankingException {
	public DailyLimitExceededException(int limit,int amount) {
		super("Daily Limit Exceed Actual Max Limit "+limit+" Fund Withdaw "+amount);
	}
}

class AccountBlockedException extends BankingException {
    public AccountBlockedException(String reason) {
        super("Account is blocked! Reason: " + reason);
    }
}

class FraudDetectionException extends RuntimeException {
    public FraudDetectionException(String details) {
        super("Fraud detected! Details: " + details);
    }
}


