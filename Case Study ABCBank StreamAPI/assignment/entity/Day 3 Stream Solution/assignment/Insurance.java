package streamapi.flatmap.assignment;

public class Insurance {
	
	private int policyId;
	private String insuranceName;
	public Insurance(int policyId, String insuranceName) {
		super();
		this.policyId = policyId;
		this.insuranceName = insuranceName;
	}
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	@Override
	public String toString() {
		return "Insurance [policyId=" + policyId + ", insuranceName=" + insuranceName + "]";
	}
	
	
	
	

}
