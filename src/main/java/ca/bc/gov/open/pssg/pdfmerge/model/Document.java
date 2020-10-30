package ca.bc.gov.open.pssg.pdfmerge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "mediaType", "placement", "data" })
public class Document {

	@JsonProperty("id")
	private String id;
	@JsonProperty("docType")
	private String docType;
	@JsonProperty("order")
	private Integer order;
	@JsonProperty("data")
	private String data;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("docType")
	public String getDocType() {
		return docType;
	}

	@JsonProperty("docType")
	public void setDocType(String docType) {
		this.docType = docType;
	}

	@JsonProperty("order")
	public Integer getOrder() {
		return order;
	}

	@JsonProperty("order")
	public void setOrder(Integer order) {
		this.order = order;
	}

	@JsonProperty("data")
	public String getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(String data) {
		this.data = data;
	}

}
