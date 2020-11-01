package ca.bc.gov.open.pssg.docmerge.service;

import ca.bc.gov.open.pssg.docmerge.exception.MergeException;
import ca.bc.gov.open.pssg.docmerge.model.PDFMergeRequest;
import ca.bc.gov.open.pssg.docmerge.model.PDFMergeResponse;

/**
 * 
 * PDF Merging Service Interface 
 * 
 * @author shaunmillargov
 *
 */
public interface MergeService {

	public PDFMergeResponse mergePDFDocuments(PDFMergeRequest request, String correlationId) throws MergeException; 
	
}




