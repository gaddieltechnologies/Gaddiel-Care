package org.gaddiel.model;

// default package
// Generated Mar 12, 2012 10:32:31 AM by Hibernate Tools 3.4.0.CR1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * ChurchActivityAddresses generated by hbm2java.
 */
@Entity
@Table(name="church_activity_addresses"

)
public class ChurchActivityAddresses  implements java.io.Serializable {


     /** The address id. */
     private Integer addressId;
     
     /** The church id. */
     private Integer churchId;
     
     /** The custom address type lv id. */
     private Integer customAddressTypeLvId;
     
     /** The address title. */
     private String addressTitle;
     
     /** The door number. */
     private String doorNumber;
     
     /** The suite number. */
     private String suiteNumber;
     
     /** The floor number. */
     private String floorNumber;
     
     /** The builiding name. */
     private String builidingName;
     
     /** The street name. */
     private String streetName;
     
     /** The area. */
     private String area;
     
     /** The address zone. */
     private String addressZone;
     
     /** The postal zone. */
     private String postalZone;
     
     /** The city. */
     private String city;
     
     /** The district. */
     private String district;
     
     /** The state location. */
     private String stateLocation;
     
     /** The province. */
     private String province;
     
     /** The country. */
     private String country;
     
     /** The postal code. */
     private String postalCode;
     
     /** The enabled flag. */
     private String enabledFlag;
     
     /** The start date. */
     private Date startDate;
     
     /** The end date. */
     private Date endDate;
     
     /** The created by. */
     private String createdBy;
     
     /** The created date. */
     private Date createdDate;
     
     /** The last updated by. */
     private String lastUpdatedBy;
     
     /** The last updated date. */
     private Date lastUpdatedDate;
     
     /** The land mark1. */
     private String landMark1;
     
     /** The land mark2. */
     private String landMark2;

    /**
     * Instantiates a new church activity addresses.
     */
    public ChurchActivityAddresses() {
    }

	
    /**
     * Instantiates a new church activity addresses.
     *
     * @param createdDate the created date
     * @param lastUpdatedDate the last updated date
     */
    public ChurchActivityAddresses(Date createdDate, Date lastUpdatedDate) {
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }
    
    /**
     * Instantiates a new church activity addresses.
     *
     * @param churchId the church id
     * @param customAddressTypeLvId the custom address type lv id
     * @param addressTitle the address title
     * @param doorNumber the door number
     * @param suiteNumber the suite number
     * @param floorNumber the floor number
     * @param builidingName the builiding name
     * @param streetName the street name
     * @param area the area
     * @param addressZone the address zone
     * @param postalZone the postal zone
     * @param city the city
     * @param district the district
     * @param stateLocation the state location
     * @param province the province
     * @param country the country
     * @param postalCode the postal code
     * @param enabledFlag the enabled flag
     * @param startDate the start date
     * @param endDate the end date
     * @param createdBy the created by
     * @param createdDate the created date
     * @param lastUpdatedBy the last updated by
     * @param lastUpdatedDate the last updated date
     * @param landMark1 the land mark1
     * @param landMark2 the land mark2
     */
    public ChurchActivityAddresses(Integer churchId, Integer customAddressTypeLvId, String addressTitle, String doorNumber, String suiteNumber, String floorNumber, String builidingName, String streetName, String area, String addressZone, String postalZone, String city, String district, String stateLocation, String province, String country, String postalCode, String enabledFlag, Date startDate, Date endDate, String createdBy, Date createdDate, String lastUpdatedBy, Date lastUpdatedDate, String landMark1, String landMark2) {
       this.churchId = churchId;
       this.customAddressTypeLvId = customAddressTypeLvId;
       this.addressTitle = addressTitle;
       this.doorNumber = doorNumber;
       this.suiteNumber = suiteNumber;
       this.floorNumber = floorNumber;
       this.builidingName = builidingName;
       this.streetName = streetName;
       this.area = area;
       this.addressZone = addressZone;
       this.postalZone = postalZone;
       this.city = city;
       this.district = district;
       this.stateLocation = stateLocation;
       this.province = province;
       this.country = country;
       this.postalCode = postalCode;
       this.enabledFlag = enabledFlag;
       this.startDate = startDate;
       this.endDate = endDate;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.lastUpdatedBy = lastUpdatedBy;
       this.lastUpdatedDate = lastUpdatedDate;
       this.landMark1 = landMark1;
       this.landMark2 = landMark2;
    }
   
     /**
      * Gets the address id.
      *
      * @return the address id
      */
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ADDRESS_ID", unique=true, nullable=false)
    public Integer getAddressId() {
        return this.addressId;
    }
    
    /**
     * Sets the address id.
     *
     * @param addressId the new address id
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    
    /**
     * Gets the church id.
     *
     * @return the church id
     */
    @Column(name="CHURCH_ID")
    public Integer getChurchId() {
        return this.churchId;
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
     * Gets the custom address type lv id.
     *
     * @return the custom address type lv id
     */
    @Column(name="CUSTOM_ADDRESS_TYPE_LV_ID")
    public Integer getCustomAddressTypeLvId() {
        return this.customAddressTypeLvId;
    }
    
    /**
     * Sets the custom address type lv id.
     *
     * @param customAddressTypeLvId the new custom address type lv id
     */
    public void setCustomAddressTypeLvId(Integer customAddressTypeLvId) {
        this.customAddressTypeLvId = customAddressTypeLvId;
    }

    
    /**
     * Gets the address title.
     *
     * @return the address title
     */
    @Column(name="ADDRESS_TITLE", length=120)
    public String getAddressTitle() {
        return this.addressTitle;
    }
    
    /**
     * Sets the address title.
     *
     * @param addressTitle the new address title
     */
    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }

    
    /**
     * Gets the door number.
     *
     * @return the door number
     */
    @Column(name="DOOR_NUMBER", length=10)
    public String getDoorNumber() {
        return this.doorNumber;
    }
    
