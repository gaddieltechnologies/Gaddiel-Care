package org.gaddiel.form;

import java.util.List;

public class ContributionSchedulesForm {
	
	private String newType;
	private String newFreq;
	private String newDue;
	private List collectionTypeList;
	private List collectionFrequencyList;
	private List collectionDueList;
	private String id;
	private String value;
private List duelist;	
	
  
	public List getDuelist() {
	return duelist;
}

public void setDuelist(List duelist) {
	this.duelist = duelist;
}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNewType() {
		return newType;
	}

	public void setNewType(String newType) {
		this.newType = newType;
	}

	public String getNewFreq() {
		return newFreq;
	}

	public void setNewFreq(String newFreq) {
		this.newFreq = newFreq;
	}

	public String getNewDue() {
		return newDue;
	}

	public void setNewDue(String newDue) {
		this.newDue = newDue;
	}

	public List getCollectionTypeList() {
		return collectionTypeList;
	}

	public void setCollectionTypeList(List collectionTypeList) {
		this.collectionTypeList = collectionTypeList;
	}

	public List getCollectionFrequencyList() {
		return collectionFrequencyList;
	}

	public void setCollectionFrequencyList(List collectionFrequencyList) {
		this.collectionFrequencyList = collectionFrequencyList;
	}

	public List getCollectionDueList() {
		return collectionDueList;
	}

	public void setCollectionDueList(List collectionDueList) {
		this.collectionDueList = collectionDueList;
	}

	private List<ContributionSchedulesSubForm> contributionSchedulesSubForm;

	public List<ContributionSchedulesSubForm> getContributionSchedulesSubForm() {
		return contributionSchedulesSubForm;
	}

	public void setContributionSchedulesSubForm(
			List<ContributionSchedulesSubForm> contributionSchedulesSubForm) {
		this.contributionSchedulesSubForm = contributionSchedulesSubForm;
	}
  	
  	
  	
  	
}
