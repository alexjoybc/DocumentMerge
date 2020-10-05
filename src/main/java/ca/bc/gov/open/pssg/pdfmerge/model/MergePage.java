package ca.bc.gov.open.pssg.pdfmerge.model;

import java.util.UUID;

public class MergePage {
	
	private String id; 
	private byte[] file;
	private String errorCd = null;
	private String errorMsg = null;

	public MergePage(byte[] file) {
		UUID uniqueKey = UUID.randomUUID();
		this.id = uniqueKey.toString();
		this.file = file; 
	}
	
	public String getId() {
		return id;
	}
	
	public byte[] getFile() {
		return file;
	}
	
	public String getErrorCd() {
		return errorCd;
	}

	public void setErrorCd(String errorCd) {
		this.errorCd = errorCd;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
