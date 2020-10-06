package ca.bc.gov.open.pssg.pdfmerge.utils;


/**
 * 
 * Digital Forms Constants. 
 * 
 * @author shaunmillargov
 *
 */
public final class PDFMergeConstants {
	
	private PDFMergeConstants() {
	      //not called
	}
    
    public static final String JSON_RESPONSE_SUCCESS = "success";
    public static final String JSON_RESPONSE_FAIL = "fail";
    
    public static final String NOT_PROCESSED_ERROR = "Request cannot be processed. See logging for correlation id %s";
	
	// rest response media type
	public static final String JSON_CONTENT = "application/json";
	
	// mime types
	public static final String PDF_MIME_TYPE = "application/pdf"; 
	
	//DDX output name
	public static final String DDX_OUTPUT_NAME = "out.pdf";
	public static final String DDX_NAMESPACE = "http://ns.adobe.com/DDX/1.0/";
 
}
