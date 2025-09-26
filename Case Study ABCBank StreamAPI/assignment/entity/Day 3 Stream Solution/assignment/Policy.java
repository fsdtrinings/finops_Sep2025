package streamapi.flatmap.assignment;

import java.time.LocalDate;

public class Policy {

	private Insurance insuranceType;
	private LocalDate premiumdate;
	private LocalDate policyEndDate;
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Policy(Insurance insuranceType, LocalDate premiumdate, LocalDate policyEndDate) {
		super();
		this.insuranceType = insuranceType;
		this.premiumdate = premiumdate;
		this.policyEndDate = policyEndDate;
	}
	public Insurance getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(Insurance insuranceType) {
		this.insuranceType = insuranceType;
	}
	public LocalDate getPremiumdate() {
		return premiumdate;
	}
	public void setPremiumdate(LocalDate premiumdate) {
		this.premiumdate = premiumdate;
	}
	public LocalDate getPolicyEndDate() {
		return policyEndDate;
	}
	public void setPolicyEndDate(LocalDate policyEndDate) {
		this.policyEndDate = policyEndDate;
	}
	@Override
	public String toString() {
		return "Policy [insuranceType=" + insuranceType + ", premiumdate=" + premiumdate + ", policyEndDate="
				+ policyEndDate + "]";
	}
	
	
}
