package streamapi;

@FunctionalInterface
interface Payment
{
	public int doPayment();
}


class BankingLogic implements Payment
{

	@Override
	public int doPayment() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


public class LamdbaDemo 
{
	public static void main(String[] args) {
		
		Payment p = new Payment() {
			
			@Override
			public int doPayment() {
				return 100;
			}
		};
		System.out.println(p.doPayment());
		
		Payment p2 = ()->{
			return 200;
		};
		
		System.out.println(p2.doPayment());
		
		
		
		
	}
	

}




















