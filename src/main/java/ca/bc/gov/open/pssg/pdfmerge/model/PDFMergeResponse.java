package ca.bc.gov.open.pssg.pdfmerge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "document", "mimeType" })
public class PDFMergeResponse {

	@JsonProperty("document")
	private String document;
	@JsonProperty("mimeType")
	private String mimeType;

	@JsonProperty("document")
	public String getDocument() {
		return document;
	}

	@JsonProperty("document")
	public void setDocument(String document) {
		this.document = document;
	}

	@JsonProperty("mimeType")
	public String getMimeType() {
		return mimeType;
	}

	@JsonProperty("mimeType")
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

}