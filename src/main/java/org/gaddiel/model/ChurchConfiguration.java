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
 * ChurchConfiguration generated by hbm2java.
 */
@Entity
@Table(name="church_configuration" )

public class ChurchConfiguration  implements java.io.Serializable {


     /** The church id. */
     private Integer churchId;
     
     /** The church code. */
     private String churchCode;
     
     /** The church name. */
     private String churchName;
     
     /** The church patron. */
     private String churchPatron;
     
     /** The church motto. */
     private String churchMotto;
     
     /** The church theme. */
     private String churchTheme;
     
     /** The sys church lv id. */
     private Integer sysChurchLvId;
     
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
     
     /** The church global id. */
     private Integer churchGlobalId;

    /**
     * Instantiates a new church configuration.
     */
    public ChurchConfiguration() {
    }

	
    /**
     * Instantiates a new church configuration.
     *
     * @param churchCode the church code
     * @param churchName the church name
     * @param createdDate the created date
     * @param lastUpdatedDate the last updated date
     */
    public ChurchConfiguration(String churchCode, String churchName, Date createdDate, Date lastUpdatedDate) {
        this.churchCode = churchCode;
        this.churchName = churchName;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }
    
    /**
     * Instantiates a new church configuration.
     *
     * @param churchCode the church code
     * @param churchName the church name
     * @param churchPatron the church patron
     * @param churchMotto the church motto
     * @param churchTheme the church theme
     * @param sysChurchLvId the sys church lv id
     * @param description the description
     * @param remarks the remarks
     * @param createdBy the created by
     * @param createdDate the created date
     * @param lastUpdatedBy the last updated by
     * @param lastUpdatedDate the last updated date
     * @param churchGlobalId the church global id
     */
    public ChurchConfiguration(String churchCode, String churchName, String churchPatron, String churchMotto, String churchTheme, Integer sysChurchLvId, String description, String remarks, String createdBy, Date createdDate, String lastUpdatedBy, Date lastUpdatedDate, Integer churchGlobalId) {
       this.churchCode = churchCode;
       this.churchName = churchName;
       this.churchPatron = churchPatron;
       this.churchMotto = churchMotto;
       this.churchTheme = churchTheme;
       this.sysChurchLvId = sysChurchLvId;
       this.description = description;
       this.remarks = remarks;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.lastUpdatedBy = lastUpdatedBy;
       this.lastUpdatedDate = lastUpdatedDate;
       this.churchGlobalId = churchGlobalId;
    }
   
     /**
      * Gets the church id.
      *
      * @return the church id
      */
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="CHURCH_ID", unique=true, nullable=false)
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
     * Gets the church code.
     *
     * @return the church code
     */
    @Column(name="CHURCH_CODE", nullable=false, length=5)
    public String getChurchCode() {
        return this.churchCode;
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
    @Column(name="CHURCH_NAME", nullable=false, length=120)
    public String getChurchName() {
        return this.churchName;
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
     * Gets the church patron.
     *
     * @return the church patron
     */
    @Column(name="CHURCH_PATRON", length=120)
    public String getChurchPatron() {
        return this.churchPatron;
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
     * Gets the church motto.
     *
     * @return the church motto
     */
    @Column(name="CHURCH_MOTTO", length=250)
    public String getChurchMotto() {
        return this.churchMotto;
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
    @Column(name="CHURCH_THEME", length=250)
    public String getChurchTheme() {
        return this.churchTheme;
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
     * Gets the sys church lv id.
     *
     * @return the sys church lv id
     */
    @Column(name="SYS_CHURCH_LV_ID")
    public Integer getSysChurchLvId() {
        return this.sysChurchLvId;
    }
    
    /**
     * Sets the sys church lv id.
     *
     * @param sysChurchLvId the new sys church lv id
     */
    public void setSysChurchLvId(Integer sysChurchLvId) {
        this.sysChurchLvId = sysChurchLvId;
    }

    
    /**
     * Gets the description.
     *
     * @return the description
     */
    @Column(name="DESCRIPTION", length=250)
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
     * Gets the remarks.
     *
     * @return the remarks
     */
    @Column(name="REMARKS", length=2000)
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
     * Gets the church global id.
     *
     * @return the church global id
     */
    @Column(name="CHURCH_GLOBAL_ID")
    public Integer getChurchGlobalId() {
        return this.churchGlobalId;
    }
    
    /**
     * Sets the church global id.
     *
     * @param churchGlobalId the new church global id
     */
    public void setChurchGlobalId(Integer churchGlobalId) {
        this.churchGlobalId = churchGlobalId;
    }




}


