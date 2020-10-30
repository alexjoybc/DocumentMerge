/**
 * @(#)PDFBoxUtilities.java
 * Copyright (c) 2012, B.C. Ministry of Attorney General.
 * All rights reserved.
 */
package ca.bc.gov.open.pssg.pdfmerge.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.interactive.form.PDXFAResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import ca.bc.gov.open.pssg.pdfmerge.exception.MergeException;

/**
 * 
 * PDF Box Utilities 
 * 
 * @author shaunmillargov
 *
 */
public class PDFBoxUtilities {

	private final static Logger logger = LoggerFactory.getLogger(PDFBoxUtilities.class);	

	/**
	 * isPDFXfa() - returns boolean indicating if document is XFA (Smartform) type. 
	 * 
	 * @param pdfFile
	 * @return
	 */
	public static boolean isPDFXfa(byte[] pdfFile) {
		
		boolean isXFA = false;
		PDDocument doc = null;
		try {
			doc =  getPDDocFromBytes(pdfFile);
			PDXFAResource xfa = doc.getDocumentCatalog().getAcroForm().getXFA();
			isXFA = (null != xfa) ? true : false;
		} catch (MergeException | NullPointerException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {			
			try {
				doc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return isXFA;

	}
	
	/**
	 * 
	 * getPDDocFromBytes() - loads a PDDocument from a byte array. 
	 * 
	 * @param pdfFile
	 * @return
	 * @throws MergeException
	 */
	private static PDDocument getPDDocFromBytes(byte[] pdfFile) throws MergeException {
		
		ByteArrayInputStream bis = new ByteArrayInputStream(pdfFile);
			
		try {
			return PDDocument.load(bis);
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
			throw new MergeException("Password Protected PDF.", HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			e.printStackTrace();
			throw new MergeException("File not a PDF.", HttpStatus.NOT_FOUND);
		}
		
	}

	/**
     * isEncrypted()- determines if PDF is password protected.
     * @param pddocument
     * @return
	 * @throws MergeException 
     * @throws IOException
     */
	public static boolean isEncrypted(byte[] pdfFile) throws MergeException {
		
		PDDocument doc =  getPDDocFromBytes(pdfFile);

		if (doc.isEncrypted()) {
			return true;
		} else {
			return false;
		}
	}
	
//	/**
//	 * isXFA() - determines if smartform or not. 
//	 * @param doc
//	 * @return
//	 */
//    public static boolean isXFA(byte[] pdfFile) {
//    	
//    	log.debug("checking if smartform...");
//    	
//    	PDDocument doc =  getPDDocFromBytes(pdfFile);
//    	
//    	boolean isXFA = false; 
//		try {
//			PDXFAResource xfa = doc.getDocumentCatalog().getAcroForm().getXFA();
//			isXFA = (null != xfa) ? true : false; 
//		} catch (Exception ex) {
//			isXFA = false;
//		} finally {
//			try {
//				doc.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return isXFA; 
//	}
  
	public static int getNumPages(byte[] pdfFile) throws MergeException {
		int pages = getPDDocFromBytes(pdfFile).getNumberOfPages();
		return pages;
	}

}
