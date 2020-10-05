package ca.bc.gov.open.pssg.pdfmerge.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.bc.gov.open.pssg.pdfmerge.exception.PDFMergeException;
import ca.bc.gov.open.pssg.pdfmerge.model.PDFMergeRequest;
import ca.bc.gov.open.pssg.pdfmerge.utils.PDFMergeConstants;

@RestController
public class MergeController {

	@PostMapping(value = {"/merge/{correlationId}" }, 
			consumes = PDFMergeConstants.JSON_CONTENT, 
			produces = PDFMergeConstants.JSON_CONTENT)
	public boolean mergeDocumentPost(
			@Valid @RequestBody(required = true)  PDFMergeRequest request) throws PDFMergeException {
		
				return false;
	}

}
