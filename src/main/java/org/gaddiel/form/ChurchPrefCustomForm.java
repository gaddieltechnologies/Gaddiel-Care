package org.gaddiel.form;

import java.util.List;

import org.apache.commons.collections.MultiHashMap;

public class ChurchPrefCustomForm {
	/** The prefer id. */
	private int preferId;

	/** The preferences name. */
	private String preferencesName;
	
	/** The preferences value. */
	private String preferencesValue;
	
	/** The check box. */
	private String checkBox;
	  
  	/** The start date. */
  	private String startDate;
	  
  	/** The end date. */
  	private String endDate;
	
	/** The preferences list. */
	public List preferencesList;
	
	/** The prefer value. */
	private String preferValue;
	
	/** The preferences value list. */
	public List preferencesValueList;
	
	/** The preferencesvalueid. */
	private MultiHashMap preferencesvalueid;
	
	private String description;
	private String categoryValue;
	
	
	
	public int getPreferId() {
		return preferId;
	}
	public void setPreferId(int preferId) {
		this.preferId = preferId;
	}
	public String getPreferencesName() {
		return preferencesName;
	}
	public void setPreferencesName(String preferencesName) {
		this.preferencesName = preferencesName;
	}
	public String getPreferencesValue() {
		return preferencesValue;
	}
	public void setPreferencesValue(String preferencesValue) {
		this.preferencesValue = preferencesValue;
	}
	public String getCheckBox() {
		return checkBox;
	}
	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
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
	public List getPreferencesList() {
		return preferencesList;
	}
	public void setPreferencesList(List preferencesList) {
		this.preferencesList = preferencesList;
	}
	public String getPreferValue() {
		return preferValue;
	}
	public void setPreferValue(String preferValue) {
		this.preferValue = preferValue;
	}
	public List getPreferencesValueList() {
		return preferencesValueList;
	}
	public void setPreferencesValueList(List preferencesValueList) {
		this.preferencesValueList = preferencesValueList;
	}
	public MultiHashMap getPreferencesvalueid() {
		return preferencesvalueid;
	}
	public void setPreferencesvalueid(MultiHashMap preferencesvalueid) {
		this.preferencesvalueid = preferencesvalueid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryValue() {
		return categoryValue;
	}
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}
	
	
	
	
}
