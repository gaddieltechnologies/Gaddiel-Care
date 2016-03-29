package org.gaddiel.form;

import java.util.Date;
import java.util.List;

public class UserAssignmentSubForm implements java.io.Serializable {

	
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
	 private String userId;
     private String userName;
	 private String startDate;
     private String endDate;
	 private String enabledFlag;
	 private String remarks;
	 private List selectroles;
	 private String roleId;
	 private String roleName;
	 private String lastActivityDesc;
	 private String roles; 
	 private String roleAssignMents; 
	 private List memberList;
	 
	 
	public List getMemberList() {
		return memberList;
	}
	public void setMemberList(List memberList) {
		this.memberList = memberList;
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
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getRoleAssignMents() {
		return roleAssignMents;
	}
	public void setRoleAssignMents(String roleAssignMents) {
		this.roleAssignMents = roleAssignMents;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getLastActivityDesc() {
		return lastActivityDesc;
	}
	public void setLastActivityDesc(String lastActivityDesc) {
		this.lastActivityDesc = lastActivityDesc;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public List getSelectroles() {
		return selectroles;
	}
	public void setSelectroles(List selectroles) {
		this.selectroles = selectroles;
	}
}
