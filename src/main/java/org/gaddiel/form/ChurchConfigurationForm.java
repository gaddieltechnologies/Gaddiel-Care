package org.gaddiel.form;




import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.validation.constraints.NotNull;
// TODO: Auto-generated Javadoc
//import org.hibernate.validator.constraints.NotEmpty;



/**
 * The Class ChurchConfigurationForm.
 */
public class ChurchConfigurationForm {
	 
	public List newlist;
	public List newnamelist;
	private String newcode;
	
	private String newname;
	
 	/** The user name. */
 	private String userName;
 	
 	/** The password. */
 	private String password;
	  
  	/** The church code. */
  	private String churchCode;
	 
 	/** The address mode. */
 	public List addressMode;
	  
  	/** The address. */
  	private String address;
	  
  	/** The address id. */
  	private int addressId;
	  
  	/** The preferences value. */
  	private String preferencesValue;

	/** The dispatch. */
	private String dispatch;
	  
  	/** The hiddenval. */
  	private String hiddenval;
	  
  	/** The church contacts sub form. */
  	private List<ChurchContactsSubForm> churchContactsSubForm;
	  
  	
  	private List<ChurchAddressSubForm> churchAddressSubForm;
  	
  	/** The churchpreferences sub form. */
  	private List<ChurchPreferencesForm> churchpreferencesSubForm;
  	
  	private List<ChurchPrefCustomForm> churchprefcustomSubForm;
	
	/** The address list. */
	public List addressList;
	     
     	/** The church name. */
     	private String churchName;
	     
     	/** The church type. */
     	private String churchType;
	     
     	/** The church patron. */
     	private String churchPatron;
	     
     	/** The system date format lu value id. */
     	private int systemDateFormatLuValueId;
	     
     	/** The contact list. */
     	public List contactList;
		
		/** The system currency lu value id. */
		private int systemCurrencyLuValueId;
	     
     	/** The church motto. */
     	private String churchMotto;
	     
     	/** The church theme. */
     	private String churchTheme;
	     
     	/** The description. */
     	private String description;
	     
     	/** The remarks. */
     	private String remarks;
	     
     	/** The created by. */
     	private String createdBy;
	     
     	/** The created date. */
     	private Date createdDate;
	     
     	/** The last updated by. */
     	private String lastUpdatedBy;
	     
     	/** The last updated date. */
     	private Date lastUpdatedDate;
	     
     	/** The church id. */
     	private Integer churchId;
	     
     	/** The church global id. */
     	private Integer churchGlobalId;
	     
     	/** The door no. */
     	private String doorNo;
	     
     	/** The floor no. */
     	private String floorNo;
	     
     	/** The building name. */
     	private String buildingName;
	     
     	/** The street name. */
     	private String streetName;
	     
     	/** The area. */
     	private String area;
	     
     	/** The date format. */
     	private String dateFormat;
	     
     	/** The currency format. */
     	private String currencyFormat;
	     
     	/** The district. */
     	private String district;
	     
     	/** The state. */
     	private String state;
	     
     	/** The post code. */
     	private String postCode;
	     
     	/** The country. */
     	private String country;
	     
     	/** The city. */
     	private String city;
	     
     	/** The postal zone. */
     	private String postalZone;
	     
		/** The contact no. */
		private String contactNo;
		 
 		/** The mobile no. */
 		private String mobileNo;
		 
 		/** The fax no. */
 		private String faxNo;
		 
 		/** The landline no. */
 		private String landlineNo;
		 
 		/** The mail id. */
 		private String mailId;
		 
 		/** The contact title. */
 		private String contactTitle;
		 
 		/** The contact value. */
 		private String contactValue;
		 
		 /** The total address. */
 		private String totalAddress;
		 
		/** The add address type. */
		private String addAddressType;
		
		/** The add door no. */
		private String addDoorNo;
		 
 		/** The add building name. */
 		private String addBuildingName;
		 
 		/** The add street name. */
 		private String addStreetName;
		 
 		/** The add postal zone. */
 		private String addPostalZone;
	     
     	/** The add area. */
     	private String addArea;
	     
     	/** The add district. */
     	private String addDistrict;
	     
     	/** The add state. */
     	private String addState;
	     
