package ca.bc.gov.open.pssg.pdfmerge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "quitOnFailure", "forcePDFAOnLoad" })
public class Options {

	@JsonProperty("quitOnFailure")
	private Boolean quitOnFailure;
	
	@JsonProperty("forcePDFAOnLoad")
	private Boolean forcePDFAOnLoad;

	@JsonProperty("quitOnFailure")
	public Boolean getQuitOnFailure() {
		return quitOnFailure;
	}

	@JsonProperty("quitOnFailure")
	public void setQuitOnFailure(Boolean quitOnFailure) {
		this.quitOnFailure = quitOnFailure;
	}

	@JsonProperty("forcePDFAOnLoad")
	public Boolean getForcePDFAOnLoad() {
		return forcePDFAOnLoad;
	}

	@JsonProperty("forcePDFAOnLoad")
	public void setForcePDFAOnLoad(Boolean forcePDFAOnLoad) {
		this.forcePDFAOnLoad = forcePDFAOnLoad;
	}
	
}
