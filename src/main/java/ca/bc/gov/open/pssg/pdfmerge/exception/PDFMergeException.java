package ca.bc.gov.open.pssg.pdfmerge.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom Exception for PDF Merge
 * 
 * @author sivakaruna
 */
public class PDFMergeException extends Exception {

	private static final long serialVersionUID = 5873442413088571528L;

	private final HttpStatus httpStatus;

	public PDFMergeException(String message, HttpStatus status) {
		super(message);
		this.httpStatus = status;
	}

	public PDFMergeException(String message, HttpStatus status, Throwable cause) {
		super(message, cause);
		this.httpStatus = status;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