     	/** The add post code. */
     	private String addPostCode;
	     
     	/** The add country. */
     	private String addCountry;
	     
     	/** The add city. */
     	private String addCity;
	     
     	/** The currency list. */
     	public List currencyList;
     	private String id;
     	private String value;
     	private String customid;
     	private String customvalue;
    	public List churchList;
    	private int churchTypeId;
     	private String churchTypeValue;
     	private String churchTypeView;
     	
     	
	 	public String getCustomid() {
			return customid;
		}

		public void setCustomid(String customid) {
			this.customid = customid;
		}

		public String getCustomvalue() {
			return customvalue;
		}

		public void setCustomvalue(String customvalue) {
			this.customvalue = customvalue;
		}

		public String getChurchTypeView() {
			return churchTypeView;
		}

		public void setChurchTypeView(String churchTypeView) {
			this.churchTypeView = churchTypeView;
		}

		public int getChurchTypeId() {
			return churchTypeId;
		}

		public void setChurchTypeId(int churchTypeId) {
			this.churchTypeId = churchTypeId;
		}

		public String getChurchTypeValue() {
			return churchTypeValue;
		}

		public void setChurchTypeValue(String churchTypeValue) {
			this.churchTypeValue = churchTypeValue;
		}

		public List getChurchList() {
			return churchList;
		}

