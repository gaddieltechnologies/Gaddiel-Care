package org.gaddiel.form;

public class SubscriptionPlanForm {

	private int planId;
	private int familyId;
	private int subscriptionAmount;
	private String startDate;
	private String endDate;
	private String paidUpto;
	private String enabledFlag;
	
	
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}
	public int getSubscriptionAmount() {
		return subscriptionAmount;
	}
	public void setSubscriptionAmount(int subscriptionAmount) {
		this.subscriptionAmount = subscriptionAmount;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPaidUpto() {
		return paidUpto;
	}
	public void setPaidUpto(String paidUpto) {
		this.paidUpto = paidUpto;
	}
	public String getEnabledFlag() {
		return enabledFlag;
	}
	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}
	
	
}
