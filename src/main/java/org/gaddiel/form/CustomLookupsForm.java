package org.gaddiel.form;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomLookupsForm.
 */
public class CustomLookupsForm {
	
	private String sessionId;
	private int pageNo;
	private int next;
	private int previous;
	private int total;
	private int start;
	private int end;
	private boolean firstPage;
	private boolean lastPage;
	private String recordList;
	private String lastpage;
	private String hidesearch;
	private String advancedhidesearch;
	private String sortValue;



	public String getSortValue() {
		return sortValue;
	}

	public void setSortValue(String sortValue) {
		this.sortValue = sortValue;
	}

	public String getAdvancedhidesearch() {
		return advancedhidesearch;
	}

	public void setAdvancedhidesearch(String advancedhidesearch) {
		this.advancedhidesearch = advancedhidesearch;
	}

	public String getLastpage() {
		return lastpage;
	}

	public void setLastpage(String lastpage) {
		this.lastpage = lastpage;
	}

	public String getHidesearch() {
		return hidesearch;
	}

	public void setHidesearch(String hidesearch) {
		this.hidesearch = hidesearch;
	}

	public String getRecordList() {
		return recordList;
	}

	public void setRecordList(String recordList) {
		this.recordList = recordList;
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



	private String searchCode;
	private String searchDescription;
	private String searchValue;
	
	
	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSearchCode() {
		return searchCode;
	}

	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}

	public String getSearchDescription() {
		return searchDescription;
	}

	public void setSearchDescription(String searchDescription) {
		this.searchDescription = searchDescription;
	}



	private String newcode;
	private String newname;
	private String newdescription;
	private String newstartdate;
	private String newenddate;
	
	private String newcheckbox;
	
	public String getNewcheckbox() {
		return newcheckbox;
	}

	public void setNewcheckbox(String newcheckbox) {
		this.newcheckbox = newcheckbox;
	}

	public String getNewcode() {
		return newcode;
	}

	public void setNewcode(String newcode) {
		this.newcode = newcode;
	}

	public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public String getNewdescription() {
		return newdescription;
	}

	public void setNewdescription(String newdescription) {
		this.newdescription = newdescription;
	}

	public String getNewstartdate() {
		return newstartdate;
	}

	public void setNewstartdate(String newstartdate) {
		this.newstartdate = newstartdate;
	}

	public String getNewenddate() {
		return newenddate;
	}

	public void setNewenddate(String newenddate) {
		this.newenddate = newenddate;
	}

	
	
	/** The customcategory type. */
	private String customcategoryType;
	
	/** The category name. */
	private String categoryName;
	
	/** The category code. */
	private String categoryCode;
	 
 	/** The category value. */
 	private String categoryValue;
	 
 	/** The newcategory type. */
 	private String newcategoryType;
	 
 	/** The newcategory value. */
 	private String newcategoryValue;
	 
 	/** The newcategory code. */
 	private String newcategoryCode;
	 
 	/** The hiddenval. */
 	private String hiddenval;
	
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
	
	/** The flag. */
	public int flag;
	
	/** The lookups. */
	private List<Lookups> lookups;
	
	/** The dispatch. */
	private String dispatch;
	
	/** The customlookssearch. */
	private String customlookssearch;
	
	/** The category id. */
	private String categoryId;
	
	/** The label. */
	private String label;
	
	/** The value. */
	private String value;
	
	/** The msg. */
	private String msg;
	
	/** The addnewflag. */
	private String addnewflag;
	
	/** The clearsearch. */
	private String clearsearch;
	
	/**
	 * Gets the clearsearch.
	 *
	 * @return the clearsearch
	 */
	public String getClearsearch() {
		return clearsearch;
	}
	
	/**
	 * Sets the clearsearch.
	 *
	 * @param clearsearch the new clearsearch
	 */
	public void setClearsearch(String clearsearch) {
		this.clearsearch = clearsearch;
	}
	
	/**
	 * Gets the addnewflag.
	 *
	 * @return the addnewflag
	 */
	public String getAddnewflag() {
		return addnewflag;
	}
	
	/**
	 * Sets the addnewflag.
	 *
	 * @param addnewflag the new addnewflag
	 */
	public void setAddnewflag(String addnewflag) {
		this.addnewflag = addnewflag;
	}
	
	/**
	 * Gets the msg.
	 *
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	
	/**
	 * Sets the msg.
	 *
	 * @param msg the new msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
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
	 * Gets the customlookssearch.
	 *
	 * @return the customlookssearch
	 */
	public String getCustomlookssearch() {
		return customlookssearch;
	}
	
	/**
	 * Sets the customlookssearch.
	 *
	 * @param customlookssearch the new customlookssearch
	 */
	public void setCustomlookssearch(String customlookssearch) {
		this.customlookssearch = customlookssearch;
	}
	
	/**
	 * Gets the flag.
	 *
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}
	
	/**
	 * Sets the flag.
	 *
	 * @param flag the new flag
	 */
	public void setFlag(int flag) {
		this.flag = flag;
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
	 * Gets the newcategory type.
	 *
	 * @return the newcategory type
	 */
	public String getNewcategoryType() {
		return newcategoryType;
	}
	
	/**
	 * Sets the newcategory type.
	 *
	 * @param newcategoryType the new newcategory type
	 */
	public void setNewcategoryType(String newcategoryType) {
		this.newcategoryType = newcategoryType;
	}
	
	/**
	 * Gets the newcategory value.
	 *
	 * @return the newcategory value
	 */
	public String getNewcategoryValue() {
		return newcategoryValue;
	}
	
	/**
	 * Sets the newcategory value.
	 *
	 * @param newcategoryValue the new newcategory value
	 */
	public void setNewcategoryValue(String newcategoryValue) {
		this.newcategoryValue = newcategoryValue;
	}
	
	/**
	 * Gets the newcategory code.
	 *
	 * @return the newcategory code
	 */
	public String getNewcategoryCode() {
		return newcategoryCode;
	}
	
	/**
	 * Sets the newcategory code.
	 *
	 * @param newcategoryCode the new newcategory code
	 */
	public void setNewcategoryCode(String newcategoryCode) {
		this.newcategoryCode = newcategoryCode;
	}
	
	/**
	 * Gets the hiddenval.
	 *
	 * @return the hiddenval
	 */
	public String getHiddenval() {
		return hiddenval;
	}
	
	/**
	 * Sets the hiddenval.
	 *
	 * @param hiddenval the new hiddenval
	 */
	public void setHiddenval(String hiddenval) {
		this.hiddenval = hiddenval;
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
	
	
/**
 * Gets the lookups.
 *
 * @return the lookups
 */
public List<Lookups> getLookups() {
		return lookups;
	}
	
	/**
	 * Sets the lookups.
	 *
	 * @param lookups the new lookups
	 */
	public void setLookups(List<Lookups> lookups) {
		this.lookups = lookups;
	}
	
	/**
	 * Gets the dispatch.
	 *
	 * @return the dispatch
	 */
	public String getDispatch() {
		return dispatch;
	}
	
	/**
	 * Sets the dispatch.
	 *
	 * @param dispatch the new dispatch
	 */
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}

	
	
}