    /**
     * Sets the door number.
     *
     * @param doorNumber the new door number
     */
    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    
    /**
     * Gets the suite number.
     *
     * @return the suite number
     */
    @Column(name="SUITE_NUMBER", length=10)
    public String getSuiteNumber() {
        return this.suiteNumber;
    }
    
    /**
     * Sets the suite number.
     *
     * @param suiteNumber the new suite number
     */
    public void setSuiteNumber(String suiteNumber) {
        this.suiteNumber = suiteNumber;
    }

    
    /**
     * Gets the floor number.
     *
     * @return the floor number
     */
    @Column(name="FLOOR_NUMBER", length=10)
    public String getFloorNumber() {
        return this.floorNumber;
    }
    
    /**
     * Sets the floor number.
     *
     * @param floorNumber the new floor number
     */
    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    
    /**
     * Gets the builiding name.
     *
     * @return the builiding name
     */
    @Column(name="BUILIDING_NAME", length=60)
    public String getBuilidingName() {
        return this.builidingName;
    }
    
    /**
     * Sets the builiding name.
     *
     * @param builidingName the new builiding name
     */
    public void setBuilidingName(String builidingName) {
        this.builidingName = builidingName;
    }

    
    /**
     * Gets the street name.
     *
     * @return the street name
     */
    @Column(name="STREET_NAME", length=100)
    public String getStreetName() {
        return this.streetName;
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
    @Column(name="AREA", length=60)
    public String getArea() {
        return this.area;
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
     * Gets the address zone.
     *
     * @return the address zone
     */
    @Column(name="ADDRESS_ZONE", length=60)
    public String getAddressZone() {
        return this.addressZone;
    }
    
    /**
     * Sets the address zone.
     *
     * @param addressZone the new address zone
     */
    public void setAddressZone(String addressZone) {
        this.addressZone = addressZone;
    }

    
    /**
     * Gets the postal zone.
     *
     * @return the postal zone
     */
    @Column(name="POSTAL_ZONE", length=60)
    public String getPostalZone() {
        return this.postalZone;
    }
    
    /**
     * Sets the postal zone.
     *
     * @param postalZone the new postal zone
     */
    public void setPostalZone(String postalZone) {
        this.postalZone = postalZone;
    }

    
    /**
     * Gets the city.
     *
     * @return the city
     */
    @Column(name="CITY", length=60)
    public String getCity() {
        return this.city;
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
     * Gets the district.
     *
     * @return the district
     */
    @Column(name="DISTRICT", length=60)
    public String getDistrict() {
        return this.district;
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
     * Gets the state location.
     *
     * @return the state location
     */
    @Column(name="STATE_LOCATION", length=60)
    public String getStateLocation() {
        return this.stateLocation;
    }
    
    /**
     * Sets the state location.
     *
     * @param stateLocation the new state location
     */
    public void setStateLocation(String stateLocation) {
        this.stateLocation = stateLocation;
    }

    
    /**
     * Gets the province.
     *
     * @return the province
     */
    @Column(name="PROVINCE", length=30)
    public String getProvince() {
        return this.province;
    }
    
    /**
     * Sets the province.
     *
     * @param province the new province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    
    /**
     * Gets the country.
     *
     * @return the country
     */
    @Column(name="COUNTRY", length=60)
    public String getCountry() {
        return this.country;
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
     * Gets the postal code.
     *
     * @return the postal code
     */
    @Column(name="POSTAL_CODE", length=60)
    public String getPostalCode() {
        return this.postalCode;
    }
    
    /**
     * Sets the postal code.
     *
     * @param postalCode the new postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    
    /**
     * Gets the enabled flag.
     *
     * @return the enabled flag
     */
    @Column(name="ENABLED_FLAG", length=1)
    public String getEnabledFlag() {
        return this.enabledFlag;
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
     * Gets the start date.
     *
     * @return the start date
     */
    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE", length=10)
    public Date getStartDate() {
        return this.startDate;
    }
    
    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE", length=10)
    public Date getEndDate() {
        return this.endDate;
    }
    
    /**
     * Sets the end date.
     *
     * @param endDate the new end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    /**
     * Gets the created by.
     *
     * @return the created by
     */
    @Column(name="CREATED_BY", length=60)
    public String getCreatedBy() {
        return this.createdBy;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_DATE", nullable=false, length=19)
    public Date getCreatedDate() {
        return this.createdDate;
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
    @Column(name="LAST_UPDATED_BY", length=60)
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_UPDATED_DATE", nullable=false, length=19)
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
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
     * Gets the land mark1.
     *
     * @return the land mark1
     */
    @Column(name="LAND_MARK1", length=200)
    public String getLandMark1() {
        return this.landMark1;
    }
    
    /**
     * Sets the land mark1.
     *
     * @param landMark1 the new land mark1
     */
    public void setLandMark1(String landMark1) {
        this.landMark1 = landMark1;
    }

    
    /**
     * Gets the land mark2.
     *
     * @return the land mark2
     */
    @Column(name="LAND_MARK2", length=200)
    public String getLandMark2() {
        return this.landMark2;
    }
    
    /**
     * Sets the land mark2.
     *
     * @param landMark2 the new land mark2
     */
    public void setLandMark2(String landMark2) {
        this.landMark2 = landMark2;
    }




}



