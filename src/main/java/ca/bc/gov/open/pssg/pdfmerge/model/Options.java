package ca.bc.gov.open.pssg.pdfmerge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "quitOnFailure" })
public class Options {

	@JsonProperty("quitOnFailure")
	private Boolean quitOnFailure;

	@JsonProperty("quitOnFailure")
	public Boolean getQuitOnFailure() {
		return quitOnFailure;
	}

	@JsonProperty("quitOnFailure")
	public void setQuitOnFailure(Boolean quitOnFailure) {
		this.quitOnFailure = quitOnFailure;
	}

}
