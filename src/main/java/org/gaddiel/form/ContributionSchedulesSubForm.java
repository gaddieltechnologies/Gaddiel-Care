package org.gaddiel.form;

public class ContributionSchedulesSubForm {
	
	private int contributionscheduleid;
	private int amount;
	private String collectionType;
	private String collectionFrequency;
	private String collectionDuedays;
	private String dueDate;
	private String startDate;
	private String endDate;
	private String enabledFlag;
	
	
	
	public int getContributionscheduleid() {
		return contributionscheduleid;
	}
	public void setContributionscheduleid(int contributionscheduleid) {
		this.contributionscheduleid = contributionscheduleid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCollectionType() {
		return collectionType;
	}
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}
	public String getCollectionFrequency() {
		return collectionFrequency;
	}
	public void setCollectionFrequency(String collectionFrequency) {
		this.collectionFrequency = collectionFrequency;
	}
	public String getEnabledFlag() {
		return enabledFlag;
	}
	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}
	public String getCollectionDuedays() {
		return collectionDuedays;
	}
	public void setCollectionDuedays(String collectionDuedays) {
		this.collectionDuedays = collectionDuedays;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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
	
	
}
