package ca.bc.gov.open.pssg.docmerge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Basic option flags for merge process. 
 * 
 * @author shaunmillargov
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "forcePDFAOnLoad", "createToC" })
public class Options {
	
	@JsonProperty("forcePDFAOnLoad")
	private Boolean forcePDFAOnLoad;
	
	@JsonProperty("createToC")
	private Boolean createToC;

	@JsonProperty("forcePDFAOnLoad")
	public Boolean getForcePDFAOnLoad() {
		return forcePDFAOnLoad;
	}

	@JsonProperty("forcePDFAOnLoad")
	public void setForcePDFAOnLoad(Boolean forcePDFAOnLoad) {
		this.forcePDFAOnLoad = forcePDFAOnLoad;
	}

	@JsonProperty("createToC")
	public Boolean getCreateToC() {
		return createToC;
	}

	@JsonProperty("createToC")
	public void setCreateToC(Boolean createToC) {
		this.createToC = createToC;
	}
	
	
	
}
