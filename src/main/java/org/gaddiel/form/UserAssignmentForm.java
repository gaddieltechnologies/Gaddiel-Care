package org.gaddiel.form;

import java.util.Date;
import java.util.List;

public class UserAssignmentForm {

	private String userId;
	 private String userName;
	 private String startDate;
    private String endDate;
	 private String enabledFlag;
	 private String remarks;
	 private List<UserAssignmentSubForm>listofUser;
	 private List selectroles;
	 private String roleId;
	 private String roleName;
	 private String lastActivityDesc;
	 private String roles;
	 private String addrole;
	 private List newRoleList;
	 private String searchUser;
	 private String dispatch;
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
	private String sortValue;
	

	public String getSortValue() {
		return sortValue;
	}
	public void setSortValue(String sortValue) {
		this.sortValue = sortValue;
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
	public String getRecordList() {
		return recordList;
	}
	public void setRecordList(String recordList) {
		this.recordList = recordList;
	}
	public String getLastpage() {
		return lastpage;
	}
	public void setLastpage(String lastpage) {
		this.lastpage = lastpage;
	}
	public String getDispatch() {
		return dispatch;
	}
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	public String getSearchUser() {
		return searchUser;
	}
	public void setSearchUser(String searchUser) {
		this.searchUser = searchUser;
	}
	public String getAddrole() {
		return addrole;
	}
	public void setAddrole(String addrole) {
		this.addrole = addrole;
	}
	public List getNewRoleList() {
		return newRoleList;
	}
	public void setNewRoleList(List newRoleList) {
		this.newRoleList = newRoleList;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLastActivityDesc() {
		return lastActivityDesc;
	}
	public void setLastActivityDesc(String lastActivityDesc) {
		this.lastActivityDesc = lastActivityDesc;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getEnabledFlag() {
		return enabledFlag;
	}
	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<UserAssignmentSubForm> getListofUser() {
		return listofUser;
	}
	public void setListofUser(List<UserAssignmentSubForm> listofUser) {
		this.listofUser = listofUser;
	}
	public List getSelectroles() {
		return selectroles;
	}
	public void setSelectroles(List selectroles) {
		this.selectroles = selectroles;
	}

	 
	 
	 
	 
}
