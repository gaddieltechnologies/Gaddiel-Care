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
 * SystemLookupValues generated by hbm2java.
 */
@Entity
@Table(name="system_lookup_values")

public class SystemLookupValues  implements java.io.Serializable {


     /** The system lookup value id. */
     private Integer systemLookupValueId;
     
     /** The system lookup category. */
     private String systemLookupCategory;
     
     /** The system lookup code. */
     private String systemLookupCode;
     
     /** The system lookup value. */
     private String systemLookupValue;
     
     /** The system lookup precedence. */
     private int systemLookupPrecedence;
     
     /** The description. */
     private String description;
     
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
     
     /** The remarks. */
     private String remarks;

    /**
     * Instantiates a new system lookup values.
     */
    public SystemLookupValues() {
    }

	
    /**
     * Instantiates a new system lookup values.
     *
     * @param systemLookupCategory the system lookup category
     * @param systemLookupValue the system lookup value
     * @param systemLookupPrecedence the system lookup precedence
     * @param createdDate the created date
     * @param lastUpdatedDate the last updated date
     */
    public SystemLookupValues(String systemLookupCategory, String systemLookupValue, int systemLookupPrecedence, Date createdDate, Date lastUpdatedDate) {
        this.systemLookupCategory = systemLookupCategory;
        this.systemLookupValue = systemLookupValue;
        this.systemLookupPrecedence = systemLookupPrecedence;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }
    
    /**
     * Instantiates a new system lookup values.
     *
     * @param systemLookupCategory the system lookup category
     * @param systemLookupCode the system lookup code
     * @param systemLookupValue the system lookup value
     * @param systemLookupPrecedence the system lookup precedence
     * @param description the description
     * @param enabledFlag the enabled flag
     * @param startDate the start date
     * @param endDate the end date
     * @param createdBy the created by
     * @param createdDate the created date
     * @param lastUpdatedBy the last updated by
     * @param lastUpdatedDate the last updated date
     * @param remarks the remarks
     */
    public SystemLookupValues(String systemLookupCategory, String systemLookupCode, String systemLookupValue, int systemLookupPrecedence, String description, String enabledFlag, Date startDate, Date endDate, String createdBy, Date createdDate, String lastUpdatedBy, Date lastUpdatedDate, String remarks) {
       this.systemLookupCategory = systemLookupCategory;
       this.systemLookupCode = systemLookupCode;
       this.systemLookupValue = systemLookupValue;
       this.systemLookupPrecedence = systemLookupPrecedence;
       this.description = description;
       this.enabledFlag = enabledFlag;
       this.startDate = startDate;
       this.endDate = endDate;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.lastUpdatedBy = lastUpdatedBy;
       this.lastUpdatedDate = lastUpdatedDate;
       this.remarks = remarks;
    }
   
     /**
      * Gets the system lookup value id.
      *
      * @return the system lookup value id
      */
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="SYSTEM_LOOKUP_VALUE_ID", unique=true, nullable=false)
    public Integer getSystemLookupValueId() {
        return this.systemLookupValueId;
    }
    
    /**
     * Sets the system lookup value id.
     *
     * @param systemLookupValueId the new system lookup value id
     */
    public void setSystemLookupValueId(Integer systemLookupValueId) {
        this.systemLookupValueId = systemLookupValueId;
    }

    
    /**
     * Gets the system lookup category.
     *
     * @return the system lookup category
     */
    @Column(name="SYSTEM_LOOKUP_CATEGORY", nullable=false, length=60)
    public String getSystemLookupCategory() {
        return this.systemLookupCategory;
    }
    
    /**
     * Sets the system lookup category.
     *
     * @param systemLookupCategory the new system lookup category
     */
    public void setSystemLookupCategory(String systemLookupCategory) {
        this.systemLookupCategory = systemLookupCategory;
    }

    
    /**
     * Gets the system lookup code.
     *
     * @return the system lookup code
     */
    @Column(name="SYSTEM_LOOKUP_CODE", length=100)
    public String getSystemLookupCode() {
        return this.systemLookupCode;
    }
    
    /**
     * Sets the system lookup code.
     *
     * @param systemLookupCode the new system lookup code
     */
    public void setSystemLookupCode(String systemLookupCode) {
        this.systemLookupCode = systemLookupCode;
    }

    
    /**
     * Gets the system lookup value.
     *
     * @return the system lookup value
     */
    @Column(name="SYSTEM_LOOKUP_VALUE", nullable=false, length=100)
    public String getSystemLookupValue() {
        return this.systemLookupValue;
    }
    
    /**
     * Sets the system lookup value.
     *
     * @param systemLookupValue the new system lookup value
     */
    public void setSystemLookupValue(String systemLookupValue) {
        this.systemLookupValue = systemLookupValue;
    }

    
    /**
     * Gets the system lookup precedence.
     *
     * @return the system lookup precedence
     */
    @Column(name="SYSTEM_LOOKUP_PRECEDENCE", nullable=false)
    public int getSystemLookupPrecedence() {
        return this.systemLookupPrecedence;
    }
    
    /**
     * Sets the system lookup precedence.
     *
     * @param systemLookupPrecedence the new system lookup precedence
     */
    public void setSystemLookupPrecedence(int systemLookupPrecedence) {
        this.systemLookupPrecedence = systemLookupPrecedence;
    }

    
    /**
     * Gets the description.
     *
     * @return the description
     */
    @Column(name="DESCRIPTION", length=240)
    public String getDescription() {
        return this.description;
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
     * Gets the remarks.
     *
     * @return the remarks
     */
    @Column(name="REMARKS", length=240)
    public String getRemarks() {
        return this.remarks;
    }
    
    /**
     * Sets the remarks.
     *
     * @param remarks the new remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }




}


