package org.gaddiel.form;

import java.awt.Checkbox;
import java.util.List;





// TODO: Auto-generated Javadoc
/**
 * The Class SystemLookupsForm.
 */
public class SystemLookupsForm implements java.io.Serializable {
	
	/** The category type. */
	private String categoryType;
	private  String sNo;
	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	/** The category name. */
	private String categoryName;
	
	/** The category code. */
	private String categoryCode;
	
	/** The new category type. */
	private String newCategoryType;
	
	/** The check box1. */
	private String checkBox1;
	
	/** The start date. */
	private String startDate;
	
	/** The member list. */
	public List   memberList;
	
	/** The end date. */
	private String endDate;
	
	/** The category type list. */
	private List categoryTypeList;
	
	/** The enabled flag. */
	private String enabledFlag;
	
	
	/** The description. */
	private String description;
	
	/** The category id. */
	private String categoryId; 
	
	private int pageNo;
	private int next;
	private int previous;
	private int total;
	private int start;
	private int end;
	private boolean firstPage;
	private boolean lastPage;

	

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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * Sets the category id.
	 *
	 * @param categoryId the new category id
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
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
	 * Gets the check box1.
	 *
	 * @return the check box1
	 */
	public String getCheckBox1()
	{
		return checkBox1;
	}
	
	/**
	 * Sets the check box1.
	 *
	 * @param checkBox1 the new check box1
	 */
	public void setCheckBox1(String checkBox1)
	{
		this.checkBox1=checkBox1;
	}
	
	/**
	 * Gets the category type.
	 *
	 * @return the category type
	 */
	public String getCategoryType() {
		return categoryType;
	}
	
	/**
	 * Sets the category type.
	 *
	 * @param categoryType the new category type
	 */
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
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
