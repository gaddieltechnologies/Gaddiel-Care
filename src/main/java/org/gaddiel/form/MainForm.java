package org.gaddiel.form;
import java.util.HashMap;
import java.util.List;

import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotEmpty;

// TODO: Auto-generated Javadoc
/**
 * The Class MainForm.
 */
public class MainForm {
	
	private String recordList;
	
	private String newcode;
	private String newname;
	private String newdescription;
	private String newstartdate;
	private String newenddate;
	
	private String newcheckbox;
	
	
	

	

	/** The name. */
	private String name;
	
	/** The address. */
	private String address;
	
	/** The street. */
	private String street;
	
	/** The city. */
	private String city;
	
	/** The state. */
	private String state;
	
	/** The zip. */
	private String zip;
	
	/** The phone. */
	private Integer phone;
	
	/** The email. */
	private String email;
	
	/** The gender. */
	private char gender;
	
	/** The dob. */
	private String dob;
	
	/** The lookups. */
	private List<SystemLookupsForm> lookups;
	
	/** The dispatch. */
	private String dispatch;
	
	
	/** The user name. */
	private String userName;
	 
 	/** The password. */
 	private String password;
//------------------------------------------//	 
	 /** The firstname. */
private String firstname;
	 
 	/** The lastname. */
 	private String lastname;
	 
 	/** The phoneno. */
 	private String phoneno;
	 
 	/** The memberlist. */
 	private List   memberlist;
	 
 	/** The categoty type. */
 	private String categotyType;
	 
 	/** The categoty code. */
 	private String categotyCode;
	 
 	/** The category value. */
 	private String categoryValue;
	 
 	/** The newcategoty type. */
 	private String newcategotyType;
	 
 	/** The newcategory value. */
 	private String newcategoryValue;
	 
 	/** The categorylist. */
 	private List   categorylist;
		
		/** The systemlookssearch. */
		private String systemlookssearch; 
		
		
		/** The description. */
		private String description; 

		/** The addnewflag. */
		private String addnewflag;
		
		/** The clearsearch. */
		private String clearsearch;
		private HashMap userInfo;
		private boolean validate;
		private String lastlogin;
		private String sessionId;
		
		private int pageNo;
		private int next;
		private int previous;
		private int total;
		private int start;
		private int end;
		private boolean firstPage;
		private boolean lastPage;
		private String lastFailedLogin;
		private String searchCode;
		private String searchDescription;
		private String searchValue;
		private String hidesearch;
		private String advancedhidesearch;
		private String sortValue;

		
		
	public String getAdvancedhidesearch() {
			return advancedhidesearch;
		}

		public void setAdvancedhidesearch(String advancedhidesearch) {
			this.advancedhidesearch = advancedhidesearch;
		}

	public String getHidesearch() {
			return hidesearch;
		}

		public void setHidesearch(String hidesearch) {
			this.hidesearch = hidesearch;
		}

		
		public String getSortValue() {
			return sortValue;
		}

		public void setSortValue(String sortValue) {
			this.sortValue = sortValue;
		}

		public String getRecordList() {
			return recordList;
		}

		public void setRecordList(String recordList) {
			this.recordList = recordList;
		}

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

	public String getLastFailedLogin() {
			return lastFailedLogin;
		}

		public void setLastFailedLogin(String lastFailedLogin) {
			this.lastFailedLogin = lastFailedLogin;
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

	public String getSessionId() {
			return sessionId;
		}

		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}

	public String getLastlogin() {
			return lastlogin;
		}

		public void setLastlogin(String lastlogin) {
			this.lastlogin = lastlogin;
		}

	public boolean isValidate() {
			return validate;
		}

		public void setValidate(boolean validate) {
			this.validate = validate;
		}

	public HashMap getUserInfo() {
			return userInfo;
		}

		public void setUserInfo(HashMap userInfo) {
			this.userInfo = userInfo;
		}

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
	 * Gets the systemlookssearch.
	 *
	 * @return the systemlookssearch
	 */
	public String getSystemlookssearch() {
			return systemlookssearch;
		}
		
		/**
		 * Sets the systemlookssearch.
		 *
		 * @param systemlookssearch the new systemlookssearch
		 */
		public void setSystemlookssearch(String systemlookssearch) {
			this.systemlookssearch = systemlookssearch;
		}
	
	/**
	 * Gets the categorylist.
	 *
	 * @return the categorylist
	 */
	public List getCategorylist() {
		return categorylist;
	}
	
	/**
	 * Sets the categorylist.
	 *
	 * @param categorylist the new categorylist
	 */
	public void setCategorylist(List categorylist) {
		this.categorylist = categorylist;
	}
	
	/**
	 * Gets the newcategoty type.
	 *
	 * @return the newcategoty type
	 */
	public String getNewcategotyType() {
		return newcategotyType;
	}
	
	/**
	 * Sets the newcategoty type.
	 *
	 * @param newcategotyType the new newcategoty type
	 */
	public void setNewcategotyType(String newcategotyType) {
		this.newcategotyType = newcategotyType;
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
	 * Gets the categoty type.
	 *
	 * @return the categoty type
	 */
	public String getCategotyType() {
		return categotyType;
	}
	
	/**
	 * Sets the categoty type.
	 *
	 * @param categotyType the new categoty type
	 */
	public void setCategotyType(String categotyType) {
		this.categotyType = categotyType;
	}
	
	/**
	 * Gets the categoty code.
	 *
	 * @return the categoty code
	 */
	public String getCategotyCode() {
		return categotyCode;
	}
	
	/**
	 * Sets the categoty code.
	 *
	 * @param categotyCode the new categoty code
	 */
	public void setCategotyCode(String categotyCode) {
		this.categotyCode = categotyCode;
	}
	
	/**
	 * Gets the memberlist.
	 *
	 * @return the memberlist
	 */
	public List getMemberlist() {
		return memberlist;
	}
	
	/**
	 * Sets the memberlist.
	 *
	 * @param memberlist the new memberlist
	 */
	public void setMemberlist(List memberlist) {
		this.memberlist = memberlist;
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
	
	/**
	 * Gets the lookups.
	 *
	 * @return the lookups
	 */
	public List<SystemLookupsForm> getLookups() {
			return lookups;
		}
		
		/**
		 * Sets the lookups.
		 *
		 * @param lookups the new lookups
		 */
		public void setLookups(List<SystemLookupsForm> lookups) {
			this.lookups = lookups;
		}
	
	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * Gets the phoneno.
	 *
	 * @return the phoneno
	 */
	public String getPhoneno() {
		return phoneno;
	}
	
	/**
	 * Sets the phoneno.
	 *
	 * @param phoneno the new phoneno
	 */
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
//-------------------------------------------------//	
	/**
 * Gets the user name.
 *
 * @return the user name
 */
@NotEmpty
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Size(min=1, max=50)
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Gets the street.
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Sets the street.
	 *
	 * @param street the new street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public Integer getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Gets the zip.
	 *
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * Sets the zip.
	 *
	 * @param zip the new zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	
	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
}

