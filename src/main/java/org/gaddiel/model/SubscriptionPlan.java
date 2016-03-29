package org.gaddiel.model;
// default package
// Generated May 17, 2012 11:25:14 AM by Hibernate Tools 3.4.0.CR1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SubscriptionPlan generated by hbm2java
 */
@Entity
@Table(name="subscription_plan"

)
public class SubscriptionPlan  implements java.io.Serializable {


     private Integer subsPlanId;
     private Integer familyId;
     private String createdBy;
     private Date createdDate;
     private String lastUpdatedBy;
     private Date lastUpdatedDate;
     private String enabledFlag;
     private Integer subsAmount;
     private Date startDate;
     private Date endDate;
     private String remarks;

    public SubscriptionPlan() {
    }

	
    public SubscriptionPlan(Date createdDate, Date lastUpdatedDate) {
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }
    public SubscriptionPlan(Integer familyId, String createdBy, Date createdDate, String lastUpdatedBy, Date lastUpdatedDate, String enabledFlag, Integer subsAmount, Date startDate, Date endDate, String remarks) {
       this.familyId = familyId;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.lastUpdatedBy = lastUpdatedBy;
       this.lastUpdatedDate = lastUpdatedDate;
       this.enabledFlag = enabledFlag;
       this.subsAmount = subsAmount;
       this.startDate = startDate;
       this.endDate = endDate;
       this.remarks = remarks;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="SUBS_PLAN_ID", unique=true, nullable=false)
    public Integer getSubsPlanId() {
        return this.subsPlanId;
    }
    
    public void setSubsPlanId(Integer subsPlanId) {
        this.subsPlanId = subsPlanId;
    }

    
    @Column(name="FAMILY_ID")
    public Integer getFamilyId() {
        return this.familyId;
    }
    
    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
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

    
    @Column(name="ENABLED_FLAG", length=1)
    public String getEnabledFlag() {
        return this.enabledFlag;
    }
    
    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    
    @Column(name="SUBS_AMOUNT")
    public Integer getSubsAmount() {
        return this.subsAmount;
    }
    
    public void setSubsAmount(Integer subsAmount) {
        this.subsAmount = subsAmount;
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

    
    @Column(name="REMARKS", length=240)
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }




}

