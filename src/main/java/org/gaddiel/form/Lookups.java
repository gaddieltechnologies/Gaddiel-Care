package org.gaddiel.form;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Lookups.
 */
public class Lookups implements java.io.Serializable {
	
	
	private String sessionId;
	
	private int pageNo;
	private int next;
	private int previous;
	private int total;
	private int start;
	private int end;
	private boolean firstPage;
	private boolean lastPage;
	private  String sNo;
	
	
	

	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	
	private String categoryType;
	
	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}


	/** The customcategory type. */
	private String customcategoryType;
	
	/** The category name. */
	private String categoryName;
	
	/** The category code. */
	private String categoryCode;
	
	/** The category value. */
	private String categoryValue;
	
	/** The new category type. */
	private String newCategoryType;
	
	/** The checkbox. */
	private String checkbox;
	
	/** The start date. */
	private String startDate;
	
	/** The end date. */
	private String endDate;
	
	/** The member list. */
	public List   memberList;
	
	/** The category type list. */
	private List categoryTypeList;
	
	/** The category name list. */
	private List categoryNameList;
	
	/** The enabled flag. */
	private String enabledFlag;
	
	/** The description. */
	private String description;
	
	/** The category type id. */
	private String categoryTypeId;
	
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the enabled flag.
	 *
	 * @return the enabled flag
	 */
	public String getEnabledFlag() {
		return enabledFlag;
	}
	
	/**
	 * Sets the enabled flag.
	 *
	 * @param enabledFlag the new enabled flag
	 */
	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}
	
	/**
	 * Gets the category name list.
	 *
	 * @return the category name list
	 */
	public List getCategoryNameList() {
		return categoryNameList;
	}
	
	/**
	 * Sets the category name list.
	 *
	 * @param categoryNameList the new category name list
	 */
	public void setCategoryNameList(List categoryNameList) {
		this.categoryNameList = categoryNameList;
	}

	/**
	 * Gets the category value.
	 *
	 * @return the category value
	 */
	public String getCategoryValue() {
		return categoryValue;
	}
	
	/**
	 * Sets the category value.
	 *
	 * @param categoryValue the new category value
	 */
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}
	
	/**
	 * Gets the new category type.
	 *
	 * @return the new category type
	 */
	public String getNewCategoryType() {
		return newCategoryType;
	}
	
	/**
	 * Sets the new category type.
	 *
	 * @param newCategoryType the new new category type
	 */
	public void setNewCategoryType(String newCategoryType) {
		this.newCategoryType = newCategoryType;
	}
	
	/**
	 * Gets the category type id.
	 *
	 * @return the category type id
	 */
	public String getCategoryTypeId() {
		return categoryTypeId;
	}
	
	/**
	 * Sets the category type id.
	 *
	 * @param categoryTypeId the new category type id
	 */
	public void setCategoryTypeId(String categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
}
	
	/**
	 * Gets the customcategory type.
	 *
	 * @return the customcategory type
	 */
	public String getCustomcategoryType() {
		return customcategoryType;
	}
	
	/**
	 * Sets the customcategory type.
	 *
	 * @param customcategoryType the new customcategory type
	 */
	public void setCustomcategoryType(String customcategoryType) {
		this.customcategoryType = customcategoryType;
	}
	
	/**
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}
	
	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	/**
	 * Gets the category code.
	 *
	 * @return the category code
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	
	/**
	 * Sets the category code.
	 *
	 * @param categoryCode the new category code
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	/**
	 * Gets the checkbox.
	 *
	 * @return the checkbox
	 */
	public String getCheckbox() {
		return checkbox;
	}
	
	/**
	 * Sets the checkbox.
	 *
	 * @param checkbox the new checkbox
	 */
	public void setCheckbox(String checkbox) {
		this.checkbox= checkbox;
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
	
	/**
	 * Gets the member list.
	 *
	 * @return the member list
	 */
	public List getMemberList() {
		return memberList;
	}
	
	/**
	 * Sets the member list.
	 *
	 * @param memberList the new member list
	 */
	public void setMemberList(List memberList) {
		this.memberList = memberList;
	}
	
	/**
	 * Gets the category type list.
	 *
	 * @return the category type list
	 */
	public List getCategoryTypeList() {
		return categoryTypeList;
	}
	
	/**
	 * Sets the category type list.
	 *
	 * @param categoryTypeList the new category type list
	 */
	public void setCategoryTypeList(List categoryTypeList) {
		this.categoryTypeList = categoryTypeList;
	}
	
}
