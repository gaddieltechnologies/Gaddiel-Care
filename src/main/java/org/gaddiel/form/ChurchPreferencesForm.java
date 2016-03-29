package org.gaddiel.form;

import java.util.List;

import org.apache.commons.collections.MultiHashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class ChurchPreferencesForm.
 */
public class ChurchPreferencesForm {
	
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
	
	

	public String getCategoryValue() {
		return categoryValue;
	}

	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the preferencesvalueid.
	 *
	 * @return the preferencesvalueid
	 */
	public MultiHashMap getPreferencesvalueid() {
		return preferencesvalueid;
	}
	
	/**
	 * Sets the preferencesvalueid.
	 *
	 * @param preferencesvalueid the new preferencesvalueid
	 */
	public void setPreferencesvalueid(MultiHashMap preferencesvalueid) {
		this.preferencesvalueid = preferencesvalueid;
	}
	
	/**
	 * Gets the prefer value.
	 *
	 * @return the prefer value
	 */
	public String getPreferValue() {
		return preferValue;
	}
	
	/**
	 * Sets the prefer value.
	 *
	 * @param preferValue the new prefer value
	 */
	public void setPreferValue(String preferValue) {
		this.preferValue = preferValue;
	}
	
	

	/**
	 * Gets the preferences value list.
	 *
	 * @return the preferences value list
	 */
	public List getPreferencesValueList() {
		return preferencesValueList;
	}
	
	/**
	 * Sets the preferences value list.
	 *
	 * @param preferencesValueList the new preferences value list
	 */
	public void setPreferencesValueList(List preferencesValueList) {
		this.preferencesValueList = preferencesValueList;
	}
	
	/**
	 * Gets the prefer id.
	 *
	 * @return the prefer id
	 */
	public int getPreferId() {
		return preferId;
	}
	
	/**
	 * Sets the prefer id.
	 *
	 * @param preferId the new prefer id
	 */
	public void setPreferId(int preferId) {
		this.preferId = preferId;
	}
	 
 	/**
 	 * Gets the preferences list.
 	 *
 	 * @return the preferences list
 	 */
 	public List getPreferencesList() {
		return preferencesList;
	}
	
	/**
	 * Sets the preferences list.
	 *
	 * @param preferencesList the new preferences list
	 */
	public void setPreferencesList(List preferencesList) {
		this.preferencesList = preferencesList;
	}
	
	/**
	 * Gets the preferences value.
	 *
	 * @return the preferences value
	 */
	public String getPreferencesValue() {
		return preferencesValue;
	}
	
	/**
	 * Sets the preferences value.
	 *
	 * @param preferencesValue the new preferences value
	 */
	public void setPreferencesValue(String preferencesValue) {
		this.preferencesValue = preferencesValue;
	}
	
	  /**
  	 * Gets the preferences name.
  	 *
  	 * @return the preferences name
  	 */
  	public String getPreferencesName() {
		return preferencesName;
	}
	
	/**
	 * Sets the preferences name.
	 *
	 * @param preferencesName the new preferences name
	 */
	public void setPreferencesName(String preferencesName) {
		this.preferencesName = preferencesName;
	}
	
	/**
	 * Gets the check box.
	 *
	 * @return the check box
	 */
	public String getCheckBox() {
		return checkBox;
	}
	
	/**
	 * Sets the check box.
	 *
	 * @param checkBox the new check box
	 */
	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
	}
	
	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public String getStartDate() {
		return startDate;
	}
	
	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public String getEndDate() {
		return endDate;
	}
	
	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	 
	
	 
}
