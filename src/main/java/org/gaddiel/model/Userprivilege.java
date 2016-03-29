package org.gaddiel.model;

public class Userprivilege implements java.io.Serializable {
	private String readflag;
	private String deleteflag;
	private String  insertflag;
	private String updateflag;
	private String functionname;
	private String functionId;
	private String reportflag;
	
	public String getReportflag() {
		return reportflag;
	}
	public void setReportflag(String reportflag) {
		this.reportflag = reportflag;
	}
	public String getReadflag() {
		return readflag;
	}
	public void setReadflag(String readflag) {
		this.readflag = readflag;
	}
	public String getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	public String getInsertflag() {
		return insertflag;
	}
	public void setInsertflag(String insertflag) {
		this.insertflag = insertflag;
	}
	public String getUpdateflag() {
		return updateflag;
	}
	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}
	public String getFunctionname() {
		return functionname;
	}
	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

}
