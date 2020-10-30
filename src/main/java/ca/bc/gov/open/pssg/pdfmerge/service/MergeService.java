package ca.bc.gov.open.pssg.pdfmerge.service;

import ca.bc.gov.open.pssg.pdfmerge.exception.MergeException;
import ca.bc.gov.open.pssg.pdfmerge.model.PDFMergeRequest;
import ca.bc.gov.open.pssg.pdfmerge.model.PDFMergeResponse;

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




