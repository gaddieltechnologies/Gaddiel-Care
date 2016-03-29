package org.gaddiel.form;

public class CollectionRegistersSubForm {

	
	private int collectionId;
	private int familyId;
	private String modeOfPay;
	private int amount;
	private String receiptNo;
	private String receiptDate;
	private String lastPaidUpto;
	
	
	public String getLastPaidUpto() {
		return lastPaidUpto;
	}
	public void setLastPaidUpto(String lastPaidUpto) {
		this.lastPaidUpto = lastPaidUpto;
	}
	public int getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}
	public String getModeOfPay() {
		return modeOfPay;
	}
	public void setModeOfPay(String modeOfPay) {
		this.modeOfPay = modeOfPay;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
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
	
	 
}
