package org.gaddiel.form;

import java.util.List;

public class CollectionRegistersForm {

	private int collectionId;
	private String familyId;
	private String modeOfPay;
	private String amount;
	private String receiptNo;
	private String receiptDate;
  	private List<CollectionRegistersSubForm> collectionRegistersSubForm;
	private String newMode;
	private List newModeList;
  	
	public List<CollectionRegistersSubForm> getCollectionRegistersSubForm() {
		return collectionRegistersSubForm;
	}
	public void setCollectionRegistersSubForm(
			List<CollectionRegistersSubForm> collectionRegistersSubForm) {
		this.collectionRegistersSubForm = collectionRegistersSubForm;
	}
	public int getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
	public String getFamilyId() {
		return familyId;
	}
	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}
	public String getModeOfPay() {
		return modeOfPay;
	}
	public void setModeOfPay(String modeOfPay) {
		this.modeOfPay = modeOfPay;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	public String getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}
	public String getNewMode() {
		return newMode;
	}
	public void setNewMode(String newMode) {
		this.newMode = newMode;
	}
	public List getNewModeList() {
		return newModeList;
	}
	public void setNewModeList(List newModeList) {
		this.newModeList = newModeList;
	}
	
	
}
