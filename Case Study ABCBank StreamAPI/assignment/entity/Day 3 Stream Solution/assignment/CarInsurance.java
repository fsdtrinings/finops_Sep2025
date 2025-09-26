package streamapi.flatmap.assignment;



public class CarInsurance extends Insurance{

	private int premiumAmount;
	private int sumAssured;
	public CarInsurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarInsurance(int policyId, String insuranceName) {
		super(policyId, insuranceName);
		// TODO Auto-generated constructor stub
	}
	public CarInsurance(int policyId, String insuranceName, int premiumAmount, int sumAssured) {
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
