package ca.bc.gov.open.pssg.pdfmerge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "mediaType", "placement", "data" })
public class Document {

	@JsonProperty("id")
	private String id;
	@JsonProperty("mediaType")
	private String mediaType;
	@JsonProperty("placement")
	private Integer placement;
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

	@JsonProperty("mediaType")
	public String getMediaType() {
		return mediaType;
	}

	@JsonProperty("mediaType")
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	@JsonProperty("placement")
	public Integer getPlacement() {
		return placement;
	}

	@JsonProperty("placement")
	public void setPlacement(Integer placement) {
		this.placement = placement;
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
