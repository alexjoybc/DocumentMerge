package ca.bc.gov.open.pssg.pdfmerge.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "options", "documents" })
public class PDFMergeRequest {

	@JsonProperty("options")
	private Options options;
	@JsonProperty("documents")
	private List<Document> documents = null;

	@JsonProperty("options")
	public Options getOptions() {
		return options;
	}

	@JsonProperty("options")
	public void setOptions(Options options) {
		this.options = options;
	}

	@JsonProperty("documents")
	public List<Document> getDocuments() {
		return documents;
	}

	@JsonProperty("documents")
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

}
