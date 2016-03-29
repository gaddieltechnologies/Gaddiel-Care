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
 * SystemRolePrivileges generated by hbm2java.
 */
@Entity
@Table(name="system_role_privileges")

public class SystemRolePrivileges  implements java.io.Serializable {


     /** The role privilge id. */
     private Integer rolePrivilgeId;
     
     /** The role id. */
     private Integer roleId;
     
     /** The subscriber function id. */
     private int subscriberFunctionId;
     
     /** The read flag. */
     private String readFlag;
     
     /** The insert flag. */
     private String insertFlag;
     
     /** The update flag. */
     private String updateFlag;
     
     /** The delete flag. */
     private String deleteFlag;
     
     /** The report flg. */
     private String reportFlg;
     
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
     * Instantiates a new system role privileges.
     */
    public SystemRolePrivileges() {
    }

	
    /**
     * Instantiates a new system role privileges.
     *
     * @param subscriberFunctionId the subscriber function id
     * @param createdDate the created date
     * @param lastUpdatedDate the last updated date
     */
    public SystemRolePrivileges(int subscriberFunctionId, Date createdDate, Date lastUpdatedDate) {
        this.subscriberFunctionId = subscriberFunctionId;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }
    
    /**
     * Instantiates a new system role privileges.
     *
     * @param roleId the role id
     * @param subscriberFunctionId the subscriber function id
     * @param readFlag the read flag
     * @param insertFlag the insert flag
     * @param updateFlag the update flag
     * @param deleteFlag the delete flag
     * @param reportFlg the report flg
     * @param enabledFlag the enabled flag
     * @param startDate the start date
     * @param endDate the end date
     * @param createdBy the created by
     * @param createdDate the created date
     * @param lastUpdatedBy the last updated by
     * @param lastUpdatedDate the last updated date
     * @param remarks the remarks
     */
    public SystemRolePrivileges(Integer roleId, int subscriberFunctionId, String readFlag, String insertFlag, String updateFlag, String deleteFlag, String reportFlg, String enabledFlag, Date startDate, Date endDate, String createdBy, Date createdDate, String lastUpdatedBy, Date lastUpdatedDate, String remarks) {
       this.roleId = roleId;
       this.subscriberFunctionId = subscriberFunctionId;
       this.readFlag = readFlag;
       this.insertFlag = insertFlag;
       this.updateFlag = updateFlag;
       this.deleteFlag = deleteFlag;
       this.reportFlg = reportFlg;
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
      * Gets the role privilge id.
      *
      * @return the role privilge id
      */
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ROLE_PRIVILGE_ID", unique=true, nullable=false)
    public Integer getRolePrivilgeId() {
        return this.rolePrivilgeId;
    }
    
    /**
     * Sets the role privilge id.
     *
     * @param rolePrivilgeId the new role privilge id
     */
    public void setRolePrivilgeId(Integer rolePrivilgeId) {
        this.rolePrivilgeId = rolePrivilgeId;
    }

    
    /**
     * Gets the role id.
     *
     * @return the role id
     */
    @Column(name="ROLE_ID")
    public Integer getRoleId() {
        return this.roleId;
    }
    
    /**
     * Sets the role id.
     *
     * @param roleId the new role id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    
    /**
     * Gets the subscriber function id.
     *
     * @return the subscriber function id
     */
    @Column(name="SUBSCRIBER_FUNCTION_ID", nullable=false)
    public int getSubscriberFunctionId() {
        return this.subscriberFunctionId;
    }
    
    /**
     * Sets the subscriber function id.
     *
     * @param subscriberFunctionId the new subscriber function id
     */
    public void setSubscriberFunctionId(int subscriberFunctionId) {
        this.subscriberFunctionId = subscriberFunctionId;
    }

    
    /**
     * Gets the read flag.
     *
     * @return the read flag
     */
    @Column(name="READ_FLAG", length=1)
    public String getReadFlag() {
        return this.readFlag;
    }
    
    /**
     * Sets the read flag.
     *
     * @param readFlag the new read flag
     */
    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    
    /**
     * Gets the insert flag.
     *
     * @return the insert flag
     */
    @Column(name="INSERT_FLAG", length=1)
    public String getInsertFlag() {
        return this.insertFlag;
    }
    
    /**
     * Sets the insert flag.
     *
     * @param insertFlag the new insert flag
     */
    public void setInsertFlag(String insertFlag) {
        this.insertFlag = insertFlag;
    }

    
    /**
     * Gets the update flag.
     *
     * @return the update flag
     */
    @Column(name="UPDATE_FLAG", length=1)
    public String getUpdateFlag() {
        return this.updateFlag;
    }
    
    /**
     * Sets the update flag.
     *
     * @param updateFlag the new update flag
     */
    public void setUpdateFlag(String updateFlag) {
        this.updateFlag = updateFlag;
    }

    
    /**
     * Gets the delete flag.
     *
     * @return the delete flag
     */
    @Column(name="DELETE_FLAG", length=1)
    public String getDeleteFlag() {
        return this.deleteFlag;
    }
    
    /**
     * Sets the delete flag.
     *
     * @param deleteFlag the new delete flag
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    
    /**
     * Gets the report flg.
     *
     * @return the report flg
     */
    @Column(name="REPORT_FLG", length=1)
    public String getReportFlg() {
        return this.reportFlg;
    }
    
    /**
     * Sets the report flg.
     *
     * @param reportFlg the new report flg
     */
    public void setReportFlg(String reportFlg) {
        this.reportFlg = reportFlg;
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


