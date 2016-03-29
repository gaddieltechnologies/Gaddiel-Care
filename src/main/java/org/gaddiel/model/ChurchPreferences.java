package org.gaddiel.model;
// default package
// Generated Mar 30, 2012 6:02:41 PM by Hibernate Tools 3.4.0.CR1


// default package
// Generated May 14, 2012 11:31:25 AM by Hibernate Tools 3.4.0.CR1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * ChurchPreferences generated by hbm2java
 */
@Entity
@Table(name="church_preferences", uniqueConstraints = @UniqueConstraint(columnNames="SYSTEM_LOOKUP_VALUE_ID") 
)
public class ChurchPreferences  implements java.io.Serializable {


     private Integer churchPreferenceId;
     private Integer systemLookupValueId;
     private Integer churchId;
     private String description;
     private String enabledFlag;
     private Date startDate;
     private Date endDate;
     private String createdBy;
     private Date createdDate;
     private String lastUpdatedBy;
     private Date lastUpdatedDate;
     private Integer customLookupValueId;

    public ChurchPreferences() {
    }

	
    public ChurchPreferences(Date createdDate, Date lastUpdatedDate) {
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }
    public ChurchPreferences(Integer systemLookupValueId, Integer churchId, String description, String enabledFlag, Date startDate, Date endDate, String createdBy, Date createdDate, String lastUpdatedBy, Date lastUpdatedDate, Integer customLookupValueId) {
       this.systemLookupValueId = systemLookupValueId;
       this.churchId = churchId;
       this.description = description;
       this.enabledFlag = enabledFlag;
       this.startDate = startDate;
       this.endDate = endDate;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.lastUpdatedBy = lastUpdatedBy;
       this.lastUpdatedDate = lastUpdatedDate;
       this.customLookupValueId = customLookupValueId;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="CHURCH_PREFERENCE_ID", unique=true, nullable=false)
    public Integer getChurchPreferenceId() {
        return this.churchPreferenceId;
    }
    
    public void setChurchPreferenceId(Integer churchPreferenceId) {
        this.churchPreferenceId = churchPreferenceId;
    }

    
    @Column(name="SYSTEM_LOOKUP_VALUE_ID", unique=true)
    public Integer getSystemLookupValueId() {
        return this.systemLookupValueId;
    }
    
    public void setSystemLookupValueId(Integer systemLookupValueId) {
        this.systemLookupValueId = systemLookupValueId;
    }

    
    @Column(name="CHURCH_ID")
    public Integer getChurchId() {
        return this.churchId;
    }
    
    public void setChurchId(Integer churchId) {
        this.churchId = churchId;
    }

    
    @Column(name="DESCRIPTION", length=250)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="ENABLED_FLAG", length=1)
    public String getEnabledFlag() {
        return this.enabledFlag;
    }
    
    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE", length=10)
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE", length=10)
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    @Column(name="CREATED_BY", length=60)
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_DATE", nullable=false, length=19)
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    
    @Column(name="LAST_UPDATED_BY", length=60)
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }
    
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_UPDATED_DATE", nullable=false, length=19)
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }
    
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    
    @Column(name="CUSTOM_LOOKUP_VALUE_ID")
    public Integer getCustomLookupValueId() {
        return this.customLookupValueId;
    }
    
    public void setCustomLookupValueId(Integer customLookupValueId) {
        this.customLookupValueId = customLookupValueId;
    }




}


