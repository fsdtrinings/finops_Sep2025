package streamapi.flatmap.assignment;



public class HealthInsurance extends Insurance{

	private int premiumAmount;
	private int sumAssured;
	public HealthInsurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HealthInsurance(int policyId, String insuranceName) {
		super(policyId, insuranceName);
		// TODO Auto-generated constructor stub
	}
	public HealthInsurance(int policyId, String insuranceName, int premiumAmount, int sumAssured) {
		super(policyId, insuranceName);
		this.premiumAmount = premiumAmount;
		this.sumAssured = sumAssured;
	}
	public int getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(int premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public int getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(int sumAssured) {
		this.sumAssured = sumAssured;
	}
	@Override
	public String toString() {
		return "CarInsurance [premiumAmount=" + premiumAmount + ", sumAssured=" + sumAssured + "]";
	}
	
	
}