		public void setChurchList(List churchList) {
			this.churchList = churchList;
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
     	 * Gets the postal zone.
     	 *
     	 * @return the postal zone
     	 */
     	public String getPostalZone() {
				return postalZone;
			}
			
			/**
			 * Sets the postal zone.
			 *
			 * @param postalZone the new postal zone
			 */
			public void setPostalZone(String postalZone) {
				this.postalZone = postalZone;
			}
	     
     	public List getNewlist() {
				return newlist;
			}

			public String getNewname() {
			return newname;
		}

		public void setNewname(String newname) {
			this.newname = newname;
		}

			public void setNewlist(List newlist) {
				this.newlist = newlist;
			}

		public List getNewnamelist() {
				return newnamelist;
			}

			public void setNewnamelist(List newnamelist) {
				this.newnamelist = newnamelist;
			}

		public String getNewcode() {
				return newcode;
			}

			public void setNewcode(String newcode) {
				this.newcode = newcode;
			}

		/**
     	 * Gets the adds the postal zone.
     	 *
     	 * @return the adds the postal zone
     	 */
     	public String getAddPostalZone() {
			return addPostalZone;
		}
		
		/**
		 * Sets the adds the postal zone.
		 *
		 * @param addPostalZone the new adds the postal zone
		 */
		public void setAddPostalZone(String addPostalZone) {
			this.addPostalZone = addPostalZone;
		}
		
		/**
		 * Gets the adds the street name.
		 *
		 * @return the adds the street name
		 */
		public String getAddStreetName() {
			return addStreetName;
		}
		
		/**
		 * Sets the adds the street name.
		 *
		 * @param addStreetName the new adds the street name
		 */
		public void setAddStreetName(String addStreetName) {
			this.addStreetName = addStreetName;
		}
		
		/**
		 * Gets the churchpreferences sub form.
		 *
		 * @return the churchpreferences sub form
		 */
		public List<ChurchPreferencesForm> getChurchpreferencesSubForm() {
	 		return churchpreferencesSubForm;
	 	}
	 	
	 	/**
	 	 * Sets the churchpreferences sub form.
	 	 *
	 	 * @param churchpreferencesSubForm the new churchpreferences sub form
	 	 */
	 	public void setChurchpreferencesSubForm(List<ChurchPreferencesForm> churchpreferencesSubForm) {
	 		this.churchpreferencesSubForm = churchpreferencesSubForm;
	 	}
		
	     /**
     	 * Gets the currency list.
     	 *
     	 * @return the currency list
     	 */
     	public List getCurrencyList() {
			return currencyList;
		}
		
		/**
		 * Sets the currency list.
		 *
		 * @param currencyList the new currency list
		 */
		public void setCurrencyList(List currencyList) {
			this.currencyList = currencyList;
		}
		
		/**
		 * Gets the total address.
		 *
		 * @return the total address
		 */
		public String getTotalAddress() {
				return totalAddress;
			}
			
			/**
			 * Sets the total address.
			 *
			 * @param totalAddress the new total address
			 */
			public void setTotalAddress(String totalAddress) {
				this.totalAddress = totalAddress;
			}
	     
		/**
		 * Gets the adds the door no.
		 *
		 * @return the adds the door no
		 */
		public String getAddDoorNo() {
				return addDoorNo;
			}
			
			/**
			 * Sets the adds the door no.
			 *
			 * @param addDoorNo the new adds the door no
			 */
			public void setAddDoorNo(String addDoorNo) {
				this.addDoorNo = addDoorNo;
			}
	
		  /**
  		 * Gets the adds the address type.
  		 *
  		 * @return the adds the address type
  		 */
  		public String getAddAddressType() {
				return addAddressType;
			}
			
			/**
			 * Sets the adds the address type.
			 *
			 * @param addAddressType the new adds the address type
			 */
			public void setAddAddressType(String addAddressType) {
				this.addAddressType = addAddressType;
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
 		 * Gets the address id.
 		 *
 		 * @return the address id
 		 */
 		public int getAddressId() {
				return addressId;
			}
			
			/**
			 * Sets the address id.
			 *
			 * @param addressId the new address id
			 */
			public void setAddressId(int addressId) {
				this.addressId = addressId;
			}
		   
   		/**
   		 * Gets the contact title.
   		 *
   		 * @return the contact title
   		 */
   		public String getContactTitle() {
			return contactTitle;
		}
		
		/**
		 * Sets the contact title.
		 *
		 * @param contactTitle the new contact title
		 */
		public void setContactTitle(String contactTitle) {
			this.contactTitle = contactTitle;
		}
		
		/**
		 * Gets the contact value.
		 *
		 * @return the contact value
		 */
		public String getContactValue() {
			return contactValue;
		}
		
		/**
		 * Sets the contact value.
		 *
		 * @param contactValue the new contact value
		 */
		public void setContactValue(String contactValue) {
			this.contactValue = contactValue;
		}
		
		/**
		 * Gets the address list.
		 *
		 * @return the address list
		 */
		public List getAddressList() {
				return addressList;
			}
			
			/**
			 * Sets the address list.
			 *
			 * @param addressList the new address list
			 */
			public void setAddressList(List addressList) {
				this.addressList = addressList;
			}
			
			/**
			 * Gets the contact list.
			 *
			 * @return the contact list
			 */
			public List getContactList() {
				return contactList;
			}
			
			/**
			 * Sets the contact list.
			 *
			 * @param contactList the new contact list
			 */
			public void setContactList(List contactList) {
				this.contactList = contactList;
			}
			  
  			/**
  			 * Gets the address mode.
  			 *
  			 * @return the address mode
  			 */
  			public List getAddressMode() {
					return addressMode;
				}
				
				/**
				 * Sets the address mode.
				 *
				 * @param addressMode the new address mode
				 */
				public void setAddressMode(List addressMode) {
					this.addressMode = addressMode;
				}
		 
 		/**
 		 * Gets the user name.
 		 *
 		 * @return the user name
 		 */
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
		 * Gets the church code.
		 *
		 * @return the church code
		 */
		public String getChurchCode() {
			return churchCode;
		}
		
		/**
		 * Sets the church code.
		 *
		 * @param churchCode the new church code
		 */
		public void setChurchCode(String churchCode) {
			this.churchCode = churchCode;
		}
			
			/**
			 * Gets the church name.
			 *
			 * @return the church name
			 */
			public String getChurchName() {
			return churchName;
		}
		
		/**
		 * Sets the church name.
		 *
		 * @param churchName the new church name
		 */
		public void setChurchName(String churchName) {
			this.churchName = churchName;
		}
		
		/**
		 * Gets the church type.
		 *
		 * @return the church type
		 */
		public String getChurchType() {
			return churchType;
		}
		
		/**
		 * Sets the church type.
		 *
		 * @param churchType the new church type
		 */
		public void setChurchType(String churchType) {
			this.churchType = churchType;
		}
		
		/**
		 * Gets the church patron.
		 *
		 * @return the church patron
		 */
		public String getChurchPatron() {
			return churchPatron;
		}
		
		/**
		 * Sets the church patron.
		 *
		 * @param churchPatron the new church patron
		 */
		public void setChurchPatron(String churchPatron) {
			this.churchPatron = churchPatron;
		}
		
		/**
		 * Gets the system date format lu value id.
		 *
		 * @return the system date format lu value id
		 */
		public int getSystemDateFormatLuValueId() {
			return systemDateFormatLuValueId;
		}
		
		/**
		 * Sets the system date format lu value id.
		 *
		 * @param systemDateFormatLuValueId the new system date format lu value id
		 */
		public void setSystemDateFormatLuValueId(int systemDateFormatLuValueId) {
			this.systemDateFormatLuValueId = systemDateFormatLuValueId;
		}
		
		/**
		 * Gets the system currency lu value id.
		 *
		 * @return the system currency lu value id
		 */
		public int getSystemCurrencyLuValueId() {
			return systemCurrencyLuValueId;
		}
		
		/**
		 * Sets the system currency lu value id.
		 *
		 * @param systemCurrencyLuValueId the new system currency lu value id
		 */
		public void setSystemCurrencyLuValueId(int systemCurrencyLuValueId) {
			this.systemCurrencyLuValueId = systemCurrencyLuValueId;
		}
		
		/**
		 * Gets the church motto.
		 *
		 * @return the church motto
		 */
		public String getChurchMotto() {
			return churchMotto;
		}
		
		/**
		 * Sets the church motto.
		 *
		 * @param churchMotto the new church motto
		 */
		public void setChurchMotto(String churchMotto) {
			this.churchMotto = churchMotto;
		}
		
		/**
		 * Gets the church theme.
		 *
		 * @return the church theme
		 */
		public String getChurchTheme() {
			return churchTheme;
		}
		
		/**
		 * Sets the church theme.
		 *
		 * @param churchTheme the new church theme
		 */
		public void setChurchTheme(String churchTheme) {
			this.churchTheme = churchTheme;
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
		 * Gets the remarks.
		 *
		 * @return the remarks
		 */
		public String getRemarks() {
			return remarks;
		}
		
		/**
		 * Sets the remarks.
		 *
		 * @param remarks the new remarks
		 */
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		
		/**
		 * Gets the created by.
		 *
		 * @return the created by
		 */
		public String getCreatedBy() {
			return createdBy;
		}
		
		/**
		 * Sets the created by.
		 *
		 * @param createdBy the new created by
		 */
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		
		/**
		 * Gets the created date.
		 *
		 * @return the created date
		 */
		public Date getCreatedDate() {
			return createdDate;
		}
		
		/**
		 * Sets the created date.
		 *
		 * @param createdDate the new created date
		 */
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
		
		/**
		 * Gets the last updated by.
		 *
		 * @return the last updated by
		 */
		public String getLastUpdatedBy() {
			return lastUpdatedBy;
		}
		
		/**
		 * Sets the last updated by.
		 *
		 * @param lastUpdatedBy the new last updated by
		 */
		public void setLastUpdatedBy(String lastUpdatedBy) {
			this.lastUpdatedBy = lastUpdatedBy;
		}
		
		/**
		 * Gets the last updated date.
		 *
		 * @return the last updated date
		 */
		public Date getLastUpdatedDate() {
			return lastUpdatedDate;
		}
		
		/**
		 * Sets the last updated date.
		 *
		 * @param lastUpdatedDate the new last updated date
		 */
		public void setLastUpdatedDate(Date lastUpdatedDate) {
			this.lastUpdatedDate = lastUpdatedDate;
		}
		
		/**
		 * Gets the church id.
		 *
		 * @return the church id
		 */
		public Integer getChurchId() {
			return churchId;
		}
		
		/**
		 * Sets the church id.
		 *
		 * @param churchId the new church id
		 */
		public void setChurchId(Integer churchId) {
			this.churchId = churchId;
		}
		
		/**
		 * Gets the church global id.
		 *
		 * @return the church global id
		 */
		public Integer getChurchGlobalId() {
			return churchGlobalId;
		}
		
		/**
		 * Sets the church global id.
		 *
		 * @param churchGlobalId the new church global id
		 */
		public void setChurchGlobalId(Integer churchGlobalId) {
			this.churchGlobalId = churchGlobalId;
		}
		
		/**
		 * Gets the door no.
		 *
		 * @return the door no
		 */
		public String getDoorNo() {
			return doorNo;
		}
		
		/**
		 * Sets the door no.
		 *
		 * @param doorNo the new door no
		 */
		public void setDoorNo(String doorNo) {
			this.doorNo = doorNo;
		}
		
		/**
		 * Gets the floor no.
		 *
		 * @return the floor no
		 */
		public String getFloorNo() {
			return floorNo;
		}
		
		/**
		 * Sets the floor no.
		 *
		 * @param floorNo the new floor no
		 */
		public void setFloorNo(String floorNo) {
			this.floorNo = floorNo;
		}
		
		/**
		 * Gets the building name.
		 *
		 * @return the building name
		 */
		public String getBuildingName() {
			return buildingName;
		}
		
		/**
		 * Sets the building name.
		 *
		 * @param buildingName the new building name
		 */
		public void setBuildingName(String buildingName) {
			this.buildingName = buildingName;
		}
		
		/**
		 * Gets the street name.
		 *
		 * @return the street name
		 */
		public String getStreetName() {
			return streetName;
		}
		
		/**
		 * Sets the street name.
		 *
		 * @param streetName the new street name
		 */
		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}
		
		/**
		 * Gets the area.
		 *
		 * @return the area
		 */
		public String getArea() {
			return area;
		}
		
		/**
		 * Sets the area.
		 *
		 * @param area the new area
		 */
		public void setArea(String area) {
			this.area = area;
		}
		
		/**
		 * Gets the date format.
		 *
		 * @return the date format
		 */
		public String getDateFormat() {
			return dateFormat;
		}
		
		/**
		 * Sets the date format.
		 *
		 * @param dateFormat the new date format
		 */
		public void setDateFormat(String dateFormat) {
			this.dateFormat = dateFormat;
		}
		
		/**
		 * Gets the currency format.
		 *
		 * @return the currency format
		 */
		public String getCurrencyFormat() {
			return currencyFormat;
		}
		
		/**
		 * Sets the currency format.
		 *
		 * @param currencyFormat the new currency format
		 */
		public void setCurrencyFormat(String currencyFormat) {
			this.currencyFormat = currencyFormat;
		}
		
		/**
		 * Gets the district.
		 *
		 * @return the district
		 */
		public String getDistrict() {
			return district;
		}
		
		/**
		 * Sets the district.
		 *
		 * @param district the new district
		 */
		public void setDistrict(String district) {
			this.district = district;
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
		 * Gets the post code.
		 *
		 * @return the post code
		 */
		public String getPostCode() {
			return postCode;
		}
		
		/**
		 * Sets the post code.
		 *
		 * @param postCode the new post code
		 */
		public void setPostCode(String postCode) {
			this.postCode = postCode;
		}
		
		/**
		 * Gets the country.
		 *
		 * @return the country
		 */
		public String getCountry() {
			return country;
		}
		
		/**
		 * Sets the country.
		 *
		 * @param country the new country
		 */
		public void setCountry(String country) {
			this.country = country;
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
		 * Gets the contact no.
		 *
		 * @return the contact no
		 */
		public String getContactNo() {
			return contactNo;
		}
		
		/**
		 * Sets the contact no.
		 *
		 * @param contactNo the new contact no
		 */
		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
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
		 * Gets the mobile no.
		 *
		 * @return the mobile no
		 */
		public String getMobileNo() {
			return mobileNo;
		}
		
		/**
		 * Sets the mobile no.
		 *
		 * @param mobileNo the new mobile no
		 */
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		
		/**
		 * Gets the fax no.
		 *
		 * @return the fax no
		 */
		public String getFaxNo() {
			return faxNo;
		}
		
		/**
		 * Sets the fax no.
		 *
		 * @param faxNo the new fax no
		 */
		public void setFaxNo(String faxNo) {
			this.faxNo = faxNo;
		}
		
		/**
		 * Gets the landline no.
		 *
		 * @return the landline no
		 */
		public String getLandlineNo() {
			return landlineNo;
		}
		
		/**
		 * Sets the landline no.
		 *
		 * @param landlineNo the new landline no
		 */
		public void setLandlineNo(String landlineNo) {
			this.landlineNo = landlineNo;
		}
		
		/**
		 * Gets the mail id.
		 *
		 * @return the mail id
		 */
		public String getMailId() {
			return mailId;
		}
		
		/**
		 * Sets the mail id.
		 *
		 * @param mailId the new mail id
		 */
		public void setMailId(String mailId) {
			this.mailId = mailId;
		}
	     
		 /**
 		 * Gets the church contacts sub form.
 		 *
 		 * @return the church contacts sub form
 		 */
 		public List<ChurchContactsSubForm> getChurchContactsSubForm() {
				return churchContactsSubForm;
			}
			
			/**
			 * Sets the church contacts sub form.
			 *
			 * @param churchContactsSubForm the new church contacts sub form
			 */
			public void setChurchContactsSubForm(
					List<ChurchContactsSubForm> churchContactsSubForm) {
				this.churchContactsSubForm = churchContactsSubForm;
			}
	     
			 /**
 			 * Gets the adds the building name.
 			 *
 			 * @return the adds the building name
 			 */
 			public String getAddBuildingName() {
					return addBuildingName;
				}
				
				/**
				 * Sets the adds the building name.
				 *
				 * @param addBuildingName the new adds the building name
				 */
				public void setAddBuildingName(String addBuildingName) {
					this.addBuildingName = addBuildingName;
				}
				
				/**
				 * Gets the adds the area.
				 *
				 * @return the adds the area
				 */
				public String getAddArea() {
					return addArea;
				}
				
				/**
				 * Sets the adds the area.
				 *
				 * @param addArea the new adds the area
				 */
				public void setAddArea(String addArea) {
					this.addArea = addArea;
				}
				
				/**
				 * Gets the adds the district.
				 *
				 * @return the adds the district
				 */
				public String getAddDistrict() {
					return addDistrict;
				}
				
				/**
				 * Sets the adds the district.
				 *
				 * @param addDistrict the new adds the district
				 */
				public void setAddDistrict(String addDistrict) {
					this.addDistrict = addDistrict;
				}
				
				/**
				 * Gets the adds the state.
				 *
				 * @return the adds the state
				 */
				public String getAddState() {
					return addState;
				}
				
				/**
				 * Sets the adds the state.
				 *
				 * @param addState the new adds the state
				 */
				public void setAddState(String addState) {
					this.addState = addState;
				}
				
				/**
				 * Gets the adds the post code.
				 *
				 * @return the adds the post code
				 */
				public String getAddPostCode() {
					return addPostCode;
				}
				
				/**
				 * Sets the adds the post code.
				 *
				 * @param addPostCode the new adds the post code
				 */
				public void setAddPostCode(String addPostCode) {
					this.addPostCode = addPostCode;
				}
				
				/**
				 * Gets the adds the country.
				 *
				 * @return the adds the country
				 */
				public String getAddCountry() {
					return addCountry;
				}
				
				/**
				 * Sets the adds the country.
				 *
				 * @param addCountry the new adds the country
				 */
				public void setAddCountry(String addCountry) {
					this.addCountry = addCountry;
				}
				
				/**
				 * Gets the adds the city.
				 *
				 * @return the adds the city
				 */
				public String getAddCity() {
					return addCity;
				}
				
				/**
				 * Sets the adds the city.
				 *
				 * @param addCity the new adds the city
				 */
				public void setAddCity(String addCity) {
					this.addCity = addCity;
				}

				public List<ChurchAddressSubForm> getChurchAddressSubForm() {
					return churchAddressSubForm;
				}

				public void setChurchAddressSubForm(
						List<ChurchAddressSubForm> churchAddressSubForm) {
					this.churchAddressSubForm = churchAddressSubForm;
				}

				public List<ChurchPrefCustomForm> getChurchprefcustomSubForm() {
					return churchprefcustomSubForm;
				}

				public void setChurchprefcustomSubForm(
						List<ChurchPrefCustomForm> churchprefcustomSubForm) {
					this.churchprefcustomSubForm = churchprefcustomSubForm;
				}

}



 

